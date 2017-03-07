package global.sesoc.ajaxtest.vo;

public class Friend {
	private String custid, password, text;

	public Friend(String custid, String password, String text) {
		super();
		this.custid = custid;
		this.password = password;
		this.text = text;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Customer [name=" + custid + ", password=" + password + ", text=" + text + "]";
	}

}
