package cn.onlov.cms.common.core.security;

import cn.onlov.cms.common.cms.web.CmsThreadVariable;
import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.core.entity.CmsUser;
import cn.onlov.cms.common.core.entity.UnifiedUser;
import cn.onlov.cms.common.core.manager.CmsUserMng;
import cn.onlov.cms.common.core.manager.UnifiedUserMng;
import cn.onlov.cms.common.core.web.util.CmsUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义DB Realm
 * 
 */
@Component
public class CmsAuthorizingRealm extends AuthorizingRealm {

	/**
	 * 登录认证
	 */
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		CmsUser user = cmsUserMng.findByUsername(token.getUsername());
		if (user != null) {
			UnifiedUser unifiedUser = unifiedUserMng.findById(user.getId());
			return new SimpleAuthenticationInfo(user.getUsername(), CmsUtils.md5Password((unifiedUser.getPassword())), getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权
	 */
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		CmsUser user = cmsUserMng.findByUsername(username);
		CmsSite site= CmsThreadVariable.getSite();
		SimpleAuthorizationInfo auth = new SimpleAuthorizationInfo();
		if (user != null) {
			Set<String>viewPermissionSet=new HashSet<String>();
			Set<String> perms = user.getPerms(site.getId(),viewPermissionSet);
			if (!CollectionUtils.isEmpty(perms)) {
				// 权限加入AuthorizationInfo认证对象
				auth.setStringPermissions(perms);
			}
		}
		return auth;
	}
	
	public void removeUserAuthorizationInfoCache(String username){
		  SimplePrincipalCollection pc = new SimplePrincipalCollection();
		  pc.add(username, super.getName()); 
		  super.clearCachedAuthorizationInfo(pc);
	}

	protected CmsUserMng cmsUserMng;
	protected UnifiedUserMng unifiedUserMng;

	@Autowired
	public void setCmsUserMng(CmsUserMng cmsUserMng) {
		this.cmsUserMng = cmsUserMng;
	}

	@Autowired
	public void setUnifiedUserMng(UnifiedUserMng unifiedUserMng) {
		this.unifiedUserMng = unifiedUserMng;
	}

}
