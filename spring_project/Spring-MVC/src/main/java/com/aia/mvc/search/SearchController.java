package com.aia.mvc.search;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SearchController {

	@RequestMapping("/search")
	public String search(
			@RequestParam(name = "query", required = false) String query,
			@RequestParam(name = "page", defaultValue = "1") int pageNumber,
			Model model
			) {
		
		model.addAttribute("query", query);
		model.addAttribute("page", pageNumber);
		
		return "search/search";
	}
	
}








