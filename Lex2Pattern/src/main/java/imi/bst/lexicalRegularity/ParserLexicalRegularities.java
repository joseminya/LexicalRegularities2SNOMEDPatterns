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
	public static List<LexicalRegularity> getLexicalRegularities(String file){
		try {
	        File inputFile = new File(file);
	        InputStream inputStream= new FileInputStream(inputFile);
	        Reader reader = new InputStreamReader(inputStream,"UTF-8");
	        InputSource is = new InputSource(reader);
	        SAXParserFactory factory = SAXParserFactory.newInstance();
	        SAXParser saxParser = factory.newSAXParser();
	        LexHandler userhandler = new LexHandler();
	        saxParser.parse(is, userhandler);  
	        return userhandler.getListLR();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
	}
}
