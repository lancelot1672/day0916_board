package model;

public class BoardDTO {
	private int bno;
	private String title;
	private String writer;
	private String content;
	private String write_date;
	private int read_count;
	
	public BoardDTO() {
	}

	public BoardDTO(String title, String writer, String content) {
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	public BoardDTO(int bno, String title, String writer, String content, String write_date, int read_count) {

		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.write_date = write_date;
		this.read_count = read_count;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}

	public int getRead_count() {
		return read_count;
	}

	public void setRead_count(int read_count) {
		this.read_count = read_count;
	}

	@Override
	public String toString() {
		return "BoardDTO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", write_date=" + write_date + ", read_count=" + read_count + "]";
	}
	
	
}
