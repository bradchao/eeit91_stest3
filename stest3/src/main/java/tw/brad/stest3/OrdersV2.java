package tw.brad.stest3;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table( name = "Orders")
public class OrdersV2 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	private Long orderId;
	
	@Column(name = "CustomerID")
	private String customerid;
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
	private List<OrderDetails> orderdetails;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}


	
	
	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public List<OrderDetails> getOrderdetails() {
		return orderdetails;
	}

	public void setOrderdetails(List<OrderDetails> orderdetails) {
		this.orderdetails = orderdetails;
	}


	
	
	
}
