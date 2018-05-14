package shopping.model;

import java.util.Date;
import java.util.Map;

public class ResultModel {
	Map<String, Object> data;
	int status;
	Date date;
	public static ResultModel successResult(Map<String, Object> data2) {
		ResultModel resultModel = new ResultModel();
		resultModel.data = data2;
		resultModel.status = 1;
		resultModel.date = new Date();
		return resultModel;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
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
