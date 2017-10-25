package league.ViewBean;

import java.util.List;

public class AssociatedAccountAjaxOutBean {
	String msg;
	List<AssociatedAccountAjaxOutOneBean> accountList;
	
	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}
	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	/**
	 * @return the accountList
	 */
	public List<AssociatedAccountAjaxOutOneBean> getAccountList() {
		return accountList;
	}
	/**
	 * @param accountList the accountList to set
	 */
	public void setAccountList(List<AssociatedAccountAjaxOutOneBean> accountList) {
		this.accountList = accountList;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AssociatedAccountAjaxOutBean [msg=" + msg + ", accountList=" + accountList + "]";
	}
	
}
