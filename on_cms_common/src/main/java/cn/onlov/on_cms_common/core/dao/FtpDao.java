package cn.onlov.on_cms_common.core.dao;

import java.util.List;

import cn.onlov.on_cms_common.common.hibernate4.Updater;
import cn.onlov.on_cms_common.core.entity.Ftp;

public interface FtpDao {
	public List<Ftp> getList();

	public Ftp findById(Integer id);

	public Ftp save(Ftp bean);

	public Ftp updateByUpdater(Updater<Ftp> updater);

	public Ftp deleteById(Integer id);
}