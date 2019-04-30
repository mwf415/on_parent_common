package cn.onlov.on_cms_common.cms.manager.main;

import java.util.List;
import java.util.Map;

import cn.onlov.on_cms_common.cms.entity.main.Channel;
import cn.onlov.on_cms_common.cms.entity.main.ChannelExt;
import cn.onlov.on_cms_common.cms.entity.main.ChannelTxt;
import cn.onlov.on_cms_common.common.page.Pagination;

/**
 * 栏目管理接口
 * 
 */
public interface ChannelMng {
	/**
	 * 获得顶级栏目
	 * 
	 * @param siteId
	 *            站点ID
	 * @param hasContentOnly
	 *            是否只获得有内容的栏目
	 * @return
	 */
	public List<Channel> getTopList(Integer siteId, boolean hasContentOnly);

	public List<Channel> getTopListByRigth(Integer userId, Integer siteId,boolean hasContentOnly);

	public List<Channel> getTopListForTag(Integer siteId, boolean hasContentOnly);

	public Pagination getTopPageForTag(Integer siteId, boolean hasContentOnly, int pageNo, int pageSize);

	public List<Channel> getChildList(Integer parentId, boolean hasContentOnly);

	public List<Channel> getChildListByRight(Integer userId, Integer siteId,Integer parentId, boolean hasContentOnly);

	public List<Channel> getChildListForTag(Integer parentId,boolean hasContentOnly);
	
	public List<Channel> getBottomList(Integer siteId,boolean hasContentOnly);

	public Pagination getChildPageForTag(Integer parentId,boolean hasContentOnly, int pageNo, int pageSize);

	
	public Channel findByPath(String path, Integer siteId);

	public Channel findByPathForTag(String path, Integer siteId);

	public Channel findById(Integer id);

	public Channel save(Channel bean, ChannelExt ext, ChannelTxt txt,
                        Integer[] viewGroupIds, Integer[] contriGroupIds,
                        Integer[] userIds, Integer siteId, Integer parentId,
                        Integer modelId, Integer[]modelIds,
                        String[] tpls, String[] mtpls, boolean isCopy);
	
	public Channel copy(Integer cid,String solution, String mobileSolution, Integer siteId, Map<String, String> pathMap);
	

	public Channel update(Channel bean, ChannelExt ext, ChannelTxt txt,
			Integer[] viewGroupIds, Integer[] contriGroupIds,
			Integer[] userIds, Integer parentId, Map<String, String> attr, Integer modelId,
			Integer[]modelIds,String[] tpls,String[] mtpls);

	public Channel deleteById(Integer id);

	public Channel[] deleteByIds(Integer[] ids);

	public Channel[] updatePriority(Integer[] ids, Integer[] priority);
	
	public void initWorkFlow(Integer workflowId);

	public String checkDelete(Integer id);
}