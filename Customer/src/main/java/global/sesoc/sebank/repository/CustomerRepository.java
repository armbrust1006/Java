package global.sesoc.sebank.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.sebank.dao.CustomerDAO;
import global.sesoc.sebank.vo.Customer;

@Repository
public class CustomerRepository implements CustomerDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public int insert(Customer customer) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		return dao.insert(customer);
	}

	@Override
	public String idCheck(String custid) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		return dao.idCheck(custid);
	}

	@Override
	public Customer login(Customer customer) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		return dao.login(customer);
	}

	@Override
	public Customer updateSelect(String custid) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		Customer customer = dao.updateSelect(custid);
		return customer;
	}

	@Override
	public int update(Customer customer) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		return dao.update(customer);
	}

}
