package tw.brad.stest3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tw.brad.stest3.model.Member;
import tw.brad.stest3.model.MemberResponse;
import tw.brad.stest3.service.MemberService;

@RestController
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberResponse memberResponse;
	
	@GetMapping("/{account}")
	public MemberResponse getAccount(@PathVariable String account) {
		Member member = memberService.isAccountExist(account);
		
		return memberResponse;
	}
	
	
}
