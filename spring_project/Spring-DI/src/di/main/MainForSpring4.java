package di.main;

import org.springframework.context.support.GenericXmlApplicationContext;

import di.service.ChangePasswordService2;
import di.service.MemberRegisterService2;

public class MainForSpring4 {
	
	private static GenericXmlApplicationContext ctx = null;

	public static void main(String[] args) {
		
		ctx = new GenericXmlApplicationContext("classpath:appCtx8.xml");

		MemberRegisterService2 regSvc1 = ctx.getBean("memberregSvc", MemberRegisterService2.class);
		MemberRegisterService2 regSvc2 = ctx.getBean("memberregSvc", MemberRegisterService2.class);
		
		System.out.println("-------------------------------------------------");
		System.out.println("bean scope 을 prototype으로 설정");
		System.out.println("regSvc1 == regSvc2 --> " + (regSvc1 == regSvc2));
		System.out.println("-------------------------------------------------");
		
		ChangePasswordService2 changePwdSvc1 = ctx.getBean("memberPwSvc", ChangePasswordService2.class);
		ChangePasswordService2 changePwdSvc2 = ctx.getBean("memberPwSvc", ChangePasswordService2.class);

		System.out.println("bean scope 을 singleton으로 설정");
		System.out.println("changePwdSvc1 == changePwdSvc2 --> " + (changePwdSvc1 == changePwdSvc2));
		System.out.println("-------------------------------------------------");
		
	}

}
