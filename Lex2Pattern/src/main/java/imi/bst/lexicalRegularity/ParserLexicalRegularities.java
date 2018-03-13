package imi.bst.lexicalRegularity;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

public class ParserLexicalRegularities {
	private LexHandler userhandler = new LexHandler();
	public ParserLexicalRegularities(String file) {
		try {
	        File inputFile = new File(file);
	        InputStream inputStream= new FileInputStream(inputFile);
	        Reader reader = new InputStreamReader(inputStream,"UTF-8");
	        InputSource is = new InputSource(reader);
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
	        saxParser.parse(is, userhandler);  
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	public List<LexicalRegularity> getLexicalRegularities(){
		return userhandler.getListLR();
	}
	public List<LexicalRegularityPattern> getLexicalRegularityPatterns(){
		return userhandler.getListLRP();
	}
}
