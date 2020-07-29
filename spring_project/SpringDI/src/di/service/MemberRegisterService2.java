package di.service;

import java.util.Date;

import di.dao.Dao;
import di.domain.Member;
import di.domain.RegisterRequest;
import di.exception.AlreadyExistingMemberException;

public class MemberRegisterService2 {
	
	private Dao dao;
	
	// 메서드 주입 방식
	public void setDao(Dao dao) {
		this.dao = dao;
	}
	
	

	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {
		
		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newMember);
	}

}
