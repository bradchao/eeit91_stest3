package tw.brad.stest3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.brad.stest3.model.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	@Query("SELECT o FROM Orders o JOIN o.customers c WHERE c.companyname = :companyname")
	List<Orders> findOrdersByCompanyname(@Param("companyname") String companyname);
	
}
