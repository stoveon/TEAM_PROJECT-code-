package home.inside.board.util;

public class ArticleMgrCommand {
	private int num;
	private String writer;
	private String boardCode;
	private String title;
	private String content;
	private String notify;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
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
	public String getNotify() {
		return notify;
	}
	public void setNotify(String notify) {
		this.notify = notify;
	}
	@Override
	public String toString() {
		return "ArticleMgrCommand [num=" + num + ", writer=" + writer + ", boardCode=" + boardCode + ", title=" + title
				+ ", content=" + content + ", notify=" + notify + "]";
	}
	
	
}
