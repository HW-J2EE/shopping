package shopping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.mapper.CollectionMapper;
import shopping.model.CollectionModel;
import shopping.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService{
	
	@Autowired
	private CollectionMapper collectionMapper;
	
	
	@Override
	public int collect(int user_id,int commodity_id) {
		CollectionModel collection = CollectionModel.createCollection(user_id, commodity_id);
		collectionMapper.addCollection(collection);
		return 1;
	}
	
	@Override
	public int cancelCollect(int user_id,int collection_id) {
		collectionMapper.removeCollection();
		return 1;
	}
	
	@Override
	public List<CollectionModel> getCollections(int user_id) {
		List<CollectionModel> collectionList;
		collectionList = collectionMapper.getCts(user_id);
		return collectionList;
	}

}
