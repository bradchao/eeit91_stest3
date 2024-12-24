package tw.brad.stest3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import tw.brad.stest3.model.Member;

@Component
public class MemberDaoImp implements MemberDao {
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	private Member member;

	
	@Override
	public Member add(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Member member) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Member getByAccount(String account) {
		String sql = "SELECT id,account,passwd,realname,icon " + 
					"FROM member WHERE account = :account";
		Map<String, String> params = new HashMap<>();
		params.put("account", account);
		
		List<Member> list = namedParameterJdbcTemplate.query(sql, params, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				member.setId(rs.getInt("id"));
				member.setAccount(rs.getString("account"));
				member.setPasswd(rs.getString("passwd"));
				member.setRealname(rs.getString("realname"));
				member.setIcon(rs.getBytes("icon"));
				
				return member;
			}
		});
		
		
		return null;
	}

	@Override
	public Member getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
