package test;

import org.springframework.context.support.GenericXmlApplicationContext;

public class PrinterMain {

	public static void main(String[] args) {
		// Spring Container 생성
		GenericXmlApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// 컨테이너가 객체를 제공
		Printer printer = ctx.getBean("printer", Printer.class);
		
		printer.print();

	}

}
