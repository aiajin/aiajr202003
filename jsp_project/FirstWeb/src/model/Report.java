package model;

public class Report {
	private int idx;
	private String sname;
	private String sno;
	private String report;

	public Report(int idx, String sname, String sno, String report) {
		this.idx = idx;
		this.sname = sname;
		this.sno = sno;
		this.report = report;
	}

	public Report() {
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return "Report [idx=" + idx + ", sname=" + sname + ", sno=" + sno + ", report=" + report + "]";
	}

}
