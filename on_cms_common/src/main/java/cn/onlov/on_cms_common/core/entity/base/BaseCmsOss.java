package cn.onlov.on_cms_common.core.entity.base;

import cn.onlov.on_cms_common.core.entity.CmsOss;

import java.io.Serializable;

/**
 * This is an object that contains data related to the jc_oss table. Do not
 * modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class table="jc_oss"
 */

public abstract class BaseCmsOss implements Serializable {

	public static String REF = "CmsOss";
	public static String PROP_BUCKET_NAME = "bucketName";
	public static String PROP_APP_ID = "appId";
	public static String PROP_APP_KEY = "appKey";
	public static String PROP_BUCKET_AREA = "bucketArea";
	public static String PROP_ID = "id";
	public static String PROP_OSS_TYPE = "ossType";

	// constructors
	public BaseCmsOss() {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsOss(Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */

	protected void initialize() {
	}

	public BaseCmsOss(String ossAppId, String secretId, String appKey, String bucketName, String bucketArea,
			String endPoint, String accessDomain, Byte ossType) {
		super();
		this.ossAppId = ossAppId;
		this.secretId = secretId;
		this.appKey = appKey;
		this.bucketName = bucketName;
		this.bucketArea = bucketArea;
		this.endPoint = endPoint;
		this.accessDomain = accessDomain;
		this.ossType = ossType;
	}

	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private String ossAppId;
	private String secretId;
	private String appKey;
	private String bucketName;
	private String bucketArea;
	private String endPoint;
	private String accessDomain;
	private String name;
	private Byte ossType;

	/**
	 * Return the unique identifier of this class
	 * 
	 * @hibernate.id generator-class="sequence" column="id"
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * 
	 * @param id
	 *            the new ID
	 */
	public void setId(Integer id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}

	public String getOssAppId() {
		return ossAppId;
	}

	public void setOssAppId(String ossAppId) {
		this.ossAppId = ossAppId;
	}

	public String getSecretId() {
		return secretId;
	}

	public void setSecretId(String secretId) {
		this.secretId = secretId;
	}

	/**
	 * Return the value associated with the column: app_key
	 */
	public String getAppKey() {
		return appKey;
	}

	/**
	 * Set the value related to the column: app_key
	 * 
	 * @param appKey
	 *            the app_key value
	 */
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

	/**
	 * Return the value associated with the column: bucket_name
	 */
	public String getBucketName() {
		return bucketName;
	}

	/**
	 * Set the value related to the column: bucket_name
	 * 
	 * @param bucketName
	 *            the bucket_name value
	 */
	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	/**
	 * Return the value associated with the column: bucket_area
	 */
	public String getBucketArea() {
		return bucketArea;
	}

	/**
	 * Set the value related to the column: bucket_area
	 * 
	 * @param bucketArea
	 *            the bucket_area value
	 */
	public void setBucketArea(String bucketArea) {
		this.bucketArea = bucketArea;
	}

	public String getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	/**
	 * 阿里云存储accessDomain设置不带http://
	 * 七牛云存储accessDomain得设置带http://
	 * @return
	 */
	public String getAccessDomain() {
		return accessDomain;
	}

	public void setAccessDomain(String accessDomain) {
		this.accessDomain = accessDomain;
	}

	/**
	 * Return the value associated with the column: oss_type
	 */
	public Byte getOssType() {
		return ossType;
	}

	/**
	 * Set the value related to the column: oss_type
	 * 
	 * @param ossType
	 *            the oss_type value
	 */
	public void setOssType(Byte ossType) {
		this.ossType = ossType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object obj) {
		if (null == obj)
			return false;
		if (!(obj instanceof CmsOss))
			return false;
		else {
			CmsOss cmsOss = (CmsOss) obj;
			if (null == this.getId() || null == cmsOss.getId())
				return false;
			else
				return (this.getId().equals(cmsOss.getId()));
		}
	}

	public int hashCode() {
		if (Integer.MIN_VALUE == this.hashCode) {
			if (null == this.getId())
				return super.hashCode();
			else {
				String hashStr = this.getClass().getName() + ":" + this.getId().hashCode();
				this.hashCode = hashStr.hashCode();
			}
		}
		return this.hashCode;
	}

	public String toString() {
		return super.toString();
	}

}