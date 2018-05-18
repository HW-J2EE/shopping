package shopping.service;

import java.io.IOException;
import java.util.List;


import org.springframework.web.multipart.MultipartFile;

import shopping.model.Commodity;

public interface CommodityService {

	Commodity addCommodity(Commodity commodity);

	List<Commodity> recommondCommodictories(int id, int count);

	Commodity uploadPictureOfCommodity(Integer commodityId, MultipartFile picture) throws IOException;
	
}
