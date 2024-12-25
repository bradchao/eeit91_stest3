package tw.brad.stest3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.stest3.model.Member;
import tw.brad.stest3.repository.TestRepository;

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
	
}
