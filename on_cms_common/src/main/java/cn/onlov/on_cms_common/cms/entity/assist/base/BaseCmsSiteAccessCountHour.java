package cn.onlov.on_cms_common.cms.entity.assist.base;

import cn.onlov.on_cms_common.cms.entity.assist.CmsSiteAccessCountHour;
import cn.onlov.on_cms_common.core.entity.CmsSite;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jc_site_access_count_hour table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_site_access_count_hour"
 */

public abstract class BaseCmsSiteAccessCountHour  implements Serializable {

	public static String REF = "CmsSiteAccessCountHour";
	public static String PROP_SITE = "site";
	public static String PROP_ACCESS_HOUR = "accessHour";
	public static String PROP_HOUR_UV = "hourUv";
	public static String PROP_HOUR_PV = "hourPv";
	public static String PROP_ACCESS_DATE = "accessDate";
	public static String PROP_HOUR_IP = "hourIp";
	public static String PROP_ID = "id";


	// constructors
	public BaseCmsSiteAccessCountHour () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsSiteAccessCountHour (Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsSiteAccessCountHour (
		Integer id,
		CmsSite site,
		Long hourPv,
		Long hourIp,
		Long hourUv,
		java.util.Date accessDate,
		Integer accessHour) {

		this.setId(id);
		this.setSite(site);
		this.setHourPv(hourPv);
		this.setHourIp(hourIp);
		this.setHourUv(hourUv);
		this.setAccessDate(accessDate);
		this.setAccessHour(accessHour);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private Long hourPv;
	private Long hourIp;
	private Long hourUv;
	private java.util.Date accessDate;
	private Integer accessHour;

	// many to one
	private CmsSite site;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="access_count_hour_id"
     */
	public Integer getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: hour_pv
	 */
	public Long getHourPv () {
		return hourPv;
	}

	/**
	 * Set the value related to the column: hour_pv
	 * @param hourPv the hour_pv value
	 */
	public void setHourPv (Long hourPv) {
		this.hourPv = hourPv;
	}


	/**
	 * Return the value associated with the column: hour_ip
	 */
	public Long getHourIp () {
		return hourIp;
	}

	/**
	 * Set the value related to the column: hour_ip
	 * @param hourIp the hour_ip value
	 */
	public void setHourIp (Long hourIp) {
		this.hourIp = hourIp;
	}


	/**
	 * Return the value associated with the column: hour_uv
	 */
	public Long getHourUv () {
		return hourUv;
	}

	/**
	 * Set the value related to the column: hour_uv
	 * @param hourUv the hour_uv value
	 */
	public void setHourUv (Long hourUv) {
		this.hourUv = hourUv;
	}


	/**
	 * Return the value associated with the column: access_date
	 */
	public java.util.Date getAccessDate () {
		return accessDate;
	}

	/**
	 * Set the value related to the column: access_date
	 * @param accessDate the access_date value
	 */
	public void setAccessDate (java.util.Date accessDate) {
		this.accessDate = accessDate;
	}


	/**
	 * Return the value associated with the column: access_hour
	 */
	public Integer getAccessHour () {
		return accessHour;
	}

	/**
	 * Set the value related to the column: access_hour
	 * @param accessHour the access_hour value
	 */
	public void setAccessHour (Integer accessHour) {
		this.accessHour = accessHour;
	}


	/**
	 * Return the value associated with the column: site_id
	 */
	public CmsSite getSite () {
		return site;
	}

	/**
	 * Set the value related to the column: site_id
	 * @param site the site_id value
	 */
	public void setSite (CmsSite site) {
		this.site = site;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof CmsSiteAccessCountHour)) return false;
		else {
			CmsSiteAccessCountHour cmsSiteAccessCountHour = (CmsSiteAccessCountHour) obj;
			if (null == this.getId() || null == cmsSiteAccessCountHour.getId()) return false;
			else return (this.getId().equals(cmsSiteAccessCountHour.getId()));
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