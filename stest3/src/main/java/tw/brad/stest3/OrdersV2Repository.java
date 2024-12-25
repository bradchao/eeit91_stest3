package tw.brad.stest3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersV2Repository extends JpaRepository<OrdersV2, Long>{

}
