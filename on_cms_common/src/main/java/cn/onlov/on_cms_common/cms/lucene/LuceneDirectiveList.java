package cn.onlov.on_cms_common.cms.lucene;

import cn.onlov.on_cms_common.cms.Constants;
import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.common.web.freemarker.DefaultObjectWrapperBuilderFactory;
import cn.onlov.on_cms_common.common.web.freemarker.DirectiveUtils;
import cn.onlov.on_cms_common.common.web.freemarker.ParamsRequiredException;
import cn.onlov.on_cms_common.common.web.springmvc.RealPathResolver;
import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.web.util.FrontUtils;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.apache.commons.lang.StringUtils;
import org.apache.lucene.queryParser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.onlov.on_cms_common.core.web.util.FrontUtils.PARAM_STYLE_LIST;

public class LuceneDirectiveList extends LuceneDirectiveAbstract {
	/**
	 * 模板名称
	 */
	public static final String TPL_NAME = "lucene_list";

	@SuppressWarnings("unchecked")
	public void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException {
		CmsSite site = FrontUtils.getSite(env);
		int first = FrontUtils.getFirst(params);
		int count = FrontUtils.getCount(params);
		String query = getQuery(params);
		String workplace= getWorkplace(params);
		String category= getCategory(params);
		Integer siteId = getSiteId(params);
		Integer channelId = getChannelId(params);
		Date startDate = getStartDate(params);
		Date endDate = getEndDate(params);
		List<Content> list;
		try {
			String path = realPathResolver.get(Constants.LUCENE_PATH);
			list = luceneContentSvc.searchList(path, query,category,workplace, siteId, channelId,
					startDate, endDate, first, count);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

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

	@Autowired
	private LuceneContentSvc luceneContentSvc;
	@Autowired
	private RealPathResolver realPathResolver;
}
