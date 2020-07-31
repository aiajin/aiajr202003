package com.aia.mvc.search;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aia.mvc.search.model.SearchType;

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
	
	@RequestMapping("/search/searchForm")
	public String searchForm() {
		
		return "search/searchForm";
	}
	
	
	@ModelAttribute("searchType")
	public List<SearchType> searchType(){
		
		List<SearchType> options = new ArrayList<SearchType>();
		options.add(new SearchType(1, "전체"));
		options.add(new SearchType(2, "이름"));
		options.add(new SearchType(3, "포지션"));
		
		return options;
	}
	
	
	
	
}








