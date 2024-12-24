package tw.brad.stest3;

import java.io.FileNotFoundException;
import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import jakarta.servlet.http.HttpSession;
import tw.brad.stest3.model.Member;
import tw.brad.stest3.model.Member2;

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

	@GetMapping("/test4")
	public RedirectView test4() {
		RedirectView redirect = new RedirectView();
		redirect.setUrl("/brad03.html");
		return redirect;
	}
	
	@GetMapping("/test7")
	public ResponseEntity<Void> test7() {
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create("/brad03.html"));
		return new ResponseEntity<>(headers, HttpStatus.FOUND);
	}
	
	@PostMapping("/test8")
	public void test8(@RequestBody Member2 member2, HttpSession session) {
		Member member = new Member(member2.getAccount(),
							member2.getPasswd(),
							member2.getRealname(),
							null);
		member.setId(777);
		
		session.setAttribute("member", member);
	}
	
	@PostMapping("/test9")
	public void test9(HttpSession session) {
		if (session.getAttribute("member") != null) {
			Member member = (Member)session.getAttribute("member"); 
			System.out.println(member.getId() + ":" + member.getRealname());
		}else {
			System.out.println("XX");
		}
	}
	
	@PostMapping("/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	
	
	
	
	

}
