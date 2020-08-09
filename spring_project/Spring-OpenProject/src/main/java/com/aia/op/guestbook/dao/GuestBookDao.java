package com.aia.op.guestbook.dao;

import java.util.List;

import com.aia.op.guestbook.model.Message;

public interface GuestBookDao {

	int selectTotalCount();

	List<Message> selectMessageList(int startRow, int count);

}
