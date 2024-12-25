package tw.brad.stest3;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersV2Repository extends JpaRepository<OrdersV2, Long>{
	List<OrdersV2> findByCustomerid(String id);
}
