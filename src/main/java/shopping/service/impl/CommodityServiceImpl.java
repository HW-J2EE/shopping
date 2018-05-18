package shopping.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import shopping.common.CosTool;
import shopping.mapper.CommodityMapper;
import shopping.model.Commodity;
import shopping.service.CommodityService;

@Service
public class CommodityServiceImpl implements CommodityService {
	
	@Autowired
	private CommodityMapper commodityMapper;
	@Autowired
	private CosTool cosTool;
	
	public Commodity addCommodity(Commodity commodity) {
		commodityMapper.addCommodityWithoutPicture(commodity);
		return commodity;
	}

	@Override
	public List<Commodity> recommondCommodictories(int id, int count) {
		return null;
		// TODO 自动生成的方法存根
		
	}

	@Override
	public Commodity uploadPictureOfCommodity(Integer commodityId, MultipartFile picture) throws IOException {
		String[] oldFileNameArray = picture.getOriginalFilename().split("\\.");
		String newFileName = "/"+
							 String.valueOf(commodityId) + 
							 "_"+
							 String.valueOf(new Date().getTime()) +
							 "."+
							 oldFileNameArray[oldFileNameArray.length-1];
		newFileName = cosTool.uploadPicture(picture.getBytes(), newFileName);
		
		System.out.println(newFileName);
		if(newFileName==null)return null;
		commodityMapper.updateCommodityForPicture(commodityId, newFileName);
		return commodityMapper.getCommodityById(commodityId);
	}

}
