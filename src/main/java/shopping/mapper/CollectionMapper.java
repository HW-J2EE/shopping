package shopping.mapper;

import java.util.List;

import shopping.model.CollectionModel;

public interface CollectionMapper {
	
	public void addCollection(CollectionModel collection);
	
	public void removeCollection();
	
	public List<CollectionModel> getCts(int user_id);

}
