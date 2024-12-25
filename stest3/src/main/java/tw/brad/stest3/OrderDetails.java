package tw.brad.stest3;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderdetails")
public class OrderDetails {

	@EmbeddedId
	private OrderProductKey id;
	
	@Column(name = "ProductID")
	private Long productId;

	@Column(name = "OrderID")
	private Long orderId;
	
	private Double unitprice;
	
	private Integer quantity;

	@ManyToOne
	@MapsId("orderId")
	@JoinColumn(name = "OrderID")
	private OrdersV2 orders;
	
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "ProductID")
	private Products products;

	public OrderProductKey getId() {
		return id;
	}

	public void setId(OrderProductKey id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public OrdersV2 getOrders() {
		return orders;
	}

	public void setOrders(OrdersV2 orders) {
		this.orders = orders;
	}

	public Products getProducts() {
		return products;
	}

	public void setProducts(Products products) {
		this.products = products;
	}

	public Double getUnitprice() {
		return unitprice;
	}

	public void setUnitprice(Double unitprice) {
		this.unitprice = unitprice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
