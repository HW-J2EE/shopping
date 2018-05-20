package shopping.service.impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.mapper.CollectionMapper;
import shopping.mapper.CommodityMapper;
import shopping.model.CollectionModel;
import shopping.model.Commodity;
import shopping.service.CollectionService;

@Service
public class CollectionServiceImpl implements CollectionService{
	
	@Autowired
	private CollectionMapper collectionMapper;
	@Autowired
	private CommodityMapper commodityMapper;
	
	@Override
	public int collect(int user_id,int commodity_id) {
		CollectionModel collection = CollectionModel.createCollection(user_id, commodity_id);
		collectionMapper.addCollection(collection);
		return 1;
	}
	
	@Override
	public int cancelCollect(int user_id,int collection_id) {
		return collectionMapper.removeCollectionByCollectionId(collection_id);
	}
	
	@Override
	public List<CollectionModel> getCollections(int user_id) {
		List<CollectionModel> collectionList;
		collectionList = collectionMapper.getCts(user_id);
		Iterator<CollectionModel> iterator = collectionList.iterator();
		while(iterator.hasNext()) {
			CollectionModel temp = iterator.next();
			temp.setCommodity(commodityMapper.getCommodityById(temp.getCommodity_id()));
		}
		return collectionList;
	}

	@Override
	public int cancelCollectByCommodityId(int user_id, int commodity_id) {
		return collectionMapper.removeCollectionByCommodityId(user_id, commodity_id);
	}

}
