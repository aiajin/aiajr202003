package com.aia.op.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.jdbc.ConnectionProvider;
import com.aia.op.member.dao.MemberDao;

@Service
public class IdCheckService {

	@Autowired
	private MemberDao dao;

	public String checkId(String uid) {

		String result = "N";

		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();

			int resultCnt = dao.selectById(conn, uid);

			if (resultCnt < 1) {
				result = "Y";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;

	}

}
