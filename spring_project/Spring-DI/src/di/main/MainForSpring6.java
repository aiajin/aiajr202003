package di.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import di.config.JavaConfig;
import di.dao.MemberDao;
import di.domain.Member;
import di.domain.RegisterRequest;
import di.exception.AlreadyExistingMemberException;
import di.service.MemberRegisterService;

public class MainForSpring6 {

	private static GenericXmlApplicationContext ctx = null;

	public static void main(String[] args) throws AlreadyExistingMemberException {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);

		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);

		RegisterRequest regReq = new RegisterRequest();
		regReq.setEmail("ryuyj@nate.com");
		regReq.setName("유영진");
		regReq.setPassword("1234");
		regReq.setConfirmPassword("1234");
		regSvc.regist(regReq);
		
		MemberDao dao = ctx.getBean("memberDao", MemberDao.class);
		
		Member member  = dao.selectByEmail("ryuyj@nate.com");
		
		System.out.println(member.getName());
		

	}

}
