package cn.onlov.cms.common.cms.manager.assist.impl;

import cn.onlov.cms.common.cms.dao.assist.CmsWebserviceAuthDao;
import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.common.security.encoder.PwdEncoder;
import cn.onlov.cms.common.cms.entity.assist.CmsWebserviceAuth;
import cn.onlov.cms.common.cms.manager.assist.CmsWebserviceAuthMng;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CmsWebserviceAuthMngImpl implements CmsWebserviceAuthMng {
	@Transactional(readOnly = true)
	public Pagination getPage(int pageNo, int pageSize) {
		Pagination page = dao.getPage(pageNo, pageSize);
		return page;
	}
	
	@Transactional(readOnly = true)
	public boolean isPasswordValid(String username, String password){
		CmsWebserviceAuth auth=findByUsername(username);
		if(auth!=null&&auth.getEnable()){
			return pwdEncoder.isPasswordValid(auth.getPassword(), password);
		}else{
			return false;
		}
	}

	@Transactional(readOnly = true)
	public CmsWebserviceAuth findByUsername(String username) {
		CmsWebserviceAuth entity = dao.findByUsername(username);
		return entity;
	}
	
	@Transactional(readOnly = true)
	public CmsWebserviceAuth findById(Integer id) {
		CmsWebserviceAuth entity = dao.findById(id);
		return entity;
	}

	public CmsWebserviceAuth save(CmsWebserviceAuth bean) {
		dao.save(bean);
		return bean;
	}

	public CmsWebserviceAuth update(CmsWebserviceAuth bean) {
		Updater<CmsWebserviceAuth> updater = new Updater<CmsWebserviceAuth>(bean);
		CmsWebserviceAuth entity = dao.updateByUpdater(updater);
		return entity;
	}
	
	public CmsWebserviceAuth update(Integer id,String username,String password,String system,Boolean enable){
		CmsWebserviceAuth entity =findById(id);
		if(StringUtils.isNotBlank(username)){
			entity.setUsername(username);
		}
		if(StringUtils.isNotBlank(password)){
			entity.setPassword(pwdEncoder.encodePassword(password));
		}
		if(StringUtils.isNotBlank(system)){
			entity.setSystem(system);
		}
		if(enable!=null){
			entity.setEnable(enable);
		}
		return entity;
	}

	public CmsWebserviceAuth deleteById(Integer id) {
		CmsWebserviceAuth bean = dao.deleteById(id);
		return bean;
	}
	
	public CmsWebserviceAuth[] deleteByIds(Integer[] ids) {
		CmsWebserviceAuth[] beans = new CmsWebserviceAuth[ids.length];
		for (int i = 0,len = ids.length; i < len; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}
	
	@Autowired
	private PwdEncoder pwdEncoder;
	private CmsWebserviceAuthDao dao;

	@Autowired
	public void setDao(CmsWebserviceAuthDao dao) {
		this.dao = dao;
	}
}