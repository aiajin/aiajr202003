package com.aia.mvc.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.mvc.order.model.OrderCommand;

@Controller
public class OrderController {

	@RequestMapping(value = "/order/order", method = RequestMethod.GET)
	public String orderForm() {
		
		return "order/orderForm";
	}
	
	@RequestMapping(value = "/order/order", method = RequestMethod.POST )
	public String order(OrderCommand order) {
		
		System.out.println(order);
		
		return "order/order";
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
