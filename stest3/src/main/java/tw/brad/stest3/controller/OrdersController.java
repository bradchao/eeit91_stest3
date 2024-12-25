package tw.brad.stest3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.brad.stest3.model.Orders;
import tw.brad.stest3.repository.OrdersRepository;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	private OrdersRepository ordersRepository;
	
	@PostMapping("/test1")
	private void test1() {
		List<Orders> list = ordersRepository.findOrdersByCompanyname("Around the Horn");
		System.out.println(list.size());
		for (Orders order : list) {
			System.out.printf("%d : %s : %s\n", order.getOrderID(), order.getOrderDate(), 
					order.getCustomers().getCompanyname());
		}
		
		
	}
	
}
