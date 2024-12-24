package tw.brad.stest3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
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
		String sql = "INSERT INTO member (account,passwd,realname,icon)" + 
					" VALUES (:account,:passwd,:realname,:icon)";
		Map<String,Object> params = new HashMap<>();
		params.put("account", member.getAccount());
		params.put("passwd", member.getPasswd());
		params.put("realname", member.getRealname());
		params.put("icon", member.getIcon());

		KeyHolder keyHolder = new GeneratedKeyHolder();
		int n = namedParameterJdbcTemplate.update(sql, new MapSqlParameterSource(params), keyHolder);
		if (n > 0) {
			int id = keyHolder.getKey().intValue();
			member.setId(id);
			return member;
		}else {
			member.setId(-1);
			return member;
		}
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
		
		
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public Member getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
