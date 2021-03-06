package cn.onlov.cms.common.cms.manager.main;

import java.util.List;

import cn.onlov.cms.common.cms.entity.main.ContentType;

public interface ContentTypeMng {
	public List<ContentType> getList(Boolean containDisabled);

	public ContentType getDef();

	public ContentType findById(Integer id);

	public ContentType save(ContentType bean);

	public ContentType update(ContentType bean);

	public ContentType deleteById(Integer id);

	public ContentType[] deleteByIds(Integer[] ids);
}