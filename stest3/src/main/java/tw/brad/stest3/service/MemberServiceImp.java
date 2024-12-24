package tw.brad.stest3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tw.brad.stest3.dao.MemberDao;
import tw.brad.stest3.model.Member;

@Component
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member isAccountExist(String account) {
		return memberDao.getByAccount(account);
	}

	@Override
	public Member register(Member member) {
		return memberDao.add(member);
	}

	@Override
	public boolean update(Member member) {
		return memberDao.update(member);
	}

}
