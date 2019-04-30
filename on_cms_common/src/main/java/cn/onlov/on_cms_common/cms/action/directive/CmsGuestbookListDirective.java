package cn.onlov.on_cms_common.cms.action.directive;

import static cn.onlov.on_cms_common.core.web.util.FrontUtils.PARAM_STYLE_LIST;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.onlov.on_cms_common.cms.Constants;
import cn.onlov.on_cms_common.common.web.freemarker.DefaultObjectWrapperBuilderFactory;
import cn.onlov.on_cms_common.common.web.freemarker.DirectiveUtils;
import cn.onlov.on_cms_common.common.web.freemarker.ParamsRequiredException;
import org.apache.commons.lang.StringUtils;

import cn.onlov.on_cms_common.cms.action.directive.abs.AbstractCmsGuestbookDirective;
import cn.onlov.on_cms_common.cms.entity.assist.CmsGuestbook;
import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.web.util.FrontUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 评论列表标签
 */
public class CmsGuestbookListDirective extends AbstractCmsGuestbookDirective {
	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "guestbook_list";

	/**
	 * 输入参数，内容ID。
	 */
	public static final String PARAM_SITE_ID = "siteId";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		CmsSite site = FrontUtils.getSite(env);
		int first = FrontUtils.getFirst(params);
		int max = FrontUtils.getCount(params);
		Short check = 0;
		if (getChecked(params)) {
			check =1;
		}
		List<CmsGuestbook> list = cmsGuestbookMng.getList(getSiteId(params),
				getCtgId(params),null, getRecommend(params), check,
				getDesc(params), true, first, max);

		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(DirectiveUtils.OUT_LIST, DefaultObjectWrapperBuilderFactory.getDefaultObjectWrapper().wrap(list));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		DirectiveUtils.InvokeType type = DirectiveUtils.getInvokeType(params);
		String listStyle = DirectiveUtils.getString(PARAM_STYLE_LIST, params);
		if (DirectiveUtils.InvokeType.sysDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			env.include(Constants.TPL_STYLE_LIST + listStyle + Constants.TPL_SUFFIX, cn.onlov.on_cms_common.common.web.Constants.UTF8, true);
		} else if (DirectiveUtils.InvokeType.userDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			FrontUtils.includeTpl(Constants.TPL_STYLE_LIST, site, env);
		} else if (DirectiveUtils.InvokeType.custom == type) {
			FrontUtils.includeTpl(TPL_NAME, site, params, env);
		} else if (DirectiveUtils.InvokeType.body == type) {
			body.render(env.getOut());
		} else {
			throw new RuntimeException("invoke type not handled: " + type);
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}
}
