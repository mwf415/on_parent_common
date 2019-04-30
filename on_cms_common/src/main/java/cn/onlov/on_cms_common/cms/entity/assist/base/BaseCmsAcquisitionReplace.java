package cn.onlov.on_cms_common.cms.entity.assist.base;

import cn.onlov.on_cms_common.cms.entity.assist.CmsAcquisition;
import cn.onlov.on_cms_common.cms.entity.assist.CmsAcquisitionReplace;

import java.io.Serializable;

public abstract class BaseCmsAcquisitionReplace implements Serializable {
	public static String REF = "CmsAcquisitionReplace";
	public static String PROP_KEYWORD = "keyword";
	public static String PROP_REPLACE_WORD = "replaceWord";
	public static String PROP_ACQUISTION = "acquistion";
	
	// constructors
	public BaseCmsAcquisitionReplace () {
		initialize();
	}
		
	/**
	 * Constructor for primary key
	 */
	public BaseCmsAcquisitionReplace (Integer id) {
		this.setId(id);
		initialize();
	}
	
	/**
	 * Constructor for required fields
	 */
	public BaseCmsAcquisitionReplace (
		Integer id,
		CmsAcquisition acquisition,
		String keyword,
		String replaceWord) {

		this.setId(id);
		this.setAcquisition(acquisition);
		this.setKeyword(keyword);
		this.setReplaceWord(replaceWord);
		initialize();
	}

	protected void initialize () {}

	private int hashCode = Integer.MIN_VALUE;
	
	// primary key
	private Integer id;

	// fields
	private String keyword;
	private String replaceWord;
	
	// many to one	
	private CmsAcquisition acquisition;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getReplaceWord() {
		return replaceWord;
	}

	public void setReplaceWord(String replaceWord) {
		this.replaceWord = replaceWord;
	}

	public CmsAcquisition getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(CmsAcquisition acquisition) {
		this.acquisition = acquisition;
	}
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof CmsAcquisitionReplace)) return false;
		else {
			CmsAcquisitionReplace cmsAcquisitionReplace = (CmsAcquisitionReplace) obj;
			if (null == this.getId() || null == cmsAcquisitionReplace.getId()) return false;
			else return (this.getId().equals(cmsAcquisitionReplace.getId()));
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId()) return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString () {
		return super.toString();
	}

}
