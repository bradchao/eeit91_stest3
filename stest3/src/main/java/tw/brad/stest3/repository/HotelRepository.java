package tw.brad.stest3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tw.brad.stest3.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long>{

	// findByXxx, getByXxx, queryByXxx
	List<Hotel> findByName(String name);

	List<Hotel> findByAddrStartingWith(String saddr);
	List<Hotel> findByNameEndingWith(String ename);
	
	List<Hotel> findByNameContaining(String name);	// LIKE %key%
	List<Hotel> findByNameLike(String name);		// LIKE
	List<Hotel> findByNameLikeOrAddrContaining(String like, String name2);	// LIKE %key%
	// Select FROM WHERE XXX Likw xxx OR YYY Like yyy
	/*
	 * findBy, readBy, queryBy
	 * countBy
	 * existBy
	 */
	
	/*
	 * Like, Containing, StartingWith, EndingWith
	 * Or, And
	 * Between
	 * LessThan, GreaterThan
	 */
	
	@Query(value = "SELECT id, name, addr, tel FROM hotel WHERE id > ?1", nativeQuery = true)
	List<Hotel> find1(Integer id);
	
	
}
