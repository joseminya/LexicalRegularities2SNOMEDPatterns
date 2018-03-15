package imi.bst.snomedct;

import java.util.ArrayList;
import java.util.List;

import imi.bst.snomedct.ConceptModelConcepts.SUBHIERARCHY;
import imi.bst.snomedct.RelationshipConcept.RELATIONSHIP;


/**
 * This class represents the list patterns acquired from the stated relationships of SNOMED CT.
 * 
 * @version 1.0
 * */
public class PatternAdquisition implements Comparable<PatternAdquisition>{
	private List<SUBHIERARCHY> sourceCode;
	private int frequency;
	private List<RightHandPatternRel> patternRightHand;
	
	public PatternAdquisition(List<SUBHIERARCHY> sourceCode){
		this.sourceCode = sourceCode;
		frequency = 1;
		patternRightHand = new ArrayList<RightHandPatternRel>();
	}
	
	public void addPatternRightHand(String groupId, RELATIONSHIP relationship, List<SUBHIERARCHY> object){
		boolean exists = false;
		for(RightHandPatternRel rhpr: patternRightHand){
			if(rhpr.getId().equals(groupId)){
				rhpr.addRelObj(relationship, object);
				exists = true;
				break;
			}
		}
		if(!exists){
			RightHandPatternRel rhpr = new RightHandPatternRel(groupId);
			rhpr.addRelObj(relationship, object);
			patternRightHand.add(rhpr);
		}
	}
	
	public void incrementFrequency(){
		frequency++;
	}
			
	public int compareTo(PatternAdquisition pa) {
		
		if(pa.getSourceCode().size() != sourceCode.size()) return (pa.getSourceCode().size() - sourceCode.size());
		
		for(SUBHIERARCHY sub: pa.getSourceCode()){
			if(!sourceCode.contains(sub)) return -1;
		}
		if(pa.getPatternRightHand().size() != patternRightHand.size()) return (pa.getPatternRightHand().size() - patternRightHand.size());
		
		for(RightHandPatternRel rhpr1: pa.getPatternRightHand()){
			boolean exists = false;
			for(RightHandPatternRel rhpr2: patternRightHand){
				if(rhpr1.getStatedRels().size() != rhpr2.getStatedRels().size()) continue;
				boolean containsSR = true;
				for(RELATIONSHIP rel1: rhpr1.getStatedRels().keySet()){
					if(!rhpr2.getStatedRels().containsKey(rel1)){
						containsSR = false;
						break;
					}
					boolean containTarget = true;
					for(SUBHIERARCHY subRel1: rhpr1.getStatedRels().get(rel1)){
						if(!rhpr2.getStatedRels().get(rel1).contains(subRel1)){
							containTarget = false;
							break;
						}
					}
					if(!containTarget){
						containsSR = false;
						break;
					}
				}
				if(containsSR){
					exists = true;
					break;
				}
			}
			if(!exists) return -1;
		}
		
		return 0;
		
		
		/*
		if(pa.getSourceCode().equals(sourceCode) && (pa.getPatternRightHand().size() == patternRightHand.size())){
			boolean equals = true;
			for(RELATIONSHIP rel: pa.getPatternRightHand().keySet()){
				if(!patternRightHand.containsKey(rel)){
					equals = false;
					break;
				}
				if(!pa.getPatternRightHand().get(rel).equals(patternRightHand.get(rel))){
					equals = false;
					break;
				}
			}
			if(equals) return 0;
		}
		return pa.getSourceCode().hashCode()-sourceCode.hashCode();*/
	}

	public List<SUBHIERARCHY> getSourceCode(){
		return sourceCode;
	}

	public List<RightHandPatternRel> getPatternRightHand(){
		return patternRightHand;
	}
	
	public int getFrequency(){
		return frequency;
	}
	
	public void setFrequency(int frequency){
		this.frequency = frequency;
	}
	
	public String toString(){
		String result = frequency+"\t[";
		String group = "";
		for(SUBHIERARCHY sub: sourceCode){
			if(!group.isEmpty()) group+=",";
			group+=sub;
		}
		result+="116680003-("+group+"),";
		group = "";
		for(RightHandPatternRel rhpr: patternRightHand){
			if(!group.isEmpty()) group+=",";
			group+="{"+rhpr.toString()+"}";
		}
		result+=group;
		result+="]";
		return result;
	}
	
	public String getDescription(){
		String result = frequency+"\t[116680003-"+sourceCode.get(0)+","+patternRightHand.get(0).getDescription()+"]";
		return result;
	}
}
