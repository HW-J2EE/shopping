package shopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shopping.model.CollectionModel;

public interface CollectionMapper {
	
	public void addCollection(CollectionModel collection);;
	
	public List<CollectionModel> getCts(int user_id);

	public int removeCollectionByCollectionId(@Param("collectionId")int collection_id);

	public int removeCollectionByCommodityId(@Param("userId")int user_id, @Param("commodityId")int commodity_id);

}
