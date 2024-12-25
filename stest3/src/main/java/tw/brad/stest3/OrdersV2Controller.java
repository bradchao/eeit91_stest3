package tw.brad.stest3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ord")
public class OrdersV2Controller {

	@Autowired
	private OrdersV2Repository ordersV2Repository;
	
	@RequestMapping("/query/{orderId}")
	private void query1(@PathVariable Long orderId) {
		Optional<OrdersV2> orders = ordersV2Repository.findById(orderId);
		OrdersV2 order = orders.get();
		System.out.println(order.getCustomerid());
		
		List<OrderDetails> details = order.getOrderdetails();
		for (OrderDetails detail: details) {
			System.out.printf("%s:%f:%d\n", detail.getProducts().getProductname(),
					detail.getUnitprice(), detail.getQuantity());
		}
	}

	@RequestMapping("/query2/{customerId}")
	private void query2(@PathVariable String customerId) {
		List<OrdersV2> orders = ordersV2Repository.findByCustomerid(customerId);
		System.out.println(orders.size());
		
		for (OrdersV2 order : orders) {
			List<OrderDetails> details = order.getOrderdetails();
			for (OrderDetails detail: details) {
				System.out.printf("%s:%f:%d\n", detail.getProducts().getProductname(),
						detail.getUnitprice(), detail.getQuantity());
			}
			System.out.println("----");
		}
		
	}
	
	
}
