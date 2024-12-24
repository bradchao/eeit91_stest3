package tw.brad.stest3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public ResponseEntity<MemberResponse> getAccount(@PathVariable String account) {
		Member member = memberService.isAccountExist(account);
		memberResponse.setErrCode(member!=null?1:-1);
		memberResponse.setMember(member);
		
		return ResponseEntity.status(HttpStatus.OK).body(memberResponse);
	}
	
	@PostMapping("/register")
	public void register(@RequestParam String account, 
			@RequestParam String passwd, 
			@RequestParam String realname,
			MultipartFile icon) {
		
		Member member = new Member(account,passwd,realname);
		try {
			member.setIcon(icon.isEmpty()?null:icon.getBytes());
		}catch(Exception e) {
			member.setIcon(null);
		}
		
		memberService.register(member);
		
	}
	
	
}