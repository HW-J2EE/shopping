package shopping.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class Cart {

	@Id
	private int userId;
	private List<Item> items;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}


	public static class Item {
		private int commodityId;
		private int count;
		public int getCommodityId() {
			return commodityId;
		}
		public void setCommodityId(int commodityId) {
			this.commodityId = commodityId;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public void countAdd(int count2) {
			this.count = this.count + count2;
			
		}
		public static Item createItem(int commodityId2, int count2) {
			Item item = new Item();
			item.setCommodityId(commodityId2);
			item.setCount(count2);
			return item;
		}
	}


	public void addItem(Item item) {
		this.items.add(item);	
	}
	public static Cart createCartFromUserId(int userId) {
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setItems(new ArrayList<>());
		return cart;
	}
}
