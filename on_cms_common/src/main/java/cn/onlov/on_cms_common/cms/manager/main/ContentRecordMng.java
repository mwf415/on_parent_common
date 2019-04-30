package cn.onlov.on_cms_common.cms.manager.main;

import cn.onlov.on_cms_common.cms.entity.main.Content;
import cn.onlov.on_cms_common.cms.entity.main.ContentRecord;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.CmsUser;

import java.util.List;

public interface ContentRecordMng {
	public Pagination getPage(int pageNo, int pageSize);
	
	public List<ContentRecord>getListByContentId(Integer contentId);
	
	public ContentRecord record(Content content, CmsUser user, ContentRecord.ContentOperateType operate);

	public ContentRecord findById(Long id);

	public ContentRecord save(ContentRecord bean);

	public ContentRecord update(ContentRecord bean);

	public ContentRecord deleteById(Long id);
	
	public ContentRecord[] deleteByIds(Long[] ids);
}