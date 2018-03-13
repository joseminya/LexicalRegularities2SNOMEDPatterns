package imi.bst;

import java.util.List;

import imi.bst.lexicalRegularity.LexicalRegularity;
import imi.bst.lexicalRegularity.ParserLexicalRegularities;
public class LexicalRegularityTest {

	public static void main(String[] args) {
		String file = "C:\\Users\\JoseAntonio\\OneDrive\\Documentos\\Universidad de Murcia\\colaboracion_estancia_2018\\trabajo investigacion\\lexicalAnalysis\\snomed2018_CaseSensitivefalse_PerctCov0.1.xml";
		List<LexicalRegularity> listLR = ParserLexicalRegularities.getLexicalRegularities(file);
		int i=0;
		if(listLR.isEmpty()) System.out.println("listLR is empty");
		else System.out.println("listLR size="+listLR.size());
		for(LexicalRegularity lr: listLR) {
			if(lr==null) {
				System.out.println("lr is null");
				break;
			}
			if(lr.getId()==null) {
				System.out.println("id is null");
				break;
			}
			if(lr.getLabel()==null) {
				System.out.println("label is null");
				break;
			}
			if(lr.getAnnotations()==null) {
				System.out.println("annotations is null");
				break;
			}
			System.out.println("lr id->"+lr.getId()+"\tlabel->"+lr.getLabel()+"\tsize="+lr.getAnnotations().size());
			i++;
			if(i>5) break;
		}
	}

}
