package shopping.service;

import java.util.List;

import shopping.model.CollectionModel;

public interface CollectionService {
	
	public int collect(int user_id,int commodity_id);
	
	public int cancelCollect(int user_id, int collection_id);
	
	public List<CollectionModel> getCollections(int user_id);

	public int cancelCollectByCommodityId(int user_id, int commodity_id);

}
