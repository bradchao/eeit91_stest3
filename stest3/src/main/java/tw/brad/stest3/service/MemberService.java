package tw.brad.stest3.service;

import tw.brad.stest3.model.Member;

public interface MemberService {
	public Member isAccountExist(String account);
	public Member register(Member member);
	public boolean update(Member member);
	
	
}
