package imi.bst.snomedct;

import java.io.IOException;
import java.util.*;

/**
 * This class provides the set of top level concepts from SNOMED CT that we used to match codes within the patterns.
 * 
 * @version 1.1
 * */
public final class ConceptModelConcepts {

    public static ConceptPattern getMostFrequentPattern(SUBHIERARCHY sh) throws IOException {

        return ConceptModelConcepts.getPatternFrequency(sh, 1).get(0).pattern;

    }

    public static List<PatternFrequency> getPatternFrequency(SUBHIERARCHY sh, int threshold) throws IOException {

        List<PatternFrequency> allPatternFreq = PatternFrequency.fromFile();

        List<PatternFrequency> thisPatternFreq = new ArrayList<PatternFrequency>();

        for (PatternFrequency patternFreq: allPatternFreq) {
            if (patternFreq.pattern.topLevelConcept.equals(sh) &&
                    patternFreq.frequency >= threshold) {
                thisPatternFreq.add(patternFreq);
            }
        }
        return thisPatternFreq;
    }

    public enum SUBHIERARCHY {  BS, CF, EG, EV, OE, OR, PB, PF, PO,
    							PR, QV, RA, SI, SO, SP, SN, ST, SU, SM, AABS, MA, SV, CC, ES, LP, EP, FV, AI, IP, HP, POL, POM, SOR,
    							AT,DV, SAV, PRO, INT,PS,FM,CM,DN,GR,PROP,RV,POMP,ROA,PA,
    							CS,TF,PMS,QT,QL,OV,OVQT,NV,NTV,TV,LPM,PRV,UNT,TQ,
    							LA,FCV,CVA,TCV,SD,TOD, POA, ENV, SMC}

