package global.sesoc.ajaxtest.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.ajaxtest.dao.FriendDAO;
import global.sesoc.ajaxtest.vo.Friend;

@Repository
public class HomeRepository implements FriendDAO {

	@Autowired
	private SqlSession sqlsession;

	@Override
	public int insert(Friend friend) {
		FriendDAO dao = sqlsession.getMapper(FriendDAO.class);
		try {
			return dao.insert(friend);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
