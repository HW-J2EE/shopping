package shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.mapper.CommodityMapper;
import shopping.model.Commodity;
import shopping.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityMapper commodityMapper;
	
	@Override
	public Commodity addCommodity(Commodity commodity) {
		commodityMapper.addCommodityWithoutPicture(commodity);
		return commodity;
	}

}
