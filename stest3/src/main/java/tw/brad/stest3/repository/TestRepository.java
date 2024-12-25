package tw.brad.stest3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;
import tw.brad.stest3.model.Member;

@Transactional
@Repository
public interface TestRepository extends JpaRepository<Member, Integer> {

}
