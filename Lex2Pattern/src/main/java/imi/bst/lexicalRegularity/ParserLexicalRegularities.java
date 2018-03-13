package imi.bst.lexicalRegularity;

import java.io.File;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParserLexicalRegularities {
	public static List<LexicalRegularity> getLexicalRegularities(String file){
		try {
	        File inputFile = new File(file);
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
	        LexHandler userhandler = new LexHandler();
	        saxParser.parse(inputFile, userhandler);  
	        return userhandler.getListLR();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
}
