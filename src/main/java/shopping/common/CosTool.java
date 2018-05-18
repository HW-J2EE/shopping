package shopping.common;



import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.meta.InsertOnly;
import com.qcloud.cos.request.DelFileRequest;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;

/**
 * 腾讯云Cos对象服务器接口封装类
 * 使用的是4.6老版SDK
 * @author cj
 */
public class CosTool {
	
	private String bucketName;
	private String baseUrl;
	private Credentials cred;
	private ClientConfig clientConfig;
	
	public CosTool(Environment env) {
		cred = new Credentials(
				env.getProperty("appId", Long.class), 
				env.getProperty("secretId"), 
				env.getProperty("secretKey")
				);
		clientConfig = new ClientConfig();
		clientConfig.setRegion(env.getProperty("region"));
		bucketName = env.getProperty("bucketName");
		baseUrl = env.getProperty("baseUrl");
	}
	/**
	 * 文件上传接口
	 * @param picture
	 * @param filePath
	 * @return
	 */
	public String uploadPicture(byte[] picture, String filePath) {
		COSClient client = new COSClient(clientConfig, cred);
		UploadFileRequest request = new UploadFileRequest(bucketName, filePath, picture);
		request.setInsertOnly(InsertOnly.OVER_WRITE);
		String uploadFileRet = client.uploadFile(request);
		JSONObject res = JSONObject.parseObject(uploadFileRet);
		client.shutdown();
		if(res.getIntValue("code")==0) {
			System.out.println(uploadFileRet);
			return baseUrl+filePath;
		}else {
			System.out.println(uploadFileRet);
			
			return null;
		}
 	}
	
	public boolean deleteFoodPicture(String fileName) {
		COSClient client = new COSClient(clientConfig, cred);
		DelFileRequest request = new DelFileRequest(bucketName, fileName);
		String delFileRet = client.delFile(request);
		JSONObject res = JSONObject.parseObject(delFileRet);
		client.shutdown();
		if(res.getIntValue("code")==0) {
			return true;
		}else {
			System.out.println(delFileRet);
			return false;
		}
	}
}
