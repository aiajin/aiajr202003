package di.service;

import di.dao.MemberDao;
import di.domain.Member;
import di.exception.IdPasswordNotMatchingException;
import di.exception.MemberNotFoundException;

public class ChangePasswordService {
	private MemberDao memberDao;

	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	public void changePassword(String email, String oldPwd, String newPwd) throws IdPasswordNotMatchingException, MemberNotFoundException {
		Member member = memberDao.selectByEmail(email);
		if (member == null)
			throw new MemberNotFoundException();

		member.changePassword(oldPwd, newPwd);

		memberDao.update(member);
	}

}
