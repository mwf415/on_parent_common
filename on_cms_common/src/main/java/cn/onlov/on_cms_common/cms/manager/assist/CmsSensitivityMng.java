package cn.onlov.on_cms_common.cms.manager.assist;

import java.util.List;

import cn.onlov.on_cms_common.cms.entity.assist.CmsSensitivity;

public interface CmsSensitivityMng {

	public String replaceSensitivity(String s);
	
	public boolean haveSensitivity(String... arrays);

	public List<CmsSensitivity> getList(boolean cacheable);

	public CmsSensitivity findById(Integer id);

	public CmsSensitivity save(CmsSensitivity bean);

	public void updateEnsitivity(Integer[] ids, String[] searchs,
			String[] replacements);

	public CmsSensitivity deleteById(Integer id);

	public CmsSensitivity[] deleteByIds(Integer[] ids);
}