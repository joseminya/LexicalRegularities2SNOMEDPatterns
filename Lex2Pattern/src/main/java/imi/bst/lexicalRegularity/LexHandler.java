package imi.bst.lexicalRegularity;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LexHandler extends DefaultHandler{
	LexicalRegularity lr = null;
	List<LexicalRegularity> listLR = new ArrayList<LexicalRegularity>();
	boolean labels = false;
	
	public List<LexicalRegularity> getListLR(){
		return listLR;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (qName.equalsIgnoreCase("labels")) {
			labels=true;
		} else if (qName.equalsIgnoreCase("entity")) {
			if(labels) {
				String entityId = attributes.getValue("uri");
				entityId = entityId.substring(entityId.indexOf("id/")+3);
				String label = attributes.getValue("label");
				lr = new LexicalRegularity();
				lr.setId(entityId);
				lr.setLabel(label);
			}
		} else if (qName.equalsIgnoreCase("annotations")) {
			String lemma = attributes.getValue("lemma");
			if(lemma!=null) {
				Annotation annotation = new Annotation(lr);
				annotation.setLemma(lemma);
				String type = attributes.getValue("xsi:type");
				annotation.setType(type);
				String tag = attributes.getValue("tag");
				annotation.setTag(tag);
				String begin = attributes.getValue("beginPosition");
				annotation.setBegin(begin);
				String end = attributes.getValue("endPosition");
				annotation.setEnd(end);
				lr.addAnnotation(annotation);
			}
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (qName.equalsIgnoreCase("entity")) {
			if(labels) listLR.add(lr);	
		}
		if (qName.equalsIgnoreCase("labels")) {
			labels=false;
		}
	}
}
