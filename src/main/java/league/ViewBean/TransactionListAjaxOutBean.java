package league.ViewBean;

import java.util.List;

public class TransactionListAjaxOutBean {
	String msg;
	String code;
	int count;
	List<TransactionListAjaxOutOneBean> transList;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<TransactionListAjaxOutOneBean> getResult() {
		return transList;
	}

	public void setResult(List<TransactionListAjaxOutOneBean> transList) {
		this.transList = transList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
