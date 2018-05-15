package shopping.model;

import java.io.Serializable;
import java.util.List;

import shopping.model.mongo.Cart;


public class CartDetail implements Serializable{

	private static final long serialVersionUID = -8132251857549330706L;
	
	private int userId;
	private int commodityCount;
	private double totalPrice;
	private List<CartItem> items;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	
	

	public static CartDetail createEmptyCart(int userId) {
		CartDetail cartDetail = new CartDetail();
		cartDetail.setUserId(userId);
		cartDetail.setCommodityCount(0);
		cartDetail.setTotalPrice(0);
		cartDetail.setItems(null);
		return cartDetail;
	}
	public static CartDetail fromCartAndCartItems(Cart cart, List<CartItem> cartItems, double totalPrice) {
		CartDetail cartDetail = new CartDetail();
		cartDetail.setUserId(cart.getUserId());
		cartDetail.setItems(cartItems);
		cartDetail.setCommodityCount(cartItems.size());
		cartDetail.setTotalPrice(totalPrice);
		return cartDetail;
	}
}
