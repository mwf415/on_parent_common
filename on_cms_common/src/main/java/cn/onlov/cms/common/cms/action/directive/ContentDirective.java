package cn.onlov.cms.common.cms.action.directive;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import cn.onlov.cms.common.common.web.freemarker.DefaultObjectWrapperBuilderFactory;
import cn.onlov.cms.common.common.web.freemarker.DirectiveUtils;
import cn.onlov.cms.common.common.web.freemarker.ParamsRequiredException;
import org.springframework.beans.factory.annotation.Autowired;

import cn.onlov.cms.common.cms.entity.main.Content;
import cn.onlov.cms.common.cms.manager.main.ContentMng;
import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.core.web.util.FrontUtils;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 内容对象标签
 */
public class ContentDirective implements TemplateDirectiveModel {
	/**
	 * 输入参数，栏目ID。
	 */
	public static final String PARAM_ID = "id";
	/**
	 * 输入参数，下一篇。
	 */
	public static final String PRAMA_NEXT = "next";
	/**
	 * 输入参数，栏目ID。
	 */
	public static final String PARAM_CHANNEL_ID = "channelId";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		Integer id = getId(params);
		Boolean next = DirectiveUtils.getBool(PRAMA_NEXT, params);
		Content content;
		if (next == null) {
			content = contentMng.findById(id);
		} else {
			CmsSite site = FrontUtils.getSite(env);
			Integer channelId = DirectiveUtils.getInt(PARAM_CHANNEL_ID, params);
			content = contentMng.getSide(id, site.getId(), channelId, next);
		}

		Map<String, TemplateModel> paramWrap = new HashMap<String, TemplateModel>(
				params);
		paramWrap.put(DirectiveUtils.OUT_BEAN, DefaultObjectWrapperBuilderFactory.getDefaultObjectWrapper().wrap(content));
		Map<String, TemplateModel> origMap = DirectiveUtils
				.addParamsToVariable(env, paramWrap);
		body.render(env.getOut());
		DirectiveUtils.removeParamsFromVariable(env, paramWrap, origMap);
	}

	private Integer getId(Map<String, TemplateModel> params)
			throws TemplateException {
		Integer id = DirectiveUtils.getInt(PARAM_ID, params);
		if (id != null) {
			return id;
		} else {
			throw new ParamsRequiredException(PARAM_ID);
		}
	}

	@Autowired
	private ContentMng contentMng;
}
