package com.jie.pageoffice.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageOfficeConfig {

	@Bean
	public ServletRegistrationBean servletRegistrationBean(@Value("${posyspath}") String poSysPath) {

		com.zhuozhengsoft.pageoffice.poserver.Server poserver = new com.zhuozhengsoft.pageoffice.poserver.Server();

		//设置PageOffice注册成功后,license.lic文件存放的目录
		poserver.setSysPath(poSysPath);

		ServletRegistrationBean srb = new ServletRegistrationBean(poserver);
		srb.addUrlMappings("/poserver.zz");
		srb.addUrlMappings("/posetup.exe");
		srb.addUrlMappings("/pageoffice.js");
		srb.addUrlMappings("/sealsetup.exe");

		return srb;
	}

	@Bean
	public ServletRegistrationBean servletRegistrationBean2(@Value("${posyspath}") String poSysPath,
															@Value("${popassword}") String poPassWord) {

		com.zhuozhengsoft.pageoffice.poserver.AdminSeal adminSeal = new com.zhuozhengsoft.pageoffice.poserver.AdminSeal();
		adminSeal.setAdminPassword(poPassWord);//设置印章管理员admin的登录密码

		//设置印章数据库文件poseal.db存放目录，该文件在当前demo的“集成文件”夹中
		adminSeal.setSysPath(poSysPath);

		ServletRegistrationBean srb = new ServletRegistrationBean(adminSeal);
		srb.addUrlMappings("/adminseal.zz");
		srb.addUrlMappings("/sealimage.zz");
		srb.addUrlMappings("/loginseal.zz");

		return srb;
	}
}
