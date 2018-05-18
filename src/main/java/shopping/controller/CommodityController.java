package shopping.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import shopping.model.Commodity;
import shopping.model.ResultModel;
import shopping.service.CommodityService;

@RestController
@RequestMapping("/commodity")
public class CommodityController {
	
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping(value="/addCommodity", 
			params={
				 "name", "price", "stock"
			}
	)
	public ResultModel addCommodity(Commodity commodity) {
		commodity = commodityService.addCommodity(commodity);
		if(commodity==null) {
			return ResultModel.failResult();
		}else {
			Map<String, Object> map = new HashMap<>();
			map.put("commodity", commodity);
			return ResultModel.successResult(map);
		}
	}
	
	@RequestMapping("/uploadPicture")
	public ResultModel uploadPicture(Integer commodityId, 
//			@RequestPart("picture")Part picture,
			MultipartFile picture,						//config bean of multipartResolver in WebConfig
			HttpSession httpSession
			) throws IOException {
		try {
			Commodity commodity = commodityService.uploadPictureOfCommodity(commodityId, picture);
			if(commodity==null)return ResultModel.failResult();
			Map<String, Object> data = new HashMap<>();
			data.put("commodity", commodity);
			return ResultModel.successResult(data);
		} catch (IOException e) {
			e.printStackTrace();
			return ResultModel.failResult();
		}
	}
}
