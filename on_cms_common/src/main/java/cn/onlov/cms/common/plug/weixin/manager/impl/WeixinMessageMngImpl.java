package cn.onlov.cms.common.plug.weixin.manager.impl;

import java.util.List;

import cn.onlov.cms.common.common.hibernate4.Updater;
import cn.onlov.cms.common.common.page.Pagination;
import cn.onlov.cms.common.plug.weixin.dao.WeixinMessageDao;
import cn.onlov.cms.common.plug.weixin.entity.WeixinMessage;
import cn.onlov.cms.common.plug.weixin.manager.WeixinMessageMng;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WeixinMessageMngImpl implements WeixinMessageMng {

	@Transactional(readOnly=true)
	public Pagination getPage(Integer siteId, int pageNo, int pageSize) {
		return dao.getPage(siteId,pageNo,pageSize);
	}
	
	@Transactional(readOnly=true)
	public List<WeixinMessage> getList(Integer siteId){
		return dao.getList(siteId);
	}
	
	@Transactional(readOnly=true)
	public WeixinMessage getWelcome(Integer siteId){
		return dao.getWelcome(siteId);
	}
	
	@Transactional(readOnly=true)
	public WeixinMessage findByNumber(String number,Integer siteId){
		return dao.findByNumber(number,siteId);
	}

	@Transactional(readOnly=true)
	public WeixinMessage findById(Integer id) {
		return dao.findById(id);
	}

	@Override
	public WeixinMessage save(WeixinMessage bean) {
		return dao.save(bean);
	}

	@Override
	public WeixinMessage update(WeixinMessage bean) {
		Updater<WeixinMessage> updater = new Updater<WeixinMessage>(bean);
		return dao.updateByUpdater(updater);
	}

	@Override
	public WeixinMessage deleteById(Integer id) {
		return dao.deleteById(id);
	}

	@Override
	public WeixinMessage[] deleteByIds(Integer[] ids) {
		// TODO Auto-generated method stub
		WeixinMessage[] beans = new WeixinMessage[ids.length];
		for (int i = 0; i < ids.length; i++) {
			beans[i] = deleteById(ids[i]);
		}
		return beans;
	}
	
	
	@Autowired
	private WeixinMessageDao dao;
}
