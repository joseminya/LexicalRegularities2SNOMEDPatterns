package imi.bst.lexicalRegularity;

import java.util.ArrayList;
import java.util.List;

public class LexicalRegularity {
	private String entityId;
	private String label;
	private List<Annotation> listAnnotations;
	
	public String getId() {
		return entityId;
	}
	public void setId(String entityId) {
		this.entityId = entityId;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	public List<Annotation> getAnnotations(){
		return listAnnotations;
	}
	public void addAnnotation(Annotation annotation) {
		if(listAnnotations==null) {
			listAnnotations = new ArrayList<Annotation>();
		}
		listAnnotations.add(annotation);
	}
	public void setAnnotations(List<Annotation> listAnnotations) {
		this.listAnnotations = listAnnotations;
	}
}
