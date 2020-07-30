package di.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di.config.JavaConfig;
import di.dao.MemberDao;
import di.service.ChangePasswordService;
import di.service.MemberRegisterService;

public class MainForSpringJavaConfig {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
		
		MemberRegisterService regSvc = ctx.getBean("regSvc",MemberRegisterService.class);
		System.out.println(regSvc);
		MemberDao dao = ctx.getBean("dao", MemberDao.class);
		System.out.println(dao);
		ChangePasswordService changeSvc = ctx.getBean("changePwSvc", ChangePasswordService.class); 
		System.out.println(changeSvc);
	}

}










