package cn.onlov.on_cms_common.cms.action.directive;

import static cn.onlov.on_cms_common.core.web.util.FrontUtils.PARAM_STYLE_LIST;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.onlov.on_cms_common.cms.Constants;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.common.web.freemarker.DefaultObjectWrapperBuilderFactory;
import cn.onlov.on_cms_common.common.web.freemarker.DirectiveUtils;
import cn.onlov.on_cms_common.common.web.freemarker.ParamsRequiredException;
import org.apache.commons.lang.StringUtils;

import cn.onlov.on_cms_common.cms.action.directive.abs.AbstractCmsCommentDirective;
import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.web.util.FrontUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 评论分页标签
 */
public class CmsCommentPageDirective extends AbstractCmsCommentDirective {
	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "comment_page";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		CmsSite site = FrontUtils.getSite(env);
		Pagination page = cmsCommentMng.getPageForTag(null,
				getContentId(params), getGreaterThen(params),
				getChecked(params), getRecommend(params), getDesc(params),
				FrontUtils.getPageNo(env), FrontUtils.getCount(params));

		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(DirectiveUtils.OUT_PAGINATION, DefaultObjectWrapperBuilderFactory.getDefaultObjectWrapper().wrap(page));
		paramWrap.put(DirectiveUtils.OUT_LIST, DefaultObjectWrapperBuilderFactory.getDefaultObjectWrapper().wrap(page.getList()));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		DirectiveUtils.InvokeType type = DirectiveUtils.getInvokeType(params);
		String listStyle = DirectiveUtils.getString(PARAM_STYLE_LIST, params);
		if (DirectiveUtils.InvokeType.sysDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			env.include(Constants.TPL_STYLE_LIST + listStyle + Constants.TPL_SUFFIX, cn.onlov.on_cms_common.common.web.Constants.UTF8, true);
			FrontUtils.includePagination(site, params, env);
		} else if (DirectiveUtils.InvokeType.userDefined == type) {
			if (StringUtils.isBlank(listStyle)) {
				throw new ParamsRequiredException(PARAM_STYLE_LIST);
			}
			FrontUtils.includeTpl(Constants.TPL_STYLE_LIST, site, env);
			FrontUtils.includePagination(site, params, env);
		} else if (DirectiveUtils.InvokeType.custom == type) {
			FrontUtils.includeTpl(TPL_NAME, site, params, env);
			FrontUtils.includePagination(site, params, env);
		} else if (DirectiveUtils.InvokeType.body == type) {
			body.render(env.getOut());
			FrontUtils.includePagination(site, params, env);
		} else {
			throw new RuntimeException("invoke type not handled: " + type);
		}
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}

}
