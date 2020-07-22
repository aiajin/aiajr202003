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

public class MemberEditServiceImpl implements Service {

MemberDao dao;
	
	@Override
	public String getViewPage(
			HttpServletRequest request, 
			HttpServletResponse response) {
		
		// 파일 업로드 - 사진
		// 사용자 데이터를 받기 - uid, upw, uname, uphoto

		int resultCnt = 0;
		
		// 데이터 베이스에 수정 데이터 변수
		int idx = 0;
		String upw = null;
		String uname = null;
		String oldFile = null;
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
						
						if(paramName.equals("idx")){
							idx = Integer.parseInt(paramValue);
						} else if(paramName.equals("upw")) {
							upw = paramValue;
						} else if(paramName.equals("uname")) {
							uname = paramValue;
						} else if(paramName.equals("oldFile")) {
							// 이전 파일은 새로운 파일이 없을때 업데이트가 되도록합니다.
							oldFile = paramValue;
						}
						
					} else { // type=file
						
						if(item.getFieldName().equals("photo") && item.getSize()>0) {

							System.out.println("파일 없이 들어오면 안된다");
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
	
				}
				
				
				// 새로 파일이 저장 되었을 때 처리
				// 이전 파일 삭제.
				// 새로운 파일이 없을 때 이전 파일 이름 저장
				if(uphoto!=null) {
					File oFile = new File(request.getSession().getServletContext().getRealPath(oldFile));
					if(oFile.exists()) {
						if(oFile.delete()) {
							System.out.println("새로운 파일이 추가되어 이전파일은 삭제합니다.");
						}
					}
				} else {
					uphoto = oldFile;
				}
				
				
				
				
				// 데이터 베이스 저장 
				Member member = new Member();
				member.setIdx(idx);
				member.setUpw(upw);
				member.setUname(uname);
				member.setUphoto(uphoto);
				
				conn = ConnectionProvider.getConnection();
				
				dao = MemberDao.getInstance() ;
				
				resultCnt = dao.editMember(conn, member);
				
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
		
		return "/WEB-INF/views/member/edit.jsp";
	}

}









