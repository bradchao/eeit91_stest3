package tw.brad.stest3.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Transient;

@Entity
@Component
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	// 0
	private String account;
	private String passwd;
	private String realname;
	
	// @JsonIgnore
	@Transient
	private String iconString;
	
	public String getIconString() {
		return iconString;
	}
	public void setIconString(String iconString) {
		this.iconString = iconString;
	}
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] icon = null;
	
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
