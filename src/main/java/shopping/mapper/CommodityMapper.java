package shopping.mapper;

import org.apache.ibatis.annotations.Param;

import shopping.model.Commodity;

public interface CommodityMapper {
	Commodity getCommodityById(@Param("commodityId")int commodityId);

}
