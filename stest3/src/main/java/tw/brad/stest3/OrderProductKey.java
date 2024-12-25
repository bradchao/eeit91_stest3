package tw.brad.stest3;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class OrderProductKey implements Serializable{
	private Long orderId;
	private Long productId;
	
	public OrderProductKey() {}
	
	public OrderProductKey(Long orderId, Long productId) {
		this.orderId = orderId; this.productId = productId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
