package cn.onlov.on_cms_common.cms.staticpage;

import cn.onlov.on_cms_common.core.entity.Ftp;

import java.io.IOException;
import java.io.InputStream;

public class DistributionThread  implements Runnable{
	private String path;
	private InputStream in;
	private Ftp ftp;

	public DistributionThread(Ftp ftp,String path,InputStream in) {
		this.ftp = ftp;
		this.path = path;
		this.in = in;
	}

	@Override
	public void run() {
		if(ftp!=null){
			try {
				ftp.storeByExt(path,in);
			} catch (IOException e) {
				//e.printStackTrace();
			}
		}
	}
	
}
