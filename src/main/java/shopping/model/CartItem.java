package shopping.model;

import shopping.model.mongo.Cart.Item;

public class CartItem {
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