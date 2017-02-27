package global.sesoc.sebank.dao;

import global.sesoc.sebank.vo.Customer;

public interface CustomerDAO {
	public int insert(Customer customer) throws Exception;

	public String idCheck(String custid) throws Exception;

	public Customer login(Customer customer) throws Exception;

	public Customer updateSelect(String custid) throws Exception;

	public int update(Customer customer) throws Exception;
}
