package cn.onlov.on_cms_common.core.dao;

import java.util.Date;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.common.page.Pagination;
import cn.onlov.on_cms_common.core.entity.Authentication;

public interface AuthenticationDao {

	public int deleteExpire(Date d);

	public Authentication getByUserId(Long userId);

	public Pagination getPage(int pageNo, int pageSize);

	public Authentication findById(String id);

	public Authentication save(Authentication bean);

	public Authentication updateByUpdater(Updater<Authentication> updater);

	public Authentication deleteById(String id);
}