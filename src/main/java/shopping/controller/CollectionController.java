package shopping.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import shopping.model.CollectionModel;
import shopping.model.ResultModel;
import shopping.service.CollectionService;

@RestController
@RequestMapping("/collection")
public class CollectionController {
	
	@Autowired
	private CollectionService collectionService;
	
	@RequestMapping("/collect")
	@ResponseBody
	public ResultModel collect(int user_id, int commodity_id) {
		HashMap<String, Object> hashMap = new HashMap<>();
		int collectState = collectionService.collect(user_id,commodity_id);
		if(collectState != 0) {
			//hashMap.put("collectState", collectState);
			return ResultModel.successResult(hashMap);
		}
		else {
			return ResultModel.failResult();
		}
	}
	
	@RequestMapping("/cancelCollect")
	@ResponseBody
	public ResultModel cancelCollect(
			int user_id, 
			@RequestParam(value="collection_id", required=false, defaultValue="-1")int collection_id,
			@RequestParam(value="commodity_id",required=false,defaultValue="-1")int commodity_id) {
		HashMap<String, Object> hashMap = new HashMap<>();
		int cancelCollectState=0;
		if(collection_id!=-1) {
			cancelCollectState = collectionService.cancelCollect(user_id,collection_id);
		}else {
			cancelCollectState = collectionService.cancelCollectByCommodityId(user_id, commodity_id);
		}
		if(cancelCollectState != 0) {
			//hashMap.put("cancelCollectState", cancelCollectState);
			return ResultModel.successResult(hashMap);
		}
		else {
			return ResultModel.failResult();
		}
	}
	
	@RequestMapping("/getCollections")
	@ResponseBody
	public ResultModel getCollections(int user_id) {
		Map<String, Object> hashMap = new HashMap<>();
		List<CollectionModel> collectionList = new ArrayList<>();
		collectionList = collectionService.getCollections(user_id);
		if(collectionList != null) {
			hashMap.put("collectionList", collectionList);
			return ResultModel.successResult(hashMap);
		}
		else {
			return ResultModel.failResult();
		}
	}

}
