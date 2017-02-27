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
		int result = 0;
		try {
			result = dao.insert(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public String idCheck(String custid) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		String result = null;
		try {
			result = dao.idCheck(custid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Customer login(Customer customer) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		Customer result = new Customer();
		try {
			result = dao.login(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Customer updateSelect(String custid) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		Customer result = new Customer();
		try {
			result = dao.updateSelect(custid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(Customer customer) {
		CustomerDAO dao = sqlSession.getMapper(CustomerDAO.class);
		int result = 0;
		try {
			result = dao.update(customer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
