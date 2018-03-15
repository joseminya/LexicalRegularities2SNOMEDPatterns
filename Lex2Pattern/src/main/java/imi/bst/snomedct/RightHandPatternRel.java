package imi.bst.snomedct;

import java.util.HashMap;
import java.util.Map;

import imi.bst.snomedct.ConceptModelConcepts.SUBHIERARCHY;
import imi.bst.snomedct.RelationshipConcept.RELATIONSHIP;

import java.util.List;


/**
 * This class represents the right side (relationship+range) of an expanded pattern based on SNOMED CT precoordinated concepts.
 * 
 * @version 1.0
 * */
public class RightHandPatternRel {
	private Map<RELATIONSHIP,List<SUBHIERARCHY>> statedRels;
	private String id;
	public RightHandPatternRel(String id){
		this.id = id;
		statedRels = new HashMap<RELATIONSHIP,List<SUBHIERARCHY>>();
	}
	
	public String getId(){
		return id;
	}
	
	public void addRelObj(RELATIONSHIP rel, List<SUBHIERARCHY> obj){
		statedRels.put(rel, obj);
	}
	
	public Map<RELATIONSHIP, List<SUBHIERARCHY>> getStatedRels(){
		return statedRels;
	}
	
	public String toString(){
		String result = "";
		for(RELATIONSHIP rel: statedRels.keySet()){
			if(!result.isEmpty())result+=",";
			String group = "";
			for(SUBHIERARCHY sub: statedRels.get(rel)){
				if(!group.isEmpty())group+=",";
				group+=sub;
			}
			result+=rel+"-("+group+")";
		}
		return result;
	}
	
	public String getDescription(){
		String result = "";
		for(RELATIONSHIP rel: statedRels.keySet()){
			if(!result.isEmpty())result+=",";
			String relation = "";
			for(String key: RelationshipConcept.RELATIONSHIP_MAPPINGS.keySet()){
				if(RelationshipConcept.RELATIONSHIP_MAPPINGS.get(key).equals(rel)){
					relation = key;
					break;
				}
			}
			result+=relation+"-"+statedRels.get(rel).get(0);
		}
		return result;
	}
}
