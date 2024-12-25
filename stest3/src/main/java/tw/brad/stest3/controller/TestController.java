package tw.brad.stest3.controller;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.stest3.model.Member;
import tw.brad.stest3.model.Member2;
import tw.brad.stest3.repository.TestRepository;
import tw.brad.stest3.util.BCrypt;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestRepository testRepository;
	
	@PostMapping("/test1")
	private void test1() {
		List<Member> list = testRepository.findAll();
		for (Member member: list) {
			System.out.println(member.getAccount());
		}
	}
	
	@PostMapping("/test2")
	private void test2() {
		Member member = new Member();
		member.setAccount("kevin");
		member.setPasswd("123456");
		member.setRealname("Kevin");
		testRepository.save(member);
	}
	
	@PostMapping("/test3")
	private void test3() {
		Member member = new Member();
		member.setId(39);
		member.setAccount("peter");
		member.setPasswd("654321");
		member.setRealname("Kevin");
		testRepository.save(member);
	}

	@PostMapping("/test4")
	private void test4() {
		testRepository.deleteById(8);
	}

	@PostMapping("/test5")
	private void test5() {
		testRepository.updateRealnameById(36, "AAA");
	}

	@PostMapping("/test6")
	private void test6(@RequestBody Member member) {
		String base64 = member.getIconString();
		byte[] iconBytes = null;
		if (base64 != null) {
			base64 = member.getIconString().split(",")[1];
			iconBytes = Base64.getDecoder().decode(base64);
		}
		
		Member insertMember = new Member(
				member.getAccount(), 
				BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()) , 
				member.getRealname(), iconBytes);
		
		testRepository.save(insertMember);
		
	}
	
	
}
