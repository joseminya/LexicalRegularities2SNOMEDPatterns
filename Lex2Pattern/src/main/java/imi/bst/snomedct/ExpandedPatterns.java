package imi.bst.snomedct;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import imi.bst.snomedct.ConceptModelConcepts.SUBHIERARCHY;
import imi.bst.snomedct.RelationshipConcept.RELATIONSHIP;


/**
 * This class represents the list of expanded patterns using the SNOMED-CT conceptual model.
 * 
 * @version 1.0
 * */
public class ExpandedPatterns {
	private List<PatternAdquisition> extendedPatterns;
	
	public ExpandedPatterns(List<PatternAdquisition> listPA){
		extendedPatterns = new ArrayList<PatternAdquisition>();
		for(PatternAdquisition pa: listPA){
			List<PatternAdquisition> listExtendedPA = getPatternExtensions(pa);
			for(PatternAdquisition epa: listExtendedPA){
				boolean exists = false;
				for(PatternAdquisition ep: extendedPatterns){
					if(epa.compareTo(ep) == 0){
						exists = true;
						int f = ep.getFrequency();
						f += epa.getFrequency();
						ep.setFrequency(f);
						break;
					}
				}
				if(!exists) extendedPatterns.add(epa);
			}
		}
	}
	
	public List<PatternAdquisition> getExtendedPatterns(){
		return extendedPatterns;
	}
	
	private List<PatternAdquisition> getPatternExtensions(PatternAdquisition pa){
		List<PatternAdquisition> listPA = new ArrayList<PatternAdquisition>();
		List<SUBHIERARCHY> listSub = pa.getSourceCode();
		for(SUBHIERARCHY s_sub: listSub){
			List<SUBHIERARCHY> lssub	= new ArrayList<SUBHIERARCHY>();
			lssub.add(s_sub);
			for(RightHandPatternRel rhpr: pa.getPatternRightHand()){
				List<Map<RELATIONSHIP,SUBHIERARCHY>> lmap = getCombination(rhpr);
				for(Map<RELATIONSHIP,SUBHIERARCHY> map: lmap){
					PatternAdquisition npa = new PatternAdquisition(lssub);
					npa.setFrequency(pa.getFrequency());
					for(RELATIONSHIP rel: map.keySet()){
						List<SUBHIERARCHY> losub = new ArrayList<SUBHIERARCHY>();
						losub.add(map.get(rel));
						npa.addPatternRightHand("0", rel, losub);						
					}
					
					boolean exists = false;
					for(PatternAdquisition epa: listPA){
						if(epa.compareTo(npa) == 0){
							int f = npa.getFrequency();
							f += epa.getFrequency();
							epa.setFrequency(f);
							break;
						}
					}
					if(!exists) listPA.add(npa);
				}
			}
		}
		return listPA;
	}
	
	private List<Map<RELATIONSHIP,SUBHIERARCHY>> getCombination(RightHandPatternRel rhpr){
		List<Map<RELATIONSHIP,SUBHIERARCHY>> indexes = new ArrayList<Map<RELATIONSHIP,SUBHIERARCHY>>();
		Map<RELATIONSHIP,List<SUBHIERARCHY>> map = rhpr.getStatedRels();
		for(RELATIONSHIP rel: map.keySet()){
			List<Map<RELATIONSHIP,SUBHIERARCHY>> partialIndexes = new ArrayList<Map<RELATIONSHIP,SUBHIERARCHY>>();
			for(SUBHIERARCHY o_sub: map.get(rel)){
				List<SUBHIERARCHY> losub = new ArrayList<SUBHIERARCHY>();
				losub.add(o_sub);
				Map<RELATIONSHIP,SUBHIERARCHY> newMap = new HashMap<RELATIONSHIP,SUBHIERARCHY>();	
				newMap.put(rel, o_sub);
				partialIndexes.add(newMap);
			}
			
			if(!indexes.isEmpty()){
				List<Map<RELATIONSHIP,SUBHIERARCHY>> temporalIndexes = new ArrayList<Map<RELATIONSHIP,SUBHIERARCHY>>();
				for(Map<RELATIONSHIP,SUBHIERARCHY> i: indexes){
					for(Map<RELATIONSHIP,SUBHIERARCHY> pi: partialIndexes){
						Map<RELATIONSHIP,SUBHIERARCHY> newMap = new HashMap<RELATIONSHIP,SUBHIERARCHY>();	
						newMap.putAll(i);
						newMap.putAll(pi);
						temporalIndexes.add(newMap);
					}
				}
				indexes = temporalIndexes;
			}else{
				indexes = partialIndexes;
			}
		}
	
		return indexes;
	}
}
