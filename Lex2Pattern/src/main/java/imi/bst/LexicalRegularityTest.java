package imi.bst;

import java.util.List;

import imi.bst.lexicalRegularity.LexicalRegularity;
import imi.bst.lexicalRegularity.ParserLexicalRegularities;

public class LexicalRegularityTest {

	public static void main(String[] args) {
		String file = "C:\\Users\\JoseAntonio\\OneDrive\\Documentos\\Universidad de Murcia\\colaboracion_estancia_2018\\trabajo investigacion\\lexicalAnalysis\\snomed2018_CaseSensitivefalse_PerctCov0.1.xml";
		List<LexicalRegularity> listLR = ParserLexicalRegularities.getLexicalRegularities(file);
		int i=0;
		for(LexicalRegularity lr: listLR) {
			System.out.println("lr id->"+lr.getId()+"\tlabel->"+lr.getLabel()+"\tsize="+lr.getAnnotations().size());
			i++;
			if(i>5) break;
		}
	}

}
