package shopping.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import shopping.model.Commodity;

public interface CommodityMapper {
	Commodity getCommodityById(@Param("commodityId")int commodityId);

	int reduceCommodity(@Param("commodityId")int commodityId, @Param("count")int count);

	void addCommodityWithoutPicture(Commodity commodity);

	void updateCommodityForPicture(@Param("commodityId")Integer commodityId, @Param("picture")String newFileName);

	List<Commodity> getRecommonds(@Param("userId")int userId, @Param("count")int count);

	List<Commodity> getCommodities(@Param("offsize")int offsize, @Param("count")int count);

	int getCommodityCount();

}
