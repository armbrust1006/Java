package global.sesoc.sebank.dao;

import global.sesoc.sebank.vo.Customer;

public interface CustomerDAO {
	public int insert(Customer customer);

	public String idCheck(String custid);

	public Customer login(Customer customer);

	public Customer updateSelect(String custid);

	public int update(Customer customer);
}
