package cn.onlov.on_cms_common.cms.service;

/**
 * 搜索词缓存接口
 */
public interface SearchWordsCache {

	/**
	 * 搜索词汇缓存
	 * 
	 * @param id 
	 */
	public void cacheWord(String name);
}