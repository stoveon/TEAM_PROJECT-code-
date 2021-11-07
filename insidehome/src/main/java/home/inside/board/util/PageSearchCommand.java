package home.inside.board.util;

public class PageSearchCommand {
	private int num;
	private String boardCode;
	private Integer pageNum;
	private Integer currentPage;
	private int startNum;
	private int endNum;
	private int count;
	private int pageSize;
	private int number;
	private String type;
	private String word;
	public String getBoardCode() {
		return boardCode;
	}
	public void setBoardCode(String boardCode) {
		this.boardCode = boardCode;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartNum() {
		return startNum;
	}
	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}
	public int getEndNum() {
		return endNum;
	}
	public void setEndNum(int endNum) {
		this.endNum = endNum;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Override
	public String toString() {
		return "PageSearchCommand [boardCode=" + boardCode + ", pageNum=" + pageNum + ", currentPage=" + currentPage
				+ ", startNum=" + startNum + ", endNum=" + endNum + ", count=" + count + ", pageSize=" + pageSize
				+ ", number=" + number + ", type=" + type + ", word=" + word + "]";
	}
	
	
	
}
