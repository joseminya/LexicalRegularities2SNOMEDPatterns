package imi.bst.snomedct;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import imi.bst.snomedct.ConceptModelConcepts.SUBHIERARCHY;


/**
 * This class parses the file which contains the list of annotation groups of the reference standard.
 * 
 * @version 1.0
 * */
public class SCTFinding {
	public static final String TERMINOLOGY_FILE = "src/resources/SNOMED_ID_Ancestor2.txt";
	private static SCTFinding singleton;
	private HashMap<String, List<String>> map;
	
	public static SCTFinding getInstance(){
		if(singleton==null){
			singleton = new SCTFinding();
		}
		return singleton;
	}
	
	public SCTFinding(){
		map = new HashMap<String, List<String>>();
		try{
			BufferedReader br = new BufferedReader(new FileReader(TERMINOLOGY_FILE));
			String line = "";
			while((line = br.readLine()) != null){
				String[] tokens = line.split("\t");
				ArrayList<String> listParents = new ArrayList<String>();
				for(int i=1;i<tokens.length;i++){
					listParents.add(tokens[i].trim());
				}
				map.put(tokens[0].trim(), listParents);
			}
			br.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public List<SUBHIERARCHY> getAncestors(String sctid){
		ArrayList<SUBHIERARCHY>	values = new ArrayList<SUBHIERARCHY>();
		List<String> listParents = map.get(sctid);
		if(listParents!=null){
			for(String parent: listParents){
				values.add(ConceptModelConcepts.SUBHIERARCHY_MAPPINGS.get(parent));
			}
		}
		return values;
	}
	
}
