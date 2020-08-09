package com.aia.op.guestbook.service;

import java.util.Collections;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aia.op.guestbook.dao.GuestBookDao;
import com.aia.op.guestbook.model.Message;
import com.aia.op.guestbook.model.MessageListView;

@Service
public class GuestBookListService {

	private GuestBookDao dao;

	@Autowired
	private SqlSessionTemplate template;

	public MessageListView getList(int pageNumber) {

		dao = template.getMapper(GuestBookDao.class);

		// 페이지의 전체 메시지 구하기
		List<Message> messageList = null;

		// 전체 메시지의 게수
		int messageTotalCount = dao.selectTotalCount();

		int startRow = 0;
		int endRow = 0;

		final int MESSAGE_COUNT_PER_PAGE = 3;

		if (messageTotalCount > 0) {

			// 시작 행, 마지막 행
			startRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE;
			// endRow = startRow + MESSAGE_COUNT_PER_PAGE - 1;

			messageList = dao.selectMessageList(
							startRow, 
							MESSAGE_COUNT_PER_PAGE);
			
			System.out.println(messageList);

		} else {
			pageNumber = 0;
			messageList = Collections.emptyList();
		}

		return new MessageListView(
				messageTotalCount, 
				pageNumber, 
				messageList, 
				MESSAGE_COUNT_PER_PAGE, 
				startRow,
				endRow);
	}

}
