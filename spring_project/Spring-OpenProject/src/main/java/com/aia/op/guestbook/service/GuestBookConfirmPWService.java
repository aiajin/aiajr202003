package com.aia.op.guestbook.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

@Service
public class GuestBookConfirmPWService {

	public String getUrl(String mid, String action) throws Exception {

		String actionUri = null;

		if (mid == null || action == null) {
			throw new Exception("데이터가 정상적으로 들어오지 않음.");
		}

		if (action.equals("edit")) {
			action = "editForm";
		} else if (action.equals("delete")) {
			action = "delete";
		} else {
			throw new Exception("데이터가 정상적으로 들어오지 않음.");
		}

		return actionUri;
	}

}
