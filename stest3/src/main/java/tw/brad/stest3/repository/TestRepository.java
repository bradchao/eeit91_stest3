package tw.brad.stest3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import tw.brad.stest3.model.Member;

@Transactional
@Repository
public interface TestRepository extends JpaRepository<Member, Integer> {

	@Modifying
	@Query("UPDATE Member m SET m.realname = :realname WHERE m.id = :id")
	public int updateRealnameById(@Param("id") Integer id, @Param("realname")String realname);
	
}
