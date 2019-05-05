package cn.onlov.cms.common.core.entity.base;

import java.io.Serializable;

import cn.onlov.cms.common.cms.entity.assist.CmsJobApply;
import cn.onlov.cms.common.cms.entity.assist.CmsMessage;
import cn.onlov.cms.common.cms.entity.assist.CmsReceiverMessage;
import cn.onlov.cms.common.cms.entity.assist.CmsUserMenu;
import cn.onlov.cms.common.cms.entity.main.*;
import cn.onlov.cms.common.core.entity.*;


/**
 * This is an object that contains data related to the jc_user table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_user"
 */

public abstract class BaseCmsUser  implements Serializable {

	public static String REF = "CmsUser";
	public static String PROP_REGISTER_TIME = "registerTime";
	public static String PROP_LOGIN_COUNT = "loginCount";
	public static String PROP_SELF_ADMIN = "selfAdmin";
	public static String PROP_UPLOAD_TOTAL = "uploadTotal";
	public static String PROP_LAST_LOGIN_IP = "lastLoginIp";
	public static String PROP_DISABLED = "disabled";
	public static String PROP_LAST_LOGIN_TIME = "lastLoginTime";
	public static String PROP_UPLOAD_DATE = "uploadDate";
	public static String PROP_GROUP = "group";
	public static String PROP_EMAIL = "email";
	public static String PROP_UPLOAD_SIZE = "uploadSize";
	public static String PROP_RANK = "rank";
	public static String PROP_VIEWONLY_ADMIN = "viewonlyAdmin";
	public static String PROP_ADMIN = "admin";
	public static String PROP_ID = "id";
	public static String PROP_REGISTER_IP = "registerIp";
	public static String PROP_USERNAME = "username";


	// constructors
	public BaseCmsUser () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsUser (Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsUser (
		Integer id,
		CmsGroup group,
		String username,
		java.util.Date registerTime,
		String registerIp,
		Integer loginCount,
		Integer rank,
		Long uploadTotal,
		Integer uploadSize,
		Boolean admin,
		Boolean viewonlyAdmin,
		Boolean selfAdmin,
		Integer statu) {

		this.setId(id);
		this.setGroup(group);
		this.setUsername(username);
		this.setRegisterTime(registerTime);
		this.setRegisterIp(registerIp);
		this.setLoginCount(loginCount);
		this.setRank(rank);
		this.setUploadTotal(uploadTotal);
		this.setUploadSize(uploadSize);
		this.setAdmin(admin);
		this.setViewonlyAdmin(viewonlyAdmin);
		this.setSelfAdmin(selfAdmin);
		this.setStatu(statu);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private String username;
	private String email;
	private java.util.Date registerTime;
	private String registerIp;
	private java.util.Date lastLoginTime;
	private String lastLoginIp;
	private Integer loginCount;
	private Integer rank;
	private Long uploadTotal;
	private Integer uploadSize;
	private java.sql.Date uploadDate;
	private Boolean admin;
	private Boolean viewonlyAdmin;
	private Boolean selfAdmin;
	private Integer statu;
	private String sessionId;

	// many to one
	private CmsGroup group;

	// collections
	private java.util.Map<String, String> attr;
	private java.util.Set<CmsUserExt> userExtSet;
	private java.util.Set<CmsUserAccount> userAccountSet;
	private java.util.Set<CmsUserSite> userSites;
	private java.util.Set<CmsRole> roles;
	private java.util.Set<Channel> channels;
	private java.util.Set<Content> collectContents;
	private java.util.Set<ContentBuy> buyContentSet;
	
	private java.util.Set<CmsMessage> sendMessages;
	private java.util.Set<CmsMessage> receivMessages;
	private java.util.Set<CmsReceiverMessage> sendReceiverMessages;
	private java.util.Set<CmsReceiverMessage> receivReceiverMessages;
	
	private java.util.Set<CmsJobApply> jobApplys;
	private java.util.Set<CmsUserResume> userResumeSet;
	private java.util.Set<CmsLog> logs;
	private java.util.Set<CmsUserMenu> menus;
	private java.util.Set<ContentRecord> contentRecordSet;
	private java.util.Set<CmsThirdAccount> thirdAccounts;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="assigned"
     *  column="user_id"
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
	 * Return the value associated with the column: username
	 */
	public String getUsername () {
		return username;
	}

	/**
	 * Set the value related to the column: username
	 * @param username the username value
	 */
	public void setUsername (String username) {
		this.username = username;
	}


	/**
	 * Return the value associated with the column: email
	 */
	public String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (String email) {
		this.email = email;
	}


	/**
	 * Return the value associated with the column: register_time
	 */
	public java.util.Date getRegisterTime () {
		return registerTime;
	}

	/**
	 * Set the value related to the column: register_time
	 * @param registerTime the register_time value
	 */
	public void setRegisterTime (java.util.Date registerTime) {
		this.registerTime = registerTime;
	}


	/**
	 * Return the value associated with the column: register_ip
	 */
	public String getRegisterIp () {
		return registerIp;
	}

	/**
	 * Set the value related to the column: register_ip
	 * @param registerIp the register_ip value
	 */
	public void setRegisterIp (String registerIp) {
		this.registerIp = registerIp;
	}


	/**
	 * Return the value associated with the column: last_login_time
	 */
	public java.util.Date getLastLoginTime () {
		return lastLoginTime;
	}

	/**
	 * Set the value related to the column: last_login_time
	 * @param lastLoginTime the last_login_time value
	 */
	public void setLastLoginTime (java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}


	/**
	 * Return the value associated with the column: last_login_ip
	 */
	public String getLastLoginIp () {
		return lastLoginIp;
	}

	/**
	 * Set the value related to the column: last_login_ip
	 * @param lastLoginIp the last_login_ip value
	 */
	public void setLastLoginIp (String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}


	/**
	 * Return the value associated with the column: login_count
	 */
	public Integer getLoginCount () {
		return loginCount;
	}

	/**
	 * Set the value related to the column: login_count
	 * @param loginCount the login_count value
	 */
	public void setLoginCount (Integer loginCount) {
		this.loginCount = loginCount;
	}


	/**
	 * Return the value associated with the column: rank
	 */
	public Integer getRank () {
		return rank;
	}

	/**
	 * Set the value related to the column: rank
	 * @param rank the rank value
	 */
	public void setRank (Integer rank) {
		this.rank = rank;
	}


	/**
	 * Return the value associated with the column: upload_total
	 */
	public Long getUploadTotal () {
		return uploadTotal;
	}

	/**
	 * Set the value related to the column: upload_total
	 * @param uploadTotal the upload_total value
	 */
	public void setUploadTotal (Long uploadTotal) {
		this.uploadTotal = uploadTotal;
	}


	/**
	 * Return the value associated with the column: upload_size
	 */
	public Integer getUploadSize () {
		return uploadSize;
	}

	/**
	 * Set the value related to the column: upload_size
	 * @param uploadSize the upload_size value
	 */
	public void setUploadSize (Integer uploadSize) {
		this.uploadSize = uploadSize;
	}


	/**
	 * Return the value associated with the column: upload_date
	 */
	public java.sql.Date getUploadDate () {
		return uploadDate;
	}

	/**
	 * Set the value related to the column: upload_date
	 * @param uploadDate the upload_date value
	 */
	public void setUploadDate (java.sql.Date uploadDate) {
		this.uploadDate = uploadDate;
	}


	/**
	 * Return the value associated with the column: is_admin
	 */
	public Boolean getAdmin () {
		return admin;
	}

	/**
	 * Set the value related to the column: is_admin
	 * @param admin the is_admin value
	 */
	public void setAdmin (Boolean admin) {
		this.admin = admin;
	}


	/**
	 * Return the value associated with the column: is_viewonly_admin
	 */
	public Boolean getViewonlyAdmin () {
		return viewonlyAdmin;
	}

	/**
	 * Set the value related to the column: is_viewonly_admin
	 * @param viewonlyAdmin the is_viewonly_admin value
	 */
	public void setViewonlyAdmin (Boolean viewonlyAdmin) {
		this.viewonlyAdmin = viewonlyAdmin;
	}


	/**
	 * Return the value associated with the column: is_self_admin
	 */
	public Boolean getSelfAdmin () {
		return selfAdmin;
	}

	/**
	 * Set the value related to the column: is_self_admin
	 * @param selfAdmin the is_self_admin value
	 */
	public void setSelfAdmin (Boolean selfAdmin) {
		this.selfAdmin = selfAdmin;
	}

	public Integer getStatu() {
		return statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}
	
	
	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * Return the value associated with the column: group_id
	 */
	public CmsGroup getGroup () {
		return group;
	}

	/**
	 * Set the value related to the column: group_id
	 * @param group the group_id value
	 */
	public void setGroup (CmsGroup group) {
		this.group = group;
	}
	
	public java.util.Map<String, String> getAttr() {
		return attr;
	}

	public void setAttr(java.util.Map<String, String> attr) {
		this.attr = attr;
	}

	/**
	 * Return the value associated with the column: userExtSet
	 */
	public java.util.Set<CmsUserExt> getUserExtSet () {
		return userExtSet;
	}

	/**
	 * Set the value related to the column: userExtSet
	 * @param userExtSet the userExtSet value
	 */
	public void setUserExtSet (java.util.Set<CmsUserExt> userExtSet) {
		this.userExtSet = userExtSet;
	}
	
	public java.util.Set<CmsUserAccount> getUserAccountSet() {
		return userAccountSet;
	}

	public void setUserAccountSet(java.util.Set<CmsUserAccount> userAccountSet) {
		this.userAccountSet = userAccountSet;
	}

	/**
	 * Return the value associated with the column: userSites
	 */
	public java.util.Set<CmsUserSite> getUserSites () {
		return userSites;
	}

	/**
	 * Set the value related to the column: userSites
	 * @param userSites the userSites value
	 */
	public void setUserSites (java.util.Set<CmsUserSite> userSites) {
		this.userSites = userSites;
	}


	/**
	 * Return the value associated with the column: roles
	 */
	public java.util.Set<CmsRole> getRoles () {
		return roles;
	}

	/**
	 * Set the value related to the column: roles
	 * @param roles the roles value
	 */
	public void setRoles (java.util.Set<CmsRole> roles) {
		this.roles = roles;
	}

	/**
	 * Return the value associated with the column: channels
	 */
	public java.util.Set<Channel> getChannels () {
		return channels;
	}

	/**
	 * Set the value related to the column: channels
	 * @param channels the channels value
	 */
	public void setChannels (java.util.Set<Channel> channels) {
		this.channels = channels;
	}
	

	public java.util.Set<Content> getCollectContents() {
		return collectContents;
	}

	public void setCollectContents(
			java.util.Set<Content> collectContents) {
		this.collectContents = collectContents;
	}
	
	public java.util.Set<ContentBuy> getBuyContentSet() {
		return buyContentSet;
	}

	public void setBuyContentSet(java.util.Set<ContentBuy> buyContentSet) {
		this.buyContentSet = buyContentSet;
	}

	public java.util.Set<CmsMessage> getSendMessages() {
		return sendMessages;
	}

	public void setSendMessages(
			java.util.Set<CmsMessage> sendMessages) {
		this.sendMessages = sendMessages;
	}

	public java.util.Set<CmsMessage> getReceivMessages() {
		return receivMessages;
	}

	public void setReceivMessages(
			java.util.Set<CmsMessage> receivMessages) {
		this.receivMessages = receivMessages;
	}

	public java.util.Set<CmsReceiverMessage> getSendReceiverMessages() {
		return sendReceiverMessages;
	}

	public void setSendReceiverMessages(
			java.util.Set<CmsReceiverMessage> sendReceiverMessages) {
		this.sendReceiverMessages = sendReceiverMessages;
	}

	public java.util.Set<CmsReceiverMessage> getReceivReceiverMessages() {
		return receivReceiverMessages;
	}

	public void setReceivReceiverMessages(
			java.util.Set<CmsReceiverMessage> receivReceiverMessages) {
		this.receivReceiverMessages = receivReceiverMessages;
	}
	
	public java.util.Set<CmsJobApply> getJobApplys() {
		return jobApplys;
	}

	public void setJobApplys(
				java.util.Set<CmsJobApply> jobApplys) {
			this.jobApplys = jobApplys;
		}
		
	public java.util.Set<CmsUserResume> getUserResumeSet() {
			return userResumeSet;
		}
	
	public void setUserResumeSet(
				java.util.Set<CmsUserResume> userResumeSet) {
			this.userResumeSet = userResumeSet;
	}

	public java.util.Set<CmsLog> getLogs() {
		return logs;
	}

	public void setLogs(java.util.Set<CmsLog> logs) {
		this.logs = logs;
	}

	public java.util.Set<CmsUserMenu> getMenus() {
		return menus;
	}

	public void setMenus(
			java.util.Set<CmsUserMenu> menus) {
		this.menus = menus;
	}

	
	public java.util.Set<ContentRecord> getContentRecordSet() {
		return contentRecordSet;
	}

	public void setContentRecordSet(java.util.Set<ContentRecord> contentRecordSet) {
		this.contentRecordSet = contentRecordSet;
	}

	public java.util.Set<CmsThirdAccount> getThirdAccounts() {
		return thirdAccounts;
	}

	public void setThirdAccounts(java.util.Set<CmsThirdAccount> thirdAccounts) {
		this.thirdAccounts = thirdAccounts;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof CmsUser)) return false;
		else {
			CmsUser cmsUser = (CmsUser) obj;
			if (null == this.getId() || null == cmsUser.getId()) return false;
			else return (this.getId().equals(cmsUser.getId()));
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