package tw.brad.stest3.controller;

import java.net.URI;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import tw.brad.stest3.model.Member;
import tw.brad.stest3.model.Member2;
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
	
	@PostMapping(value="/register")
	public ResponseEntity<Void> register(HttpSession session, 
										@RequestParam String account, 
										@RequestParam String passwd, 
										@RequestParam String realname,
										MultipartFile icon) {
		
		Member member = new Member(account,passwd,realname);
		Member newMember = memberService.register(member, icon);
		if (newMember.getId() != -1) {
			memberResponse.setErrCode(1);
			memberResponse.setMember(newMember);
			
			session.setAttribute("member", newMember);
			
		}else {
			memberResponse.setErrCode(-1);
			memberResponse.setMember(member);
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/brad03.html"));
		
		return new ResponseEntity<>(headers, HttpStatus.FOUND);
	}
	
	@PostMapping("/register2")
	public ResponseEntity<MemberResponse> register2(@RequestBody Member2 member2, HttpSession session) {
		String base64 =  member2.getIconString().split(",")[1];
		byte[] iconBytes = Base64.getDecoder().decode(base64);
		
		Member member = new Member(member2.getAccount(), member2.getPasswd(), member2.getRealname(), iconBytes);
		
		Member newMember = memberService.register(member, null);
		if (newMember.getId() != -1) {
			memberResponse.setErrCode(1);
			memberResponse.setMember(newMember);
			session.setAttribute("member", newMember);
		}else {
			memberResponse.setErrCode(-1);
			memberResponse.setMember(member);
		}
		return ResponseEntity.status(HttpStatus.OK).body(memberResponse);		
		
	}
	
	@PostMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}	
	
	@PostMapping("/login")
	public ResponseEntity<MemberResponse> login(@RequestBody Member loginMember, HttpSession session) {
		 Member member = memberService.login(loginMember);
		 if (member != null) {
			memberResponse.setErrCode(1);
			memberResponse.setMember(member);			 
			session.setAttribute("member", member);
		 }else {
			memberResponse.setErrCode(-1);
			memberResponse.setMember(loginMember);
			session.setAttribute("member", null);
		 }
		 return ResponseEntity.status(HttpStatus.OK).body(memberResponse);
	}
	
}
