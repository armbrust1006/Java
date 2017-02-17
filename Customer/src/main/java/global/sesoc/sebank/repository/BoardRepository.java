package global.sesoc.sebank.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.sebank.dao.BoardDAO;
import global.sesoc.sebank.dao.CustomerDAO;
import global.sesoc.sebank.vo.Board;
import global.sesoc.sebank.vo.Customer;

@Repository
public class BoardRepository implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Board> list() {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return null;
	}

	@Override
	public int write(Board board) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		return dao.write(board);
	}

	@Override
	public Board read(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board update(int boardnum, String custid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delelte(int boardnum, String custid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
