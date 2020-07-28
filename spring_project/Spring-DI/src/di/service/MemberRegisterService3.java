package di.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import di.dao.Dao;
import di.domain.Member;
import di.domain.RegisterRequest;
import di.exception.AlreadyExistingMemberException;

//이 서비스 클래스는 서비스 클래스가 완성 되어 있지 않더라도 코드 완성에 문제가 없다, 정상적으로 컴파일이 된다.
public class MemberRegisterService3 {

	@Autowired
	private Dao dao;

	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {
		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newMember);
	}

}
