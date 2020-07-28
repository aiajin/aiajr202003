package di.service;

import di.dao.Dao;
import di.domain.Member;
import di.exception.IdPasswordNotMatchingException;
import di.exception.MemberNotFoundException;


// 이 서비스 클래스는 서비스 클래스가 완성 되어 있지 않더라도 코드 완성에 문제가 없다, 정상적으로 컴파일이 된다.
public class ChangePasswordService2 {
	
	// interface 타입의 참조변수 생성
	private Dao dao;

	// 하위 클래스 타입의 객체를 주입 받을 수 있는 객체
	public void setDao(Dao dao) {
		this.dao = dao;
	}

	public void changePassword(String email, String oldPwd, String newPwd)
			throws IdPasswordNotMatchingException, MemberNotFoundException {
		Member member = dao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		dao.update(member);
	}

}
