package global.sesoc.sebank.dao;

import java.util.List;
import java.util.Map;

import global.sesoc.sebank.vo.Board;

public interface BoardDAO {

	public List<Board> listBoard(Map<String, Object> search) throws Exception;

	public int insertBoard(Board board) throws Exception;

	public Board getBoard(int boardnum) throws Exception;

	public int addHits(int boardnum) throws Exception;

	// select count(*) from board where title like '%'||#{searchText}||'%';
	public int getCount(Map<String, Object> search) throws Exception;

	public int updateBoard(Board board) throws Exception;

	public int delelteBoard(int boardnum) throws Exception;

	public Board boardDetail();
}
