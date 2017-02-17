package global.sesoc.sebank.dao;

import java.util.List;

import global.sesoc.sebank.vo.Board;

public interface BoardDAO {

	public List<Board> list();

	public int write(Board board);

	public Board read(int num);

	public Board update(int boardnum, String custid);

	public int delelte(int boardnum, String custid);
}
