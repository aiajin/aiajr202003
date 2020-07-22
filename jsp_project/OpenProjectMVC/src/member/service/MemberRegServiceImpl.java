package member.service;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import app.jdbc.ConnectionProvider;
import app.service.Service;
import member.dao.MemberDao;
import member.model.Member;

public class MemberRegServiceImpl implements Service {

MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		// 파일 업로드 - 사진
		// 사용자 데이터를 받기 - uid, upw, uname, uphoto

		int resultCnt = 0;
		
		// 데이터 베이스에 입력할 데이터 변수
		String uid = null;
		String upw = null;
		String uname = null;
		String uphoto = null;
		
		Connection conn = null;

		try {
			
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
			if (isMultipart) {
	
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
	
				List<FileItem> items = upload.parseRequest(request);
	
				Iterator<FileItem> ite = items.iterator();
	
				while (ite.hasNext()) {
	
					FileItem item = ite.next();
	
					// isFormField() : text value를 가지는 input 확인
					if (item.isFormField()) { // type=file 이외의 input
						// 파라미터 이름
						String paramName = item.getFieldName();
						// 파라미터의 값
						String paramValue = item.getString("utf-8");
						//System.out.println(paramName + " = " + paramValue);
						
						if(paramName.equals("uid")){
							uid = paramValue;
						} else if(paramName.equals("upw")) {
							upw = paramValue;
						} else if(paramName.equals("uname")) {
							uname = paramValue;
						}
						
					} else { // type=file
						
						// 서버 내부의 경로
						String uri = "/upload/users";
	
						//String uri = request.getSession().getServletContext().getInitParameter("uploadPath");
	
						// 시스템의 실제(절대) 경로
						String realPath = request.getSession().getServletContext().getRealPath(uri);
						// System.out.println(realPath);
	
						String newFileName = System.nanoTime() + "_" + item.getName();
	
						// 서버의 저장소에 실제 저장
						File saveFile = new File(realPath, newFileName);
						item.write(saveFile);
						System.out.println("저장 완료");
						
						uphoto = uri+"/"+newFileName;
	
					}
	
				}
				
				
				// 데이터 베이스 저장 
				Member member = new Member();
				member.setUid(uid);
				member.setUpw(upw);
				member.setUname(uname);
				member.setUphoto(uphoto);
				
				conn = ConnectionProvider.getConnection();
				
				dao = MemberDao.getInstance() ;
				
				resultCnt = dao.insertMember(conn, member);
				
				request.setAttribute("member", member);
				request.setAttribute("result", resultCnt);
				
				
	
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		return "/WEB-INF/views/member/reg.jsp";
	}

}









