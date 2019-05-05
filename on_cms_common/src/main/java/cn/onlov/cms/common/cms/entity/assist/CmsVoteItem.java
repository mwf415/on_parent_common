package cn.onlov.cms.common.cms.entity.assist;

import java.util.Set;

import cn.onlov.cms.common.cms.entity.assist.base.BaseCmsVoteItem;
import cn.onlov.cms.common.common.hibernate4.PriorityInterface;

public class CmsVoteItem extends BaseCmsVoteItem implements PriorityInterface {
	private static final long serialVersionUID = 1L;

	/* 311版本调查只有选项 没有题目的情况
	public int getPercent() {
		Integer totalCount = getTopic().getTotalCount();
		if (totalCount != null && totalCount != 0) {
			return (getVoteCount() * 100) / totalCount;
		} else {
			return 0;
		}
	}
	*/
	//调查多题目情况下
	public double getPercent() {
		Integer totalCount = 0;
		Set<CmsVoteItem> subTopicVoteItems=getSubTopic().getVoteItems();
		for(CmsVoteItem vote:subTopicVoteItems){
			totalCount+=vote.getVoteCount();
		}
		if (totalCount != null && totalCount != 0) {
			double percent = ((getVoteCount().doubleValue() * 100) / totalCount.doubleValue());
			return (double) (Math.round(percent));
		} else {
			return 0;
		}
	}

	public void init() {
		if (getPriority() == null) {
			setPriority(10);
		}
		if (getVoteCount() == null) {
			setVoteCount(0);
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsVoteItem() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsVoteItem(Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsVoteItem(Integer id,
                       CmsVoteTopic topic,
                       String title, Integer voteCount,
                       Integer priority) {

		super(id, topic, title, voteCount, priority);
	}

	/* [CONSTRUCTOR MARKER END] */

}