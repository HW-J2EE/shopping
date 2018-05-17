package shopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.mapper.CollectionMapper;
import shopping.model.Collection;
import shopping.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService{
	
	@Autowired
	private CollectionMapper collectionMapper;
	
	
	@Override
	public int collect(int user_id,int commodity_id) {
		Collection collection = Collection.createCollection(user_id, commodity_id);
		collectionMapper.addCollection(collection);
		return 1;
	}
	
	@Override
	public int cancelCollect(int user_id,int commodity_id) {
		collectionMapper.removeCollection();
		return 1;
	}
	
	@Override
	public List<Collection> getCollections(int user_id) {
		List<Collection> collectionList = new ArrayList<>();
		collectionList = collectionMapper.getCts(user_id);
		return collectionList;
	}

}
