package ver07;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import ver07.domain.PhoneBookDto;

public class PhoneBookDao {
	
	////////////////////////////////////////////////
	// insert 
	public int univInfoInsert(PhoneBookDto pbDto) {		
		int resultCnt = 0;		
		return resultCnt;
	}
	
	public int comInfoInsert(PhoneBookDto pbDto) {		
		int resultCnt = 0;		
		return resultCnt;
	}
	/////////////////////////////////////////////////
	
	/////////////////////////////////////////////////
	// select
	// 전체 친구 리스트 출력
	public List<PhoneBookDto> selectAll() {
		List<PhoneBookDto> list = null;
		//list = Collections.emptyList();
		return list;
	}
	
	// 이름으로 검색한 결과 출력
	public List<PhoneBookDto> selectByName() {
		List<PhoneBookDto> list = null;
		//list = Collections.emptyList();
		return list;
	}
	
	public List<PhoneBookDto> selectByIdx() {
		List<PhoneBookDto> list = null;
		//list = Collections.emptyList();
		return list;
	}
	
	
	
}
