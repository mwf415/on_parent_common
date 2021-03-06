package cn.onlov.cms.common.cms.entity.main;

import cn.onlov.cms.common.cms.entity.main.base.BaseChannelCount;


public class ChannelCount extends BaseChannelCount {
	private static final long serialVersionUID = 1L;
	public void init() {
		if (getViews() == null) {
			setViews(0);
		}
		if (getViewsMonth() == null) {
			setViewsMonth(0);
		}
		if (getViewsWeek() == null) {
			setViewsWeek(0);
		}
		if (getViewsDay() == null) {
			setViewsDay(0);
		}
		if(getContentTotal()==null){
			setContentTotal(0);
		}
		if(getContentDay()==null){
			setContentDay(0);
		}
		if(getContentMonth()==null){
			setContentMonth(0);
		}
		if(getContentWeek()==null){
			setContentWeek(0);
		}
		if(getContentYear()==null){
			setContentYear(0);
		}
	}

/*[CONSTRUCTOR MARKER BEGIN]*/
	public ChannelCount () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ChannelCount (Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ChannelCount (
		Integer id,
		Integer views,
		Integer viewsMonth,
		Integer viewsWeek,
		Integer viewsDay) {

		super (
			id,
			views,
			viewsMonth,
			viewsWeek,
			viewsDay);
	}

/*[CONSTRUCTOR MARKER END]*/


}