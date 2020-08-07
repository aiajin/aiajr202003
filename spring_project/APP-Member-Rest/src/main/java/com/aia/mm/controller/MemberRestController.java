package com.aia.mm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aia.mm.model.Member;
import com.aia.mm.model.MemberRegRequest;
import com.aia.mm.service.MemberListService;

@RestController
@RequestMapping("/members")  //  /members?pageNum=1&cnt=10
public class MemberRestController {
	
	@Autowired
	private MemberListService listService;
	
	@Autowired
	private MemberRegService regService;
	
	// 회원의 리스트 : Json 으로 응답
	@GetMapping     // GET | /members
	public List<Member> getMemberList(){
		return listService.getMemberList() ;
	}
	
	// 회원 가입
	@PostMapping	// POST | /members
	public int reg(
			MemberRegRequest regRequest,
			HttpServletRequest request
			) {
		System.out.println(regRequest);
		
		return regService.regMember(regRequest, request);
	}
	
	// 한명의 회원의 정보 보기
	@GetMapping("/{idx}")
	public Member getMember() {
		
		return null;
	}
	
	// 한명의 회원 정보 수정
	@PutMapping("/{idx}")   // PUT | /members/{idx}
	public int edit() {
		
		return 0;
	}
	
	// 회원 삭제
	@DeleteMapping("/{idx}")
	public int delete() {
		return 0;
	}
	
	

}






