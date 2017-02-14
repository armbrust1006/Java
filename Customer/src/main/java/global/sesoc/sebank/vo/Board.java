package global.sesoc.sebank.vo;

import java.util.Date;

public class Board {
	private int boardnum, hits;
	private String custid, title, content, originalfile, savedfile;
	private Date inputdate;

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getOriginalfile() {
		return originalfile;
	}

	public void setOriginalfile(String originalfile) {
		this.originalfile = originalfile;
	}

	public String getSavedfile() {
		return savedfile;
	}

	public void setSavedfile(String savedfile) {
		this.savedfile = savedfile;
	}

	public Date getInputdate() {
		return inputdate;
	}

	public void setInputdate(Date inputdate) {
		this.inputdate = inputdate;
	}

	@Override
	public String toString() {
		return "Board [boardnum=" + boardnum + ", custid=" + custid + ", title=" + title + ", content=" + content
				+ ", hits=" + hits + ", originalfile=" + originalfile + ", savedfile=" + savedfile + ", inputdate="
				+ inputdate + "]";
	}

}
