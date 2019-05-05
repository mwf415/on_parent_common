package cn.onlov.cms.common.cms.entity.assist.base;

import cn.onlov.cms.common.cms.entity.assist.CmsAcquisition;
import cn.onlov.cms.common.cms.entity.assist.CmsAcquisitionShield;

import java.io.Serializable;

public abstract class BaseCmsAcquisitionShield implements Serializable {
	public static String REF = "CmsAcquisitionReplace";
	public static String PROP_SHIELD_END = "shieldEnd";
	public static String PROP_SHIELD_START = "shieldStart";
	public static String PROP_ACQUISTION = "acquistion";
	
	// constructors
	public BaseCmsAcquisitionShield () {
		initialize();
	}
		
	/**
	 * Constructor for primary key
	 */
	public BaseCmsAcquisitionShield (Integer id) {
		this.setId(id);
		initialize();
	}
	
	/**
	 * Constructor for required fields
	 */
	public BaseCmsAcquisitionShield (
		Integer id,
		CmsAcquisition acquisition,
		String shieldStart,
		String shieldEnd) {

		this.setId(id);
		this.setAcquisition(acquisition);
		this.setShieldStart(shieldStart);
		this.setShieldEnd(shieldEnd);
		initialize();
	}

	protected void initialize () {}

	private int hashCode = Integer.MIN_VALUE;
	
	// primary key
	private Integer id;

	// fields
	private String shieldStart;
	private String shieldEnd;
	
	// many to one	
	private CmsAcquisition acquisition;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShieldStart() {
		return shieldStart;
	}

	public void setShieldStart(String shieldStart) {
		this.shieldStart = shieldStart;
	}

	public String getShieldEnd() {
		return shieldEnd;
	}

	public void setShieldEnd(String shieldEnd) {
		this.shieldEnd = shieldEnd;
	}

	public CmsAcquisition getAcquisition() {
		return acquisition;
	}

	public void setAcquisition(CmsAcquisition acquisition) {
		this.acquisition = acquisition;
	}
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof CmsAcquisitionShield)) return false;
		else {
			CmsAcquisitionShield cmsAcquisitionShield = (CmsAcquisitionShield) obj;
			if (null == this.getId() || null == cmsAcquisitionShield.getId()) return false;
			else return (this.getId().equals(cmsAcquisitionShield.getId()));
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
