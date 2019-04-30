package cn.onlov.on_cms_common.cms.entity.assist.base;

import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteItem;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteReply;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteSubTopic;
import cn.onlov.on_cms_common.cms.entity.assist.CmsVoteTopic;

import java.io.Serializable;


/**
 * This is an object that contains data related to the jc_vote_subtopic table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="jc_vote_subtopic"
 */

public abstract class BaseCmsVoteSubTopic  implements Serializable {

	public static String REF = "CmsVoteSubTopic";
	public static String PROP_TYPE = "type";
	public static String PROP_VOTE_TOPIC = "voteTopic";
	public static String PROP_ID = "id";
	public static String PROP_TITLE = "title";
	public static String PROP_PRIORITY = "priority";


	// constructors
	public BaseCmsVoteSubTopic () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCmsVoteSubTopic (Integer id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseCmsVoteSubTopic (
		Integer id,
		CmsVoteTopic voteTopic,
		String title,
		Integer type,
		Integer priority) {

		this.setId(id);
		this.setVoteTopic(voteTopic);
		this.setTitle(title);
		this.setType(type);
		this.setPriority(priority);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private Integer id;

	// fields
	private String title;
	private Integer type;
	private Integer priority;

	// many to one
	private CmsVoteTopic voteTopic;

	// collections
	private java.util.Set<CmsVoteItem> voteItems;
	private java.util.Set<CmsVoteReply> voteReplys;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="native"
     *  column="subtopic_id"
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
	 * Return the value associated with the column: title
	 */
	public String getTitle () {
		return title;
	}

	/**
	 * Set the value related to the column: title
	 * @param title the title value
	 */
	public void setTitle (String title) {
		this.title = title;
	}


	/**
	 * Return the value associated with the column: subtopic_type
	 */
	public Integer getType () {
		return type;
	}

	/**
	 * Set the value related to the column: subtopic_type
	 * @param type the subtopic_type value
	 */
	public void setType (Integer type) {
		this.type = type;
	}


	/**
	 * Return the value associated with the column: priority
	 */
	public Integer getPriority () {
		return priority;
	}

	/**
	 * Set the value related to the column: priority
	 * @param priority the priority value
	 */
	public void setPriority (Integer priority) {
		this.priority = priority;
	}


	/**
	 * Return the value associated with the column: votetopic_id
	 */
	public CmsVoteTopic getVoteTopic () {
		return voteTopic;
	}

	/**
	 * Set the value related to the column: votetopic_id
	 * @param voteTopic the votetopic_id value
	 */
	public void setVoteTopic (CmsVoteTopic voteTopic) {
		this.voteTopic = voteTopic;
	}


	/**
	 * Return the value associated with the column: voteItems
	 */
	public java.util.Set<CmsVoteItem> getVoteItems () {
		return voteItems;
	}

	/**
	 * Set the value related to the column: voteItems
	 * @param voteItems the voteItems value
	 */
	public void setVoteItems (java.util.Set<CmsVoteItem> voteItems) {
		this.voteItems = voteItems;
	}


	/**
	 * Return the value associated with the column: voteReplys
	 */
	public java.util.Set<CmsVoteReply> getVoteReplys () {
		return voteReplys;
	}

	/**
	 * Set the value related to the column: voteReplys
	 * @param voteReplys the voteReplys value
	 */
	public void setVoteReplys (java.util.Set<CmsVoteReply> voteReplys) {
		this.voteReplys = voteReplys;
	}



	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof CmsVoteSubTopic)) return false;
		else {
			CmsVoteSubTopic cmsVoteSubTopic = (CmsVoteSubTopic) obj;
			if (null == this.getId() || null == cmsVoteSubTopic.getId()) return false;
			else return (this.getId().equals(cmsVoteSubTopic.getId()));
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