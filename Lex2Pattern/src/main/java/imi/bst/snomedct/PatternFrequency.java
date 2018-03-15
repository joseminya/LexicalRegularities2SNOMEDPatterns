package imi.bst.snomedct;


import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the frequency of the pattern in the precoordinated expressions of SNOMED CT.
 * 
 * @version 1.1
 * 
 * */

public class PatternFrequency implements Comparable<PatternFrequency>{

    //public static final String PATTERNS_FILE = "src/main/resources/data/pattern-extended-frequencies.csv";
	public static final String PATTERNS_FILE = "src/resources/new-extended-pattern-frequencies.txt";
    public ConceptPattern pattern;
    public int frequency;

    public PatternFrequency(ConceptPattern pattern, int frequency){
        this.pattern = pattern;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Freq: " + frequency + " - ConceptPattern: " + pattern.toString();
    }

    public static List<PatternFrequency> fromFile() throws IOException {

        List<PatternFrequency> patternFrequencies = new ArrayList<PatternFrequency>();

        CSVReader reader = new CSVReader(new FileReader(PATTERNS_FILE), '\t');
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {

            int frequency = new Integer(nextLine[0]);

            ConceptPattern conceptPattern = ConceptPattern.fromString(nextLine[1]);

            if (!conceptPattern.patternRightHands.isEmpty())
                patternFrequencies.add(new PatternFrequency(conceptPattern, frequency));
        }
        reader.close();
        
        // File is already sorted, but make sure just in case implementation is changed
        Collections.sort(patternFrequencies, Collections.<PatternFrequency>reverseOrder());

        return patternFrequencies;
    }

    public int compareTo(PatternFrequency other){
        return Integer.compare(this.frequency, other.frequency);
    }
    
    @Override
    public boolean equals(Object o){
    	if (!(o instanceof PatternFrequency))
            return false;
        if (o == this)
            return true;
        
        PatternFrequency pf = (PatternFrequency) o;
        
    	if(this.frequency==pf.frequency){
    		return pattern.equals(pf.pattern);
    	}
    	
    	return false;
    }
    
}
