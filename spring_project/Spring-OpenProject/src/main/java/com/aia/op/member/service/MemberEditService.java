package com.aia.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aia.op.jdbc.ConnectionProvider;
import com.aia.op.member.dao.MemberDao;
import com.aia.op.member.model.Member;
import com.aia.op.member.model.MemberEditRequest;

@Service
public class MemberEditService {

	@Autowired
	MemberDao dao;

	public Member getMember(int idx) {

		Connection conn;
		Member member = null;

		try {

			conn = ConnectionProvider.getConnection();
			member = dao.selectByIdx(conn, idx);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return member;
	}

	public int editMember(MemberEditRequest editRequest, HttpServletRequest request) {
		int result = 0;

		// MemberEditRequest -> Member : 이전 파일을 photo에 저장하고 시작
		Member member = editRequest.toMember();

		MultipartFile file = editRequest.getPhoto();

		Connection conn = null;

		try {

			conn = ConnectionProvider.getConnection();

			// 새로운 업데이트 파일이 있으면
			// 1. 파일의 물리적인 저장 -> Member 객체의 photo 변수 데이터 설정
			// 2. 이전 저장된  파일 삭제
			if (file != null && !file.isEmpty() && file.getSize() > 0) {
				// 서버 내부의 경로
				String uri = request.getSession().getServletContext().getInitParameter("memberUploadPath");

				// 시스템의 실제(절대) 경로
				String realPath = request.getSession().getServletContext().getRealPath(uri);

				// 저장할 이미지 파일의 새로운 이름 생성
				String newFileName = System.nanoTime() + "_" + file.getOriginalFilename();

				// 서버의 저장소에 실제 저장
				File saveFile = new File(realPath, newFileName);
				file.transferTo(saveFile);
				System.out.println("저장 완료 : " + newFileName);

				// 데이터베이스에 저장할 Member 객체의 데이터를 완성한다. : 사진 경로
				member.setUphoto(newFileName);

				// 이전 페이지를 지운다.
				// 이전 파일의 File 객체
				File oldFile = new File(realPath, editRequest.getOldFile());

				// 파일이 존재하면
				if (oldFile.exists()) {
					// 파일을 삭제
					oldFile.delete();
				}

			}

			// 데이터베이스 : update
			result = dao.editMember(conn, member);

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

		return result;
	}
}
