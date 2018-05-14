package shopping.model;

import java.util.Date;
import java.util.HashMap;

public class ResultModel {
	HashMap<String, Object> data;
	int status;
	Date date;
	public static ResultModel successResult(HashMap<String, Object> data) {
		ResultModel resultModel = new ResultModel();
		resultModel.data = data;
		resultModel.status = 1;
		resultModel.date = new Date();
		return resultModel;
	}
	public HashMap<String, Object> getData() {
		return data;
	}
	public void setData(HashMap<String, Object> data) {
		this.data = data;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static ResultModel failResult() {
		ResultModel resultModel = new ResultModel();
		resultModel.status = 0;
		resultModel.date = new Date();
		return resultModel;
	}
}
