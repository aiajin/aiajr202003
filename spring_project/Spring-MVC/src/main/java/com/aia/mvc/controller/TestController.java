package com.aia.mvc.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	@RequestMapping(value = "/tesetForm", method = RequestMethod.GET)
	public String getForm() {
		return "test/form";
	}

	@RequestMapping(value = "/tesetForm", method = RequestMethod.POST)
	public String getForm(
			@RequestParam("datetimelocal") String datetime
			) {
		
		System.out.println(datetime);
		
		String dateStr = datetime.replace("T", " ");
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(dateStr, fmt);
		
		java.sql.Date sqlDate = java.sql.Date.valueOf(dateTime.toLocalDate());
		
		Timestamp ts1 = Timestamp.valueOf(dateTime);
		System.out.println(ts1);
		
		Timestamp ts2 = new Timestamp(sqlDate.getTime());
		System.out.println(ts2);
		
		
		
		
		
		return "test/form";
		
	}
	
}
