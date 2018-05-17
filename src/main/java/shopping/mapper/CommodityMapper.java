package shopping.mapper;

import org.apache.ibatis.annotations.Param;

import shopping.model.Commodity;

public interface CommodityMapper {
	Commodity getCommodityById(@Param("commodityId")int commodityId);

	int reduceCommodity(@Param("commodityId")int commodityId, @Param("count")int count);

	void addCommodityWithoutPicture(Commodity commodity);

}
