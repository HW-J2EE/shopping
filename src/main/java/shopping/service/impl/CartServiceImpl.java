package shopping.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import shopping.mapper.CommodityMapper;
import shopping.model.CartDetail;
import shopping.model.CartDetail.CartItem;
import shopping.model.Commodity;
import shopping.model.mongo.Cart;
import shopping.model.mongo.Cart.Item;
import shopping.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private MongoOperations mongo;
	@Autowired
	private CommodityMapper commodityMapper;
	
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
					if(item.getCount()==0) {
						iterator.remove();
					}
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

	@Override
	public CartDetail getCarts(int userId) {
		Cart cart = mongo.findOne(Query.query(Criteria.where("_id").is(userId)), Cart.class, "carts");
		CartDetail cartDetail = null;
		if(cart==null) {
			cartDetail = CartDetail.createEmptyCart(userId);
		}else {
			List<CartItem> cartItems = new ArrayList<>();
			Iterator<Item> iterator = cart.getItems().iterator();
			Item item;Commodity commodity;double totalPrice=0;
			while(iterator.hasNext()) {
				item = iterator.next();
				commodity = commodityMapper.getCommodityById(item.getCommodityId());
				totalPrice += commodity.getPrice()*item.getCount();
				cartItems.add(CartItem.fromCommodityAndItem(item, commodity));
			}
			cartDetail = CartDetail.fromCartAndCartItems(cart, cartItems, totalPrice);
		}
		return cartDetail;
	}

}
