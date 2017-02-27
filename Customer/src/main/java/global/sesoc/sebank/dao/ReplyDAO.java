package global.sesoc.sebank.dao;

import java.util.List;

import global.sesoc.sebank.vo.Reply;

public interface ReplyDAO {

	public List<Reply> replyList(int boardnum) throws Exception;

	public int replyInsert(Reply reply) throws Exception;

	public int replyUpdate(Reply reply) throws Exception;

	public int replyDelete(int replynum) throws Exception;

}
