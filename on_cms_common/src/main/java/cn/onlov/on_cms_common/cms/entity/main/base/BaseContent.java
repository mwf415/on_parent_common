package cn.onlov.on_cms_common.cms.entity.main.base;

import cn.onlov.on_cms_common.cms.entity.assist.CmsComment;
import cn.onlov.on_cms_common.cms.entity.assist.CmsFile;
import cn.onlov.on_cms_common.cms.entity.assist.CmsJobApply;
import cn.onlov.on_cms_common.cms.entity.assist.CmsScoreRecord;
import cn.onlov.on_cms_common.cms.entity.main.*;
import cn.onlov.on_cms_common.core.entity.CmsGroup;
import cn.onlov.on_cms_common.core.entity.CmsSite;
import cn.onlov.on_cms_common.core.entity.CmsUser;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jc_content table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_content"
 */

public abstract class BaseContent  implements Serializable {

	public static String REF = "Content";
	public static String PROP_STATUS = "status";
	public static String PROP_TYPE = "type";
	public static String PROP_RECOMMEND = "recommend";
	public static String PROP_SITE = "site";
	public static String PROP_USER = "user";
	public static String PROP_HAS_TITLE_IMG = "hasTitleImg";
	public static String PROP_SORT_DATE = "sortDate";
	public static String PROP_TOP_LEVEL = "topLevel";
	public static String PROP_COMMENTS_DAY = "commentsDay";
	public static String PROP_CONTENT_EXT = "contentExt";
	public static String PROP_VIEWS_DAY = "viewsDay";
	public static String PROP_UPS_DAY = "upsDay";
	public static String PROP_CHANNEL = "channel";
	public static String PROP_CONTENT_COUNT = "contentCount";
	public static String PROP_ID = "id";
	public static String PROP_DOWNLOADS_DAY = "downloadsDay";


