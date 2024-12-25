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
@Table(name = "Products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
	private Long productid;
	
	//@Column(name = "Productname")
	private String productname;
	
	@OneToMany(mappedBy = "products", cascade = CascadeType.ALL)
	private List<OrderDetails> orderDetails;

	public Long getProductid() {
		return productid;
	}

	public void setProductid(Long productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
