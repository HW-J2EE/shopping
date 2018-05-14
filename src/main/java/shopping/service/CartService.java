package shopping.service;

public interface CartService {
	public boolean addCommodityToCart(int userId, int commodityId, int count);
}
