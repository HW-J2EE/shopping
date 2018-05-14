package shopping.service.impl;

import java.util.Iterator;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import shopping.model.Cart;
import shopping.model.Cart.Item;
import shopping.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private MongoOperations mongo;
	
	@Override
	public boolean addCommodityToCart(int userId, int commodityId, int count) {
		Query query = Query.query(Criteria.where("_id").is(userId));
		Cart cart = mongo.findOne(query, Cart.class, "carts");
		if(cart!=null) {
			Iterator<Item> iterator = cart.getItems().iterator();
			Item item;
			boolean exist = false;
			while(iterator.hasNext()) {
				item = iterator.next();
				if(item.getCommodityId()==commodityId) {
					exist = true;
					item.countAdd(count);
					break;
				}
			}
			if(!exist) {
				item = Item.createItem(commodityId, count);
				cart.addItem(item);
			}
//			mongo.updateFirst(query, Update.update("items", cart.getItems()), Cart.class, "carts");
		}else {
			cart = Cart.createCartFromUserId(userId);
			Item item = Item.createItem(commodityId, count);
			cart.addItem(item);
		}
		mongo.save(cart, "carts");
		return true;
	}

}