	// constructors
	public BaseContent () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseContent (Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseContent (
		Integer id,
		CmsSite site,
		java.util.Date sortDate,
		Byte topLevel,
		Boolean hasTitleImg,
		Boolean recommend,
		Byte status,
		Integer viewsDay,
		Short commentsDay,
		Short downloadsDay,
		Short upsDay) {

		this.setId(id);
		this.setSite(site);
		this.setSortDate(sortDate);
		this.setTopLevel(topLevel);
		this.setHasTitleImg(hasTitleImg);
		this.setRecommend(recommend);
		this.setStatus(status);
		this.setViewsDay(viewsDay);
		this.setCommentsDay(commentsDay);
		this.setDownloadsDay(downloadsDay);
		this.setUpsDay(upsDay);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private java.util.Date sortDate;
	private Byte topLevel;
	private Boolean hasTitleImg;
	private Boolean recommend;
	private Byte status;
	private Integer viewsDay;
	private Short commentsDay;
	private Short downloadsDay;
	private Short upsDay;
	private Integer score;
	private Byte recommendLevel;

	// one to one
	private ContentExt contentExt;
	private ContentCount contentCount;

	// many to one
	private ContentType type;
	private CmsSite site;
	private CmsUser user;
	private Channel channel;
	private CmsModel model;

	// collections
	private java.util.Set<Channel> channels;
	private java.util.Set<CmsTopic> topics;
	private java.util.Set<CmsGroup> viewGroups;
	private java.util.List<ContentTag> tags;
	private java.util.List<ContentPicture> pictures;
	private java.util.List<ContentAttachment> attachments;
	private java.util.Set<ContentTxt> contentTxtSet;
	private java.util.Set<ContentCheck> contentCheckSet;
	private java.util.Set<ContentCharge> contentChargeSet;
	private java.util.Set<ContentBuy> contentBuySet;
	private java.util.Map<String, String> attr;
	private java.util.Set<CmsUser> collectUsers;
	private java.util.Set<CmsComment> comments;
	private java.util.Set<CmsFile> files;
	private java.util.Set<CmsJobApply> jobApplys;
	private java.util.Set<CmsScoreRecord> scoreRecordSet;
	private java.util.Set<ContentRecord> contentRecordSet;
	private java.util.List<ContentRewardFix> rewardFixs;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="content_id"
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
	 * Return the value associated with the column: sort_date
	 */
	public java.util.Date getSortDate () {
		return sortDate;
	}

	/**
	 * Set the value related to the column: sort_date
	 * @param sortDate the sort_date value
	 */
	public void setSortDate (java.util.Date sortDate) {
		this.sortDate = sortDate;
	}


	/**
	 * Return the value associated with the column: top_level
	 */
	public Byte getTopLevel () {
		return topLevel;
	}

	/**
	 * Set the value related to the column: top_level
	 * @param topLevel the top_level value
	 */
	public void setTopLevel (Byte topLevel) {
		this.topLevel = topLevel;
	}


	/**
	 * Return the value associated with the column: has_title_img
	 */
	public Boolean getHasTitleImg () {
		return hasTitleImg;
	}

	/**
	 * Set the value related to the column: has_title_img
	 * @param hasTitleImg the has_title_img value
	 */
	public void setHasTitleImg (Boolean hasTitleImg) {
		this.hasTitleImg = hasTitleImg;
	}


	/**
	 * Return the value associated with the column: is_recommend
	 */
	public Boolean getRecommend () {
		return recommend;
	}

	/**
	 * Set the value related to the column: is_recommend
	 * @param recommend the is_recommend value
	 */
	public void setRecommend (Boolean recommend) {
		this.recommend = recommend;
	}


	/**
	 * Return the value associated with the column: status
	 */
	public Byte getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (Byte status) {
		this.status = status;
	}


	/**
	 * Return the value associated with the column: views_day
	 */
	public Integer getViewsDay () {
		return viewsDay;
	}

	/**
	 * Set the value related to the column: views_day
	 * @param viewsDay the views_day value
	 */
	public void setViewsDay (Integer viewsDay) {
		this.viewsDay = viewsDay;
	}


	/**
	 * Return the value associated with the column: comments_day
	 */
	public Short getCommentsDay () {
		return commentsDay;
	}

	/**
	 * Set the value related to the column: comments_day
	 * @param commentsDay the comments_day value
	 */
	public void setCommentsDay (Short commentsDay) {
		this.commentsDay = commentsDay;
	}
	


	public java.util.Set<CmsFile> getFiles() {
		return files;
	}

	public void setFiles(java.util.Set<CmsFile> files) {
		this.files = files;
	}
	
	public java.util.Set<CmsJobApply> getJobApplys() {
			return jobApplys;
	}
	
	public void setJobApplys(
				java.util.Set<CmsJobApply> jobApplys) {
			this.jobApplys = jobApplys;
	}
	

	

	public java.util.Set<CmsScoreRecord> getScoreRecordSet() {
		return scoreRecordSet;
	}

	public void setScoreRecordSet(
			java.util.Set<CmsScoreRecord> scoreRecordSet) {
		this.scoreRecordSet = scoreRecordSet;
	}
	

	public java.util.Set<ContentRecord> getContentRecordSet() {
		return contentRecordSet;
	}

	public void setContentRecordSet(java.util.Set<ContentRecord> contentRecordSet) {
		this.contentRecordSet = contentRecordSet;
	}

	public java.util.List<ContentRewardFix> getRewardFixs() {
		return rewardFixs;
	}

	public void setRewardFixs(java.util.List<ContentRewardFix> rewardFixs) {
		this.rewardFixs = rewardFixs;
	}

	/**
	 * Return the value associated with the column: downloads_day
	 */
	public Short getDownloadsDay () {
		return downloadsDay;
	}

	/**
	 * Set the value related to the column: downloads_day
	 * @param downloadsDay the downloads_day value
	 */
	public void setDownloadsDay (Short downloadsDay) {
		this.downloadsDay = downloadsDay;
	}


	/**
	 * Return the value associated with the column: ups_day
	 */
	public Short getUpsDay () {
		return upsDay;
	}

	/**
	 * Set the value related to the column: ups_day
	 * @param upsDay the ups_day value
	 */
	public void setUpsDay (Short upsDay) {
		this.upsDay = upsDay;
	}
	

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Byte getRecommendLevel() {
		return recommendLevel;
	}

	public void setRecommendLevel(Byte recommendLevel) {
		this.recommendLevel = recommendLevel;
	}

	/**
	 * Return the value associated with the column: contentExt
	 */
	public ContentExt getContentExt () {
		return contentExt;
	}

	/**
	 * Set the value related to the column: contentExt
	 * @param contentExt the contentExt value
	 */
	public void setContentExt (ContentExt contentExt) {
		this.contentExt = contentExt;
	}


	/**
	 * Return the value associated with the column: contentCount
	 */
	public ContentCount getContentCount () {
		return contentCount;
	}

	/**
	 * Set the value related to the column: contentCount
	 * @param contentCount the contentCount value
	 */
	public void setContentCount (ContentCount contentCount) {
		this.contentCount = contentCount;
	}


	/**
	 * Return the value associated with the column: type_id
	 */
	public ContentType getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type_id
	 * @param type the type_id value
	 */
	public void setType (ContentType type) {
		this.type = type;
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


	/**
	 * Return the value associated with the column: user_id
	 */
	public CmsUser getUser () {
		return user;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param user the user_id value
	 */
	public void setUser (CmsUser user) {
		this.user = user;
	}


	/**
	 * Return the value associated with the column: channel_id
	 */
	public Channel getChannel () {
		return channel;
	}

	/**
	 * Set the value related to the column: channel_id
	 * @param channel the channel_id value
	 */
	public void setChannel (Channel channel) {
		this.channel = channel;
	}
	
	public CmsModel getModel() {
		return model;
	}

	public void setModel(CmsModel model) {
		this.model = model;
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

	/**
	 * Return the value associated with the column: topics
	 */
	public java.util.Set<CmsTopic> getTopics () {
		return topics;
	}

	/**
	 * Set the value related to the column: topics
	 * @param topics the topics value
	 */
	public void setTopics (java.util.Set<CmsTopic> topics) {
		this.topics = topics;
	}


	/**
	 * Return the value associated with the column: viewGroups
	 */
	public java.util.Set<CmsGroup> getViewGroups () {
		return viewGroups;
	}

	/**
	 * Set the value related to the column: viewGroups
	 * @param viewGroups the viewGroups value
	 */
	public void setViewGroups (java.util.Set<CmsGroup> viewGroups) {
		this.viewGroups = viewGroups;
	}


	/**
	 * Return the value associated with the column: tags
	 */
	public java.util.List<ContentTag> getTags () {
		return tags;
	}

	/**
	 * Set the value related to the column: tags
	 * @param tags the tags value
	 */
	public void setTags (java.util.List<ContentTag> tags) {
		this.tags = tags;
	}


	/**
	 * Return the value associated with the column: pictures
	 */
	public java.util.List<ContentPicture> getPictures () {
		return pictures;
	}

	/**
	 * Set the value related to the column: pictures
	 * @param pictures the pictures value
	 */
	public void setPictures (java.util.List<ContentPicture> pictures) {
		this.pictures = pictures;
	}


	/**
	 * Return the value associated with the column: attachments
	 */
	public java.util.List<ContentAttachment> getAttachments () {
		return attachments;
	}

	/**
	 * Set the value related to the column: attachments
	 * @param attachments the attachments value
	 */
	public void setAttachments (java.util.List<ContentAttachment> attachments) {
		this.attachments = attachments;
	}


	/**
	 * Return the value associated with the column: contentTxtSet
	 */
	public java.util.Set<ContentTxt> getContentTxtSet () {
		return contentTxtSet;
	}

	/**
	 * Set the value related to the column: contentTxtSet
	 * @param contentTxtSet the contentTxtSet value
	 */
	public void setContentTxtSet (java.util.Set<ContentTxt> contentTxtSet) {
		this.contentTxtSet = contentTxtSet;
	}


	/**
	 * Return the value associated with the column: contentCheckSet
	 */
	public java.util.Set<ContentCheck> getContentCheckSet () {
		return contentCheckSet;
	}

	/**
	 * Set the value related to the column: contentCheckSet
	 * @param contentCheckSet the contentCheckSet value
	 */
	public void setContentCheckSet (java.util.Set<ContentCheck> contentCheckSet) {
		this.contentCheckSet = contentCheckSet;
	}
	
	public java.util.Set<ContentCharge> getContentChargeSet() {
		return contentChargeSet;
	}

	public void setContentChargeSet(java.util.Set<ContentCharge> contentChargeSet) {
		this.contentChargeSet = contentChargeSet;
	}

	public java.util.Set<ContentBuy> getContentBuySet() {
		return contentBuySet;
	}

	public void setContentBuySet(java.util.Set<ContentBuy> contentBuySet) {
		this.contentBuySet = contentBuySet;
	}

	/**
	 * Return the value associated with the column: attr
	 */
	public java.util.Map<String, String> getAttr () {
		return attr;
	}
	

	public java.util.Set<CmsUser> getCollectUsers() {
		return collectUsers;
	}

	public void setCollectUsers(
			java.util.Set<CmsUser> collectUsers) {
		this.collectUsers = collectUsers;
	}
	

	public java.util.Set<CmsComment> getComments() {
		return comments;
	}

	public void setComments(
			java.util.Set<CmsComment> comments) {
		this.comments = comments;
	}

	/**
	 * Set the value related to the column: attr
	 * @param attr the attr value
	 */
	public void setAttr (java.util.Map<String, String> attr) {
		this.attr = attr;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof Content)) return false;
		else {
			Content content = (Content) obj;
			if (null == this.getId() || null == content.getId()) return false;
			else return (this.getId().equals(content.getId()));
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