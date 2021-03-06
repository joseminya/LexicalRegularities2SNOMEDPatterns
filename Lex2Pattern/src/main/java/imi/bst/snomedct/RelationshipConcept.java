package imi.bst.snomedct;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * This class associates the name of a relationship with its corresponding code in SNOMED CT.
 * 
 * @version 1.0
 * */
public class RelationshipConcept {
	
	public List<PatternRightHand> relationshipRange;
	
	public String relationshipConcept;
	public List<String> ranges;
	
	
	public RelationshipConcept(String relationshipConcept,List<String> ranges){
		this.relationshipConcept = relationshipConcept;
		this.ranges = ranges;
	}
			
	public enum RELATIONSHIP {  FINDING_SITE, ASSOCIATED_MORPHOLOGY, ASSOCIATED_WITH,CAUSATIVE_AGENT,DUE_TO,AFTER,SEVERITY,CLINICAL_COURSE,
		EPISODICITY, INTERPRETS, HAS_INTERPRETATION,PATHOLOGICAL_PROCESS,HAS_DEFINITIONAL_MANIFESTATION,OCCURRENCE, FINDING_METHOD, FINDING_INFORMER, PROCEDURE_SITE,
		PROCEDURE_SITE_DIRECT,PROCEDURE_SITE_INDIRECT,PROCEDURE_MORPHOLOGY, DIRECT_MORPHOLOGY, INDIRECT_MORPHOLOGY, METHOD, PROCEDURE_DEVICE, DIRECT_DEVICE,
		INDIRECT_DEVICE,USING_DEVICE,USING_ACCESS_DEVICE,ACCESS,DIRECT_SUBSTANCE,PRIORITY, HAS_FOCUS, HAS_INTENT, RECIPIENT_CATEGORY,REVISION_STATUS,
		ROUTE_OF_ADMINISTRATION, SURGICAL_APPROACH, USING_ENERGY, USING_SUBSTANCE, HAS_SPECIMEN,COMPONENT, TIME_ASPECT,PROPERTY, SCALE_TYPE,
		MEASUREMENT_METHOD, PROPERTY_TYPE, INHERES_IN, CHARACTERIZES,PROCESS_AGENT,PROCESS_DURATION,PROCESS_OUTPUT,
		TOWARDS, RELATIVE_TO,UNITS,TECHNIQUE, DIRECT_SITE, ASSOCIATED_FINDING, FINDING_CONTEXT, ASSOCIATED_PROCEDURE, PROCEDURE_CONTEXT,
		TEMPORAL_CONTEXT, SUBJECT_RELATIONSHIP_CONTEXT,LATERALITY,HAS_ACTIVE_INGREDIENT,HAS_DOSE_FORM,SPECIMEN_PROCEDURE,SPECIMEN_SOURCE_MORPHOLOGY,
		SPECIMEN_SOURCE_TOPOGRAPHY,SPECIMEN_SUBSTANCE,SPECIMEN_SOURCE_IDENTITY, PRECONDITION
	}
	
	
	//70 Relationships (some of the existing in the editorial guide are not still in the SCT release (e.g. inherent_location, etc))
	public static final Map<String,RELATIONSHIP> RELATIONSHIP_MAPPINGS;
    static {
    	Map<String, RELATIONSHIP> theMap = new HashMap<String,RELATIONSHIP>();
    	theMap.put("363698007",RELATIONSHIP.FINDING_SITE);
    	theMap.put("116676008", RELATIONSHIP.ASSOCIATED_MORPHOLOGY);
    	theMap.put("47429007", RELATIONSHIP.ASSOCIATED_WITH);
    	theMap.put("246075003", RELATIONSHIP.CAUSATIVE_AGENT);
    	theMap.put("42752001", RELATIONSHIP.DUE_TO);
    	theMap.put("255234002", RELATIONSHIP.AFTER);
    	theMap.put("246112005", RELATIONSHIP.SEVERITY);
    	theMap.put("263502005",RELATIONSHIP.CLINICAL_COURSE);
    	theMap.put("246456000", RELATIONSHIP.EPISODICITY);
    	theMap.put("363714003", RELATIONSHIP.INTERPRETS);
    	theMap.put("363713009", RELATIONSHIP.HAS_INTERPRETATION);
    	theMap.put("370135005", RELATIONSHIP.PATHOLOGICAL_PROCESS);
    	theMap.put("363705008", RELATIONSHIP.HAS_DEFINITIONAL_MANIFESTATION);
    	theMap.put("246454002", RELATIONSHIP.OCCURRENCE);
    	theMap.put("418775008", RELATIONSHIP.FINDING_METHOD);
    	theMap.put("419066007", RELATIONSHIP.FINDING_INFORMER);
    	theMap.put("363704007", RELATIONSHIP.PROCEDURE_SITE);
    	theMap.put("405813007", RELATIONSHIP.PROCEDURE_SITE_DIRECT);
    	theMap.put("405814001", RELATIONSHIP.PROCEDURE_SITE_INDIRECT);
    	theMap.put("405816004", RELATIONSHIP.PROCEDURE_MORPHOLOGY);
    	theMap.put("363700003", RELATIONSHIP.DIRECT_MORPHOLOGY);
    	theMap.put("363709002", RELATIONSHIP.INDIRECT_MORPHOLOGY);
    	theMap.put("260686004", RELATIONSHIP.METHOD);
    	theMap.put("405815000", RELATIONSHIP.PROCEDURE_DEVICE);
    	theMap.put("363699004", RELATIONSHIP.DIRECT_DEVICE);
    	theMap.put("363710007", RELATIONSHIP.INDIRECT_DEVICE);
    	theMap.put("424226004", RELATIONSHIP.USING_DEVICE);
    	theMap.put("425391005", RELATIONSHIP.USING_ACCESS_DEVICE);
    	theMap.put("260507000", RELATIONSHIP.ACCESS);
    	theMap.put("363701004", RELATIONSHIP.DIRECT_SUBSTANCE);
    	theMap.put("260870009", RELATIONSHIP.PRIORITY);
    	theMap.put("363702006", RELATIONSHIP.HAS_FOCUS);
    	theMap.put("363703001", RELATIONSHIP.HAS_INTENT);
    	theMap.put("370131001", RELATIONSHIP.RECIPIENT_CATEGORY);
    	theMap.put("246513007", RELATIONSHIP.REVISION_STATUS);
    	theMap.put("410675002", RELATIONSHIP.ROUTE_OF_ADMINISTRATION);
    	theMap.put("424876005", RELATIONSHIP.SURGICAL_APPROACH);
    	theMap.put("424244007", RELATIONSHIP.USING_ENERGY);
    	theMap.put("424361007", RELATIONSHIP.USING_SUBSTANCE);
    	theMap.put("116686009", RELATIONSHIP.HAS_SPECIMEN);
    	theMap.put("246093002", RELATIONSHIP.COMPONENT);
    	theMap.put("370134009", RELATIONSHIP.TIME_ASPECT);
    	theMap.put("370130000", RELATIONSHIP.PROPERTY);
    	theMap.put("370132008", RELATIONSHIP.SCALE_TYPE);
    	theMap.put("370129005", RELATIONSHIP.MEASUREMENT_METHOD);
    	theMap.put("704318007", RELATIONSHIP.PROPERTY_TYPE);
    	theMap.put("704319004", RELATIONSHIP.INHERES_IN);
    	theMap.put("704321009", RELATIONSHIP.CHARACTERIZES);
    	theMap.put("704322002", RELATIONSHIP.PROCESS_AGENT);
    	theMap.put("704323007", RELATIONSHIP.PROCESS_DURATION);
    	theMap.put("704324001", RELATIONSHIP.PROCESS_OUTPUT);
    	theMap.put("704320005", RELATIONSHIP.TOWARDS);
    	theMap.put("704325000", RELATIONSHIP.RELATIVE_TO);
    	theMap.put("246514001", RELATIONSHIP.UNITS);
    	theMap.put("246501002", RELATIONSHIP.TECHNIQUE);
    	theMap.put("704327008", RELATIONSHIP.DIRECT_SITE);
    	theMap.put("246090004", RELATIONSHIP.ASSOCIATED_FINDING);
    	theMap.put("408729009", RELATIONSHIP.FINDING_CONTEXT);
    	theMap.put("363589002", RELATIONSHIP.ASSOCIATED_PROCEDURE);
    	theMap.put("408730004", RELATIONSHIP.PROCEDURE_CONTEXT);
    	theMap.put("408731000", RELATIONSHIP.TEMPORAL_CONTEXT);
    	theMap.put("408732007", RELATIONSHIP.SUBJECT_RELATIONSHIP_CONTEXT);
    	theMap.put("272741003", RELATIONSHIP.LATERALITY);
    	theMap.put("127489000", RELATIONSHIP.HAS_ACTIVE_INGREDIENT);
    	theMap.put("411116001", RELATIONSHIP.HAS_DOSE_FORM);
    	theMap.put("118171006", RELATIONSHIP.SPECIMEN_PROCEDURE);
    	theMap.put("118168003", RELATIONSHIP.SPECIMEN_SOURCE_MORPHOLOGY);
    	theMap.put("118169006", RELATIONSHIP.SPECIMEN_SOURCE_TOPOGRAPHY);
    	theMap.put("370133003", RELATIONSHIP.SPECIMEN_SUBSTANCE);
    	theMap.put("118170007", RELATIONSHIP.SPECIMEN_SOURCE_IDENTITY);
    	theMap.put("704326004", RELATIONSHIP.PRECONDITION);
    	RELATIONSHIP_MAPPINGS = Collections.unmodifiableMap(theMap);
    }

    public static String [] fromString(String fullString) throws IOException {
    	String temporal = fullString.substring(fullString.indexOf("[")+1, fullString.indexOf("]"));
    	String [] ranges = temporal.split(",");
    	return ranges;
    }
    
    public static String getCode(RELATIONSHIP rel){
    	for(String code: RELATIONSHIP_MAPPINGS.keySet()){
    		if(RELATIONSHIP_MAPPINGS.get(code).equals(rel)){
    			return code;
    		}
    	}
    	return "";
    }
    
}
