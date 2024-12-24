package tw.brad.stest3.model;

import org.springframework.stereotype.Component;

@Component
public class MemberResponse {
	private int errCode;	// -1: not found/failure; 0:nothing;  1: found/success
	private Member member;
	
	public int getErrCode() {
		return errCode;
	}
	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	
	
	
}
