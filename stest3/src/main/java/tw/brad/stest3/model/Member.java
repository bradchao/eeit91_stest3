package tw.brad.stest3.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Component
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	// 0
	private String account;
	private String passwd;
	private String realname;
	private byte[] icon;
	
	public Member() {}
	public Member(String account, String passwd, String realname) {
		this(account,passwd,realname, null);
	}
	public Member(String account, String passwd, String realname, byte[] icon) {
		this.account = account;
		this.passwd = passwd;
		this.realname = realname;
		this.icon = icon;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public byte[] getIcon() {
		return icon;
	}
	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
	
	
	
	
}
