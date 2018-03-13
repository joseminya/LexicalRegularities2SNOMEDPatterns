package imi.bst.lexicalRegularity;

public class PosTag {
	private String code;
	private Integer freq;
	
	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return code;
	}
	
	public void setFreq(String freq) {
		this.freq = Integer.parseInt(freq);
	}
	public Integer getFreq() {
		return freq;
	}
}