    public static final Map<String,SUBHIERARCHY> SUBHIERARCHY_MAPPINGS;
    static {
    	Map<String, SUBHIERARCHY> theMap = new HashMap<String,SUBHIERARCHY>();
    	theMap.put("123037004",SUBHIERARCHY.BS); 
    	theMap.put("404684003",SUBHIERARCHY.CF); //Clinical Finding
    	theMap.put("308916002", SUBHIERARCHY.EG);
    	theMap.put("272379006", SUBHIERARCHY.EV); //Event
    	theMap.put("363787002", SUBHIERARCHY.OE); //Observable entity
    	theMap.put("410607006", SUBHIERARCHY.OR); //Organism
    	theMap.put("373873005", SUBHIERARCHY.PB); //Pharmaceutical / biologic product
    	theMap.put("78621006", SUBHIERARCHY.PF); //Physical force
    	theMap.put("260787004", SUBHIERARCHY.PO); //Physical object
    	theMap.put("71388002", SUBHIERARCHY.PR); //Procedure
    	theMap.put("362981000",SUBHIERARCHY.QV); //Qualifier value
    	theMap.put("419891008", SUBHIERARCHY.RA); //Record artifact
    	theMap.put("243796009", SUBHIERARCHY.SI); //Situation with explicit context
    	theMap.put("48176007", SUBHIERARCHY.SO); //Social context
    	theMap.put("370115009", SUBHIERARCHY.SP); //Special concept
    	theMap.put("123038009", SUBHIERARCHY.SN); //Specimen
    	theMap.put("254291000", SUBHIERARCHY.ST); //Staging and scales 
    	theMap.put("105590001",SUBHIERARCHY.SU); //Substance
    	theMap.put("138875005",SUBHIERARCHY.SM); //SNOMED CT Concept
    	theMap.put("900000000000441003", SUBHIERARCHY.SMC);//SNOMED CT Model Concept
    	theMap.put("442083009", SUBHIERARCHY.AABS); //Anatomical or acquired body structure 
    	theMap.put("49755003",SUBHIERARCHY.MA); //Morphologically abnormal structure
    	theMap.put("272141005",SUBHIERARCHY.SV); //Severities
    	theMap.put("288524001", SUBHIERARCHY.CC); //Courses
    	theMap.put("288526004", SUBHIERARCHY.ES); //Episodicities
    	theMap.put("108252007", SUBHIERARCHY.LP); //Laboratory procedure
    	theMap.put("386053000", SUBHIERARCHY.EP); //Evaluation procedure
    	theMap.put("260245000", SUBHIERARCHY.FV); // Findings values
    	theMap.put("263680009", SUBHIERARCHY.AI); //Autoimmune
    	theMap.put("441862004", SUBHIERARCHY.IP); //Infectious process
    	theMap.put("472963003", SUBHIERARCHY.HP); //Hypersensitivity process 
    	theMap.put("282032007", SUBHIERARCHY.POL); //Periods of life
    	theMap.put("420158005", SUBHIERARCHY.POM); //Performer of method 
    	theMap.put("419358007", SUBHIERARCHY.SOR); //Subject of record or other provider of history
    	theMap.put("129264002", SUBHIERARCHY.AT); //Action
    	theMap.put("49062001", SUBHIERARCHY.DV); //Device
    	theMap.put("309795001", SUBHIERARCHY.SAV); //Surgical access values
    	theMap.put("272125009", SUBHIERARCHY.PRO); //Priorities
    	theMap.put("363675004", SUBHIERARCHY.INT); //Intents (nature of procedure values) 
    	theMap.put("125676002", SUBHIERARCHY.PS); //Person
    	theMap.put("35359004", SUBHIERARCHY.FM); //Family
    	theMap.put("133928008", SUBHIERARCHY.CM); //Community
    	theMap.put("105455006", SUBHIERARCHY.DN); //Donor for medical or surgical procedure
    	theMap.put("389109008", SUBHIERARCHY.GR); //Group
    	theMap.put("261424001", SUBHIERARCHY.PROP); //Primary operation
    	theMap.put("255231005", SUBHIERARCHY.RV); //Revision - value 
    	theMap.put("257958009", SUBHIERARCHY.POMP); //Part of multistage procedure
    	theMap.put("284009009", SUBHIERARCHY.ROA); //Route of administration value 
    	theMap.put("103379005", SUBHIERARCHY.PA); //Procedural approach 
    	theMap.put("4421005", SUBHIERARCHY.CS); //Cell structure
    	theMap.put("7389001", SUBHIERARCHY.TF); //Time frame
    	theMap.put("118598001", SUBHIERARCHY.PMS); //Property of measurement
    	theMap.put("30766002", SUBHIERARCHY.QT); //Quantitative
    	theMap.put("26716007", SUBHIERARCHY.QL); //Qualitative 
    	theMap.put("117363000", SUBHIERARCHY.OV); //Ordinal value
    	theMap.put("117365007", SUBHIERARCHY.OVQT); //Ordinal or quantitative value
    	theMap.put("117362005", SUBHIERARCHY.NV); //Nominal value
    	theMap.put("117364006", SUBHIERARCHY.NTV); //Narrative value 
    	theMap.put("117444000", SUBHIERARCHY.TV); //Text value
    	theMap.put("127789004", SUBHIERARCHY.LPM); //Laboratory procedure categorized by method 
    	theMap.put("703763000", SUBHIERARCHY.PRV); //Precondition value
    	theMap.put("258666001", SUBHIERARCHY.UNT); //Unit
    	theMap.put("272394005", SUBHIERARCHY.TQ); //Technique
    	theMap.put("416698001", SUBHIERARCHY.LA); //Link assertion
    	theMap.put("410514004", SUBHIERARCHY.FCV); //Finding context value
    	theMap.put("288532009", SUBHIERARCHY.CVA); //Context values for actions
    	theMap.put("410510008", SUBHIERARCHY.TCV); //Temporal context value
    	theMap.put("182353008", SUBHIERARCHY.SD); //Side
    	theMap.put("105904009", SUBHIERARCHY.TOD); //Type of drug preparation
    	theMap.put("415178003", SUBHIERARCHY.POA); //Process (Observable entity)
    	theMap.put("276339004",SUBHIERARCHY.ENV); 
    	SUBHIERARCHY_MAPPINGS = Collections.unmodifiableMap(theMap);
    }
}