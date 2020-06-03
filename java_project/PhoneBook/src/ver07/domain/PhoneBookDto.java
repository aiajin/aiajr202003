package ver07.domain;

import java.sql.Date;

public class PhoneBookDto {

	private int idx;
	private String fr_name;
	private String fr_phonenumber;
	private String fr_email;
	private String fr_address;
	private Date fr_regdate;
	private String fr_u_major;
	private String fr_u_year;
	private String fr_c_company;

	public PhoneBookDto() {
	}

	public PhoneBookDto(int idx, String fr_name, String fr_phonenumber, String fr_email, String fr_address,
			Date fr_regdate, String fr_u_major, String fr_u_year, String fr_c_company) {
		this.idx = idx;
		this.fr_name = fr_name;
		this.fr_phonenumber = fr_phonenumber;
		this.fr_email = fr_email;
		this.fr_address = fr_address;
		this.fr_regdate = fr_regdate;
		this.fr_u_major = fr_u_major;
		this.fr_u_year = fr_u_year;
		this.fr_c_company = fr_c_company;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getFr_name() {
		return fr_name;
	}

	public void setFr_name(String fr_name) {
		this.fr_name = fr_name;
	}

	public String getFr_phonenumber() {
		return fr_phonenumber;
	}

	public void setFr_phonenumber(String fr_phonenumber) {
		this.fr_phonenumber = fr_phonenumber;
	}

	public String getFr_email() {
		return fr_email;
	}

	public void setFr_email(String fr_email) {
		this.fr_email = fr_email;
	}

	public String getFr_address() {
		return fr_address;
	}

	public void setFr_address(String fr_address) {
		this.fr_address = fr_address;
	}

	public Date getFr_regdate() {
		return fr_regdate;
	}

	public void setFr_regdate(Date fr_regdate) {
		this.fr_regdate = fr_regdate;
	}

	public String getFr_u_major() {
		return fr_u_major;
	}

	public void setFr_u_major(String fr_u_major) {
		this.fr_u_major = fr_u_major;
	}

	public String getFr_u_year() {
		return fr_u_year.equals("0") ?"1":fr_u_year;
	}

	public void setFr_u_year(String fr_u_year) {
		this.fr_u_year = fr_u_year;
	}

	public String getFr_c_company() {
		return fr_c_company;
	}

	public void setFr_c_company(String fr_c_company) {
		this.fr_c_company = fr_c_company;
	}
	
	// java.sql.Date -> java.util.Date
	// 날짜 출력을 위한 변환
	public java.util.Date toDate() {		
		return new java.util.Date(fr_regdate.getTime());
	}

	@Override
	public String toString() {
		return "PhoneBookDto [idx=" + idx + ", fr_name=" + fr_name + ", fr_phonenumber=" + fr_phonenumber
				+ ", fr_email=" + fr_email + ", fr_address=" + fr_address + ", fr_regdate=" + toDate()
				+ ", fr_u_major=" + fr_u_major + ", fr_u_year=" + fr_u_year + ", fr_c_company=" + fr_c_company + "]";
	}
	
	

}
