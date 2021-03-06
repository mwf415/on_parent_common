package cn.onlov.cms.common.cms.entity.main;


import cn.onlov.cms.common.cms.entity.main.base.BaseChannelExt;
import org.apache.commons.lang.StringUtils;

public class ChannelExt extends BaseChannelExt implements Cloneable {
	private static final long serialVersionUID = 1L;
	/**
	 * 游客评论
	 */
	public static final int COMMENT_OPEN = 0;
	/**
	 * 登录评论
	 */
	public static final int COMMENT_LOGIN = 1;
	/**
	 * 关闭评论
	 */
	public static final int COMMENT_OFF = 2;
	/**
	 * 登陆评论多次
	 */
	public static final int COMMENT_LOGIN_MANY = 3;

	public void init() {
		if (getHasTitleImg() == null) {
			setHasTitleImg(false);
		}
		if (getHasContentImg() == null) {
			setHasContentImg(false);
		}
		if (getTitleImgWidth() == null) {
			setTitleImgWidth(139);
		}
		if (getTitleImgHeight() == null) {
			setTitleImgHeight(139);
		}
		if (getContentImgWidth() == null) {
			setContentImgWidth(310);
		}
		if (getContentImgHeight() == null) {
			setContentImgHeight(310);
		}
		if (getBlank() == null) {
			setBlank(false);
		}
		if (getCommentControl() == null) {
			setCommentControl(2);
		}
		if (getAllowUpdown() == null) {
			setAllowUpdown(true);
		}
		if (getStaticChannel() == null) {
			setStaticChannel(false);
		}
		if (getStaticContent() == null) {
			setStaticContent(false);
		}
		if (getAccessByDir() == null) {
			setAccessByDir(true);
		}
		if (getListChild() == null) {
			setListChild(false);
		}
		if (getPageSize() == null) {
			setPageSize(20);
		}
		if(getAllowScore()==null){
			setAllowShare(false);
		}
		if(getAllowScore()==null){
			setAllowScore(false);
		}
		blankToNull();
	}
	

	public Object clone() {  
		ChannelExt c = null;
        try{
             c = (ChannelExt)super.clone();
         }catch(CloneNotSupportedException e) {
             e.printStackTrace();
         }
         return c;
    }  

	public void blankToNull() {
		if (StringUtils.isBlank(getLink())) {
			setLink(null);
		}
		if (StringUtils.isBlank(getTplChannel())) {
			setTplChannel(null);
		}
		if (StringUtils.isBlank(getTplContent())) {
			setTplContent(null);
		}
		if (StringUtils.isBlank(getTitle())) {
			setTitle(null);
		}
		if (StringUtils.isBlank(getKeywords())) {
			setKeywords(null);
		}
		if (StringUtils.isBlank(getDescription())) {
			setDescription(null);
		}
		if (StringUtils.isBlank(getTitleImg())) {
			setTitleImg(null);
		}
		if (StringUtils.isBlank(getContentImg())) {
			setContentImg(null);
		}
		if (StringUtils.isBlank(getChannelRule())) {
			setChannelRule(null);
		}
		if (StringUtils.isBlank(getContentRule())) {
			setContentRule(null);
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public ChannelExt() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public ChannelExt(Integer id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public ChannelExt(Integer id, String name,
                      Boolean staticChannel, Boolean staticContent,
                      Boolean accessByDir, Boolean listChild,
                      Integer pageSize, Boolean hasTitleImg,
                      Boolean hasContentImg, Integer titleImgWidth,
                      Integer titleImgHeight,
                      Integer contentImgWidth,
                      Integer contentImgHeight,
                      Integer commentControl, Boolean blank) {

		super(id, name, staticChannel, staticContent, accessByDir, listChild,
				pageSize, hasTitleImg, hasContentImg, titleImgWidth,
				titleImgHeight, contentImgWidth, contentImgHeight,
				commentControl, blank);
	}

	/* [CONSTRUCTOR MARKER END] */

}