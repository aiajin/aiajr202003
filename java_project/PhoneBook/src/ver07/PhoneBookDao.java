package ver07;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import ver07.domain.PhoneBookDto;

public class PhoneBookDao {
	
	////////////////////////////////////////////////
	// insert  
	public int basicInfoInsert(PhoneBookDto pbDto, Connection conn) throws SQLException {	
		
		// insert의 결과
		int resultCnt = 0;		
		
		PreparedStatement ps = null;
		
		try {
			String sql = "insert into phoneinfo_basic"
					   + " (idx, fr_name, fr_phonenumber, fr_email, fr_address)  "
		               + " VALUES (pb_basic_idx_seq.nextval, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,pbDto.getFr_name());
			ps.setString(2,pbDto.getFr_phonenumber());
			ps.setString(3,pbDto.getFr_email());
			ps.setString(4,pbDto.getFr_address());
			resultCnt = ps.executeUpdate();
			
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
		return resultCnt;
	}
	
	public int univInfoInsert(PhoneBookDto pbDto, Connection conn) throws SQLException {		

		// insert의 결과
		int resultCnt = 0;		
		
		PreparedStatement ps = null;
		
		try {
			String sql = "insert into phoneinfo_univ "
					   + " values (pb_univ_idx_seq.nextval, ?, ?, pb_basic_idx_seq.currval)";
			ps = conn.prepareStatement(sql);
			ps.setString(1,pbDto.getFr_u_major());
			//ps.setString(2,pbDto.getFr_u_year());
			resultCnt = ps.executeUpdate();
			
		} finally {
			if(ps != null) {
				ps.close();
			}
		}
		return resultCnt;
	}
	
	public int comInfoInsert(PhoneBookDto pbDto, Connection conn) {		
		int resultCnt = 0;		
		return resultCnt;
	}
	/////////////////////////////////////////////////
	
	/////////////////////////////////////////////////
	// select
	// 전체 친구 리스트 출력
	public List<PhoneBookDto> selectAll(Connection conn) {
		List<PhoneBookDto> list = null;
		//list = Collections.emptyList();
		return list;
	}
	
	// 이름으로 검색한 결과 출력
	public List<PhoneBookDto> selectByName(Connection conn) {
		List<PhoneBookDto> list = null;
		//list = Collections.emptyList();
		return list;
	}
	
	public List<PhoneBookDto> selectByIdx(Connection conn) {
		List<PhoneBookDto> list = null;
		//list = Collections.emptyList();
		return list;
	}
	
	
	
}
