package entity;

public class YdManager {
	private int id;
	private String yname;
	private String gender;
	private String psd;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getYname() {
		return yname;
	}
	public void setYname(String yname) {
		this.yname = yname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	@Override
	public String toString() {
		return "YdManager [id=" + id + ", yname=" + yname + ", gender=" + gender + ", psd=" + psd + "]";
	}
	

}
