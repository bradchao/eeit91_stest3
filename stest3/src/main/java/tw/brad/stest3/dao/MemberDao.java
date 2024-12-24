package tw.brad.stest3.dao;

import tw.brad.stest3.model.Member;

public interface MemberDao {
	public Member add(Member member);
	public boolean update(Member member);
	public boolean delete(Member member);
	
	// getByXxx, findByXxx, queryByXxx
	public Member getByAccount(String account);
	public Member getById(int id);
	
}
