package imi.bst.snomedct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class represents a postcoordination pattern
 * 
 * @version 1.1 
 * 
 * */
public class ConceptPattern {

    public ConceptModelConcepts.SUBHIERARCHY topLevelConcept;

    public List<PatternRightHand> patternRightHands;

    public ConceptPattern(ConceptModelConcepts.SUBHIERARCHY topLevelConcept, List<PatternRightHand> patternRightHands) {
        this.topLevelConcept = topLevelConcept;
        Collections.sort(patternRightHands);
        this.patternRightHands = patternRightHands;
    }

    public static ConceptPattern fromString(String fullString) throws IOException {

        String IS_A = "116680003";

        String rightHandPattern = "(\\d+)-([a-zA-Z]+)";

        Pattern r = Pattern.compile(rightHandPattern);
        
        Matcher m = r.matcher(fullString);

        List<PatternRightHand> prhs = new ArrayList<PatternRightHand>();

        // FIXME: 01/07/16
        ConceptModelConcepts.SUBHIERARCHY currentTopLevelSH = null;
        while (m.find()) {
            String relationship = m.group(1);
            ConceptModelConcepts.SUBHIERARCHY range = ConceptModelConcepts.SUBHIERARCHY.valueOf(m.group(2));

            //IS-A triple should not be added, but determines which SH we are talking about
            if (relationship.equals(IS_A)) {
            	currentTopLevelSH = range;
            } else {
                prhs.add(new PatternRightHand(relationship, range));
            }
        }

        return new ConceptPattern(currentTopLevelSH, prhs);
    }

    @Override
    public boolean equals(Object o){
    	if (!(o instanceof ConceptPattern))
            return false;
        if (o == this)
            return true;
    	
    	ConceptPattern cp = (ConceptPattern)o;
    	if(topLevelConcept.equals(cp.topLevelConcept)){
    		if(patternRightHands.size() == cp.patternRightHands.size()){
    			for(PatternRightHand prh: patternRightHands){
    				if(!cp.patternRightHands.contains(prh)) return false;
    			}
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    
    @Override
    public String toString() {
        return topLevelConcept + "->" + patternRightHands;
    }

}
