package shopping.model;

import java.util.Date;

public class Collection {
	private int collection_id;
	private int commodity_id;
	private int user_id;
	private Date date;
	
	public static Collection createCollection(int user_id, int commodity_id) {
		Collection collection = new Collection();
		collection.setUser_id(user_id);
		collection.setCommodity_id(commodity_id);
		collection.setDate(new Date());
		return collection;
	}
	
	public int getCollection_id() {
		return collection_id;
	}
	public void setCollection_id(int collection_id) {
		this.collection_id = collection_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public int getCommodity_id() {
		return commodity_id;
	}
	public void setCommodity_id(int commodity_id) {
		this.commodity_id = commodity_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

}