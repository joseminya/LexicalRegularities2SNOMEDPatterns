package imi.bst.snomedct;

import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the right side (relationship+range) of a pattern based on SNOMED CT precoordinated concepts.
 * 
 * @version 1.0
 * */
public class RightHandStatedRel {
	private Map<String,String> statedRels;
	private String id;
	public RightHandStatedRel(String id){
		this.id = id;
		statedRels = new HashMap<String,String>();
	}
	
	public String getId(){
		return id;
	}
	
	public void addRelObj(String rel, String obj){
		statedRels.put(rel, obj);
	}
	
	public Map<String,String> getStatedRels(){
		return statedRels;
	}
	
	public String toString(){
		String result = "";
		for(String rel: statedRels.keySet()){
			if(!result.isEmpty())result+=",";
			result+=rel+"-"+statedRels.get(rel);
		}
		return result;
	}
}
