package imi.bst;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

import imi.bst.lexicalRegularity.LexicalRegularityPattern;
import imi.bst.lexicalRegularity.ParserLexicalRegularities;
import imi.bst.snomedct.ParseSCTStatedRels;
import imi.bst.snomedct.StatedRelationship;

public class Main_mapLexPattern2SctPattern {
	public static final String StatedRelationshipsSCT	= "src/resources/sct2_StatedRelationship_Snapshot_INT_20180131.txt";
	public static final String mappingLexPat2SctPat		= "src/resources/mappingPatterns.txt"; 
	public static final String lexicalRegularities		= "src/resources/snomed2018_CaseSensitivefalse_PerctCov0.1.xml";
	
	public static void main(String[] args) {
		ParseSCTStatedRels psctsr = new ParseSCTStatedRels(StatedRelationshipsSCT);
		List<StatedRelationship> listSR = psctsr.getListStatedRelationships();
		ParserLexicalRegularities plr = new ParserLexicalRegularities(lexicalRegularities); 
		List<LexicalRegularityPattern> listLRP = plr.getLexicalRegularityPatterns();
		System.out.println("Size lex pattern = "+listLRP.size());
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(mappingLexPat2SctPat));
			for(LexicalRegularityPattern lrp: listLRP) {
				bw.write(lrp.getLabel()+"\n");
				for(String code: lrp.getEntities()) {
					for(StatedRelationship sr: listSR) {
						if(sr.getSourceCode().equals(code)) {
							bw.write("\t"+sr.toString()+"\n");
							break;
						}
					}
				}
			}
			bw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
