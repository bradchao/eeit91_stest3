package tw.brad.stest3;

import java.io.FileNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.stest3.model.Member;

@RestController
@RequestMapping("/test")
public class Test {

	@RequestMapping("/test1")
	public ResponseEntity<Member> test1() {
		Member member = new Member();
		member.setId(1);
		member.setAccount("brad");
		member.setRealname("Brad");
		
		return ResponseEntity.status(HttpStatus.CREATED).body(member);
	}
	
	@RequestMapping("/test2")
	public String test2() {
		throw new RuntimeException();
	}

	@RequestMapping("/test3")
	public String test3() throws FileNotFoundException{
		throw new FileNotFoundException();
	}

	
}
