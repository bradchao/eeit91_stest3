package tw.brad.stest3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import tw.brad.stest3.dao.MemberDao;
import tw.brad.stest3.model.Member;
import tw.brad.stest3.util.BCrypt;

@Component
public class MemberServiceImp implements MemberService{

	@Autowired
	private MemberDao memberDao;
	
	@Override
	public Member isAccountExist(String account) {
		return memberDao.getByAccount(account);
	}

	@Override
	public Member register(Member member, MultipartFile icon) {
		member.setPasswd(BCrypt.hashpw(member.getPasswd(), BCrypt.gensalt()));
		if (icon != null) {
			try {
				member.setIcon(icon.isEmpty()?null:icon.getBytes());
			}catch(Exception e) {
				member.setIcon(null);
			}
		}
		
		return memberDao.add(member);
	}

	@Override
	public boolean update(Member member, MultipartFile icon) {
		return memberDao.update(member);
	}

	@Override
	public Member login(Member loginMember) {
		Member member = memberDao.getByAccount(loginMember.getAccount());
		if (member != null) {
			if (!BCrypt.checkpw(loginMember.getPasswd(), member.getPasswd())) {
				member = null;
			}
		}
		
		return member;
	}

}
