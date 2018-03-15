package imi.bst.snomedct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class parses the stated relationships defined in SNOMED CT for precoordination of concepts.
 * 
 * @version 1.0
 * */
public class ParseSCTStatedRels {
	List<StatedRelationship> fullListSR;
	
	public ParseSCTStatedRels(String file){
		fullListSR = new ArrayList<StatedRelationship>();
		try{
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(file));
			br.readLine();//header of the file
			StatedRelationship currentStatedRel = null;
			while((line=br.readLine())!=null){
				String[] tokens = line.split("\t");
				String isActive = tokens[2];
				String subject	= tokens[4];
				String object	= tokens[5];
				String groupId	= tokens[6];
				String rel		= tokens[7];
				
				if(rel.equals("116680003"))continue;
				if(isActive.equals("0")) continue;
				
				if(currentStatedRel == null){
					currentStatedRel = new StatedRelationship(subject);
					fullListSR.add(currentStatedRel);
				}else{
					if(!currentStatedRel.getSourceCode().equals(subject)){
						boolean exists = false;
						for(StatedRelationship sr: fullListSR){
							if(sr.getSourceCode().equals(subject)){
								currentStatedRel = sr;
								exists = true;
								break;
							}
						}
						if(!exists){
							currentStatedRel = new StatedRelationship(subject);
							fullListSR.add(currentStatedRel);
						}
					}
				}
				currentStatedRel.addRelObj(groupId, rel, object);
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
		
	public List<StatedRelationship> getListStatedRelationships(){
		return fullListSR;
	}
}
