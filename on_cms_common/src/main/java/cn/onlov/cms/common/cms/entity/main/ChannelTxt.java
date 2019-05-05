package cn.onlov.cms.common.cms.entity.main;


import cn.onlov.cms.common.cms.entity.main.base.BaseChannelTxt;
import org.apache.commons.lang.StringUtils;

public class ChannelTxt extends BaseChannelTxt implements Cloneable{
	private static final long serialVersionUID = 1L;

	public void init() {
		blankToNull();
	}

	public void blankToNull() {
		if (StringUtils.isBlank(getTxt())) {
			setTxt(null);
		}
		if (StringUtils.isBlank(getTxt1())) {
			setTxt1(null);
		}
		if (StringUtils.isBlank(getTxt2())) {
			setTxt2(null);
		}
		if (StringUtils.isBlank(getTxt3())) {
			setTxt3(null);
		}
	}
	

	public Object clone() {  
		ChannelTxt c = null;
        try{
             c = (ChannelTxt)super.clone();
         }catch(CloneNotSupportedException e) {
             e.printStackTrace();
         }
         return c;
    }  

	/**
	 * 是否所有属性都为空
	 * 
	 * @return
	 */
	public boolean isAllBlank() {
		return StringUtils.isBlank(getTxt()) && StringUtils.isBlank(getTxt1())
				&& StringUtils.isBlank(getTxt2())
				&& StringUtils.isBlank(getTxt3());
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public ChannelTxt () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ChannelTxt (Integer id) {
		super(id);
	}

	/* [CONSTRUCTOR MARKER END] */

}