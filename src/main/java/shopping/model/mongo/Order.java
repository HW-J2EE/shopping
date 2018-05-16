package shopping.model.mongo;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import shopping.model.CartItem;

@Document
public class Order {

	@Id
	private long id;
	private int userId;
	private int status;  //1已支付，0待支付，2订单取消
	private int commodityCount;
	private double totalPrice;
	private List<CartItem> items;
	public static Order fromCartAndCartItems(Cart cart, List<CartItem> cartItems, double totalPrice2) {
		Order order = new Order();
		order.id = (new Date().getTime())*10+new Random().nextInt(10);
		order.userId = cart.getUserId();
		order.totalPrice = totalPrice2;
		order.commodityCount = cartItems.size();
		order.items=cartItems;
		order.status=0;
		return order;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCommodityCount() {
		return commodityCount;
	}
	public void setCommodityCount(int commodityCount) {
		this.commodityCount = commodityCount;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public List<CartItem> getItems() {
		return items;
	}
	public void setItems(List<CartItem> items) {
		this.items = items;
	}

}
