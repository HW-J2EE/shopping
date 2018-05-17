package shopping.mapper;

import java.util.List;

import shopping.model.Collection;
import shopping.model.User;

public interface CollectionMapper {
	
	public void addCollection(Collection collection);
	
	public void removeCollection();
	
	public List<Collection> getCts(int user_id);

}
