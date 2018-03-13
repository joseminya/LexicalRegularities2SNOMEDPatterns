package imi.bst.lexicalRegularity;

public class Annotation {
	private LexicalRegularity reg;
	private String type;
	private String lemma;
	private String tag;
	private Integer begin;
	private Integer end;
	
	public Annotation(LexicalRegularity reg) {
		this.reg = reg;
	}
	public String getLabel() {
		return reg.getLabel();
	}
		
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type=type;
	}
	
	public String getLemma() {
		return lemma;
	}
	public void setLemma(String lemma) {
		this.lemma = lemma;
	}
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(String begin) {
		try {
			this.begin = Integer.parseInt(begin);
		}catch(NumberFormatException nfe) {
			if(this.end!=null) {
				this.begin = end;
			}else {
				this.begin = 0;
			}
		}
	}
	
	public Integer getEnd() {
		return end;
	}
	public void setEnd(String end) {
		try {
			this.end = Integer.parseInt(end);
		}catch(NumberFormatException nfe) {
			if(this.begin!=null) {
				this.end = this.begin;
			}else {
				this.end = 0;
			}
		}
	}
}
