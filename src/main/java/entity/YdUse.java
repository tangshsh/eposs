package entity;

public class YdUse {
	private Integer id;
	private String psd;
	private String state;
	private int d_num;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPsd() {
		return psd;
	}
	public void setPsd(String psd) {
		this.psd = psd;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getD_num() {
		return d_num;
	}
	public void setD_num(int d_num) {
		this.d_num = d_num;
	}
	@Override
	public String toString() {
		return "YdUse [id=" + id + ", psd=" + psd + ", state=" + state + ", d_num=" + d_num + "]";
	}
	
	

}
