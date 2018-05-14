package shopping.model;

import java.io.Serializable;
import java.util.List;

import shopping.model.mongo.Cart;
import shopping.model.mongo.Cart.Item;


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
	
	public static class CartItem {
		private int commodityId;
		private String commodityName;
		private String picture;
		private double price;
		private int count;
		public int getCommodityId() {
			return commodityId;
		}
		public void setCommodityId(int commodityId) {
			this.commodityId = commodityId;
		}
		public String getCommodityName() {
			return commodityName;
		}
		public void setCommodityName(String commodityName) {
			this.commodityName = commodityName;
		}
		public String getPicture() {
			return picture;
		}
		public void setPicture(String picture) {
			this.picture = picture;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public static CartItem fromCommodityAndItem(Item item, Commodity commodity) {
			CartItem cartItem = new CartItem();
			cartItem.setCommodityId(item.getCommodityId());
			cartItem.setCommodityName(commodity.getName());
			cartItem.setCount(item.getCount());
			cartItem.setPicture(commodity.getPicture());
			cartItem.setPrice(commodity.getPrice());
			return cartItem;
		}
		
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
