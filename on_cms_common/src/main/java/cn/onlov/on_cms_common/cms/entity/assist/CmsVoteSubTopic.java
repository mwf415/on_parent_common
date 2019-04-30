package cn.onlov.on_cms_common.cms.entity.assist;


import cn.onlov.on_cms_common.common.hibernate4.PriorityInterface;
import cn.onlov.on_cms_common.cms.entity.assist.base.BaseCmsVoteSubTopic;


public class CmsVoteSubTopic extends BaseCmsVoteSubTopic implements PriorityInterface,Comparable<Object>{
	private static final long serialVersionUID = 1L;
	
	//虚拟字段，用于存储保存题目顺序
	private Integer voteIndex;
	
	public Integer getVoteIndex() {
		return voteIndex;
	}
	public void setVoteIndex(Integer voteIndex) {
		this.voteIndex = voteIndex;
	}
	
	public boolean getIsRadio(){
		if(getType()==1){
			return true;
		}else{
			return false;
		}
	}
	public boolean getIsMulti(){
		if(getType()==2){
			return true;
		}else{
			return false;
		}
	}
	public boolean getIsText(){
		if(getType()==3){
			return true;
		}else{
			return false;
		}
	}

	public int compareTo(Object o) {
		return getPriority();
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public CmsVoteSubTopic () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsVoteSubTopic (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsVoteSubTopic (
		Integer id,
		CmsVoteTopic voteTopic,
		String title,
		Integer type,
		Integer priority) {

		super (
			id,
			voteTopic,
			title,
			type,
			priority);
	}

/*[CONSTRUCTOR MARKER END]*/


}