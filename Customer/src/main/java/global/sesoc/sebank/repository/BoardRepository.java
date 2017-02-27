package global.sesoc.sebank.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import global.sesoc.sebank.dao.BoardDAO;
import global.sesoc.sebank.vo.Board;

@Repository
public class BoardRepository implements BoardDAO {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<Board> listBoard(Map<String, Object> search) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		try {
			return dao.listBoard(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBoard(Board board) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		try {
			return dao.insertBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Board getBoard(int boardnum) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		try {
			dao.addHits(boardnum);
			return dao.getBoard(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int addHits(int boardnum) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		try {
			return dao.addHits(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int getCount(Map<String, Object> search) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		try {
			return dao.getCount(search);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBoard(Board board) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		try {
			return dao.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delelteBoard(int boardnum) {
		BoardDAO dao = sqlSession.getMapper(BoardDAO.class);
		try {
			return dao.delelteBoard(boardnum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Board boardDetail() {
		return null;
	}

}
