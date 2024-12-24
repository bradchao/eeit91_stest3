package tw.brad.stest3.service;

import org.springframework.web.multipart.MultipartFile;

import tw.brad.stest3.model.Member;

public interface MemberService {
	public Member isAccountExist(String account);
	public Member register(Member member, MultipartFile icon);
	public boolean update(Member member, MultipartFile icon);
	public Member login(Member member);
	
	
}
