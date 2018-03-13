package imi.bst.lexicalRegularity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LexicalRegularityPattern {
	private Integer freq;
	private String label;
	private Map<String,List<PosTag>> patternMap;
	private List<String> listEntities;
	
	public void setLabel(String label) {
		this.label=label;
		patternMap = new HashMap<String,List<PosTag>>();
		String[] tokens = label.split(" ");
		for(String token: tokens) {
			patternMap.put(token,new ArrayList<PosTag>());
		}
	}
	public String getLabel() {
		return label;
	}
	
	public void setPattern(String postag) {
		String postagger = postag;
		if(patternMap != null) {
			String[] tokens = label.split(" ");
			for(String token: tokens) {
				List<PosTag> listTag = patternMap.get(token);
				String tagger = postagger.substring(postagger.indexOf("{")+1, postagger.indexOf("}")).trim();
				postagger = postagger.substring(postagger.indexOf("}")+1).trim();
				String[] items = tagger.split(" ");
				for(String item: items) {
					String code = item.substring(item.indexOf("(")+1,item.lastIndexOf(","));
					String freq = item.substring(item.lastIndexOf(",")+1,item.lastIndexOf(")"));
					PosTag pt = new PosTag();
					pt.setCode(code);
					pt.setFreq(freq);
					listTag.add(pt);
				}
			}
		}
	}
	public Map<String, List<PosTag>> getPattern(){
		return patternMap;
	}
	
	public void addEntity(String id) {
		if(listEntities==null) {
			listEntities = new ArrayList<String>();
		}
		listEntities.add(id);
	}
	public List<String> getEntities(){
		return listEntities;
	}
	
	public void setFreq(String freq) {
		this.freq = Integer.parseInt(freq);
	}
	public Integer getFreq() {
		return freq;
	}
}
