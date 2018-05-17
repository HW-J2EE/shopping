package shopping.service;

import java.util.List;

import shopping.model.Collection;

public interface CollectionService {
	
	public int collect(int user_id,int commodity_id);
	
	public int cancelCollect(int user_id, int commodity_id);
	
	public List<Collection> getCollections(int user_id);

}
