package di.dao;

import di.domain.Member;

public interface Dao {

	Member selectByEmail(String email);

	void update(Member member);

	void insert(Member newMember);

}
