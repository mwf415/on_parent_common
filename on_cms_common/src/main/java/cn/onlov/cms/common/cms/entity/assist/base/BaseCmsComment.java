package cn.onlov.cms.common.cms.entity.assist.base;

import java.io.Serializable;
import java.util.Set;

import cn.onlov.cms.common.core.entity.CmsSite;
import cn.onlov.cms.common.core.entity.CmsUser;
import cn.onlov.cms.common.cms.entity.assist.CmsComment;
import cn.onlov.cms.common.cms.entity.assist.CmsCommentExt;
import cn.onlov.cms.common.cms.entity.main.Content;


/**
 * This is an object that contains data related to the jc_comment table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_comment"
 */

public abstract class BaseCmsComment  implements Serializable {

	public static String REF = "CmsComment";
	public static String PROP_RECOMMEND = "recommend";
	public static String PROP_COMMENT_USER = "commentUser";
	public static String PROP_REPLAY_USER = "replayUser";
	public static String PROP_SITE = "site";
	public static String PROP_REPLAY_TIME = "replayTime";
	public static String PROP_CREATE_TIME = "createTime";
	public static String PROP_DOWNS = "downs";
	public static String PROP_UPS = "ups";
	public static String PROP_CHECKED = "checked";
	public static String PROP_COMMENT_EXT = "commentExt";
	public static String PROP_CONTENT = "content";
	public static String PROP_ID = "id";


	// constructors
	public BaseCmsComment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsComment (Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsComment (
		Integer id,
		Content content,
		CmsSite site,
		java.util.Date createTime,
		Short ups,
		Short downs,
		Boolean recommend,
		Short checked) {

		this.setId(id);
		this.setContent(content);
		this.setSite(site);
		this.setCreateTime(createTime);
		this.setUps(ups);
		this.setDowns(downs);
		this.setRecommend(recommend);
		this.setChecked(checked);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private java.util.Date createTime;
	private java.util.Date replayTime;
	private Short ups;
	private Short downs;
	private Boolean recommend;
	private Short checked;
	private Integer score;
	
	private Integer replyCount;
	private CmsComment parent;

	// one to one
	private CmsCommentExt commentExt;

	// many to one
	private CmsUser replayUser;
	private Content content;
	private CmsUser commentUser;
	private CmsSite site;
	
	private Set<CmsComment>child;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="identity"
     *  column="comment_id"
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
	 * Return the value associated with the column: create_time
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: create_time
	 * @param createTime the create_time value
	 */
	public void setCreateTime (java.util.Date createTime) {
		this.createTime = createTime;
	}


	/**
	 * Return the value associated with the column: reply_time
	 */
	public java.util.Date getReplayTime () {
		return replayTime;
	}

	/**
	 * Set the value related to the column: reply_time
	 * @param replayTime the reply_time value
	 */
	public void setReplayTime (java.util.Date replayTime) {
		this.replayTime = replayTime;
	}


	/**
	 * Return the value associated with the column: ups
	 */
	public Short getUps () {
		return ups;
	}

	/**
	 * Set the value related to the column: ups
	 * @param ups the ups value
	 */
	public void setUps (Short ups) {
		this.ups = ups;
	}


	/**
	 * Return the value associated with the column: downs
	 */
	public Short getDowns () {
		return downs;
	}

	/**
	 * Set the value related to the column: downs
	 * @param downs the downs value
	 */
	public void setDowns (Short downs) {
		this.downs = downs;
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
	 * Return the value associated with the column: is_checked
	 */
	public Short getChecked () {
		return checked;
	}

	/**
	 * Set the value related to the column: is_checked
	 * @param checked the is_checked value
	 */
	public void setChecked (Short checked) {
		this.checked = checked;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public CmsComment getParent() {
		return parent;
	}

	public void setParent(CmsComment parent) {
		this.parent = parent;
	}

	/**
	 * Return the value associated with the column: commentExt
	 */
	public CmsCommentExt getCommentExt () {
		return commentExt;
	}

	/**
	 * Set the value related to the column: commentExt
	 * @param commentExt the commentExt value
	 */
	public void setCommentExt (CmsCommentExt commentExt) {
		this.commentExt = commentExt;
	}


	/**
	 * Return the value associated with the column: reply_user_id
	 */
	public CmsUser getReplayUser () {
		return replayUser;
	}

	/**
	 * Set the value related to the column: reply_user_id
	 * @param replayUser the reply_user_id value
	 */
	public void setReplayUser (CmsUser replayUser) {
		this.replayUser = replayUser;
	}


	/**
	 * Return the value associated with the column: content_id
	 */
	public Content getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: content_id
	 * @param content the content_id value
	 */
	public void setContent (Content content) {
		this.content = content;
	}


	/**
	 * Return the value associated with the column: comment_user_id
	 */
	public CmsUser getCommentUser () {
		return commentUser;
	}

	/**
	 * Set the value related to the column: comment_user_id
	 * @param commentUser the comment_user_id value
	 */
	public void setCommentUser (CmsUser commentUser) {
		this.commentUser = commentUser;
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

	public Set<CmsComment> getChild() {
		return child;
	}

	public void setChild(Set<CmsComment> child) {
		this.child = child;
	}

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof CmsComment)) return false;
		else {
			CmsComment cmsComment = (CmsComment) obj;
			if (null == this.getId() || null == cmsComment.getId()) return false;
			else return (this.getId().equals(cmsComment.getId()));
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