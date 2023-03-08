package hk.ust.comp3021.utils;

import hk.ust.comp3021.resource.Paper;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class BibExporter {
    private HashMap<String, Paper> papers; //contain the target paper need to download

    private String bibFile;

    private boolean isErr;

    public BibExporter(HashMap<String, Paper> papers, String bibFile) {
        //TODO: complete the definition of the constructor
    	this.papers = papers;
    	this.bibFile = bibFile;
    }


    /**
     * Return a string object which is the tokenized string of the field `papers`.
     * Hint: You may need to utilize the method `toString` of the class `Paper`
     * You may need to remove the `return null` in the skeleton.
     */

    public String generate(){
        //TODO: complete the definition of the method `export`
        String tokenizedString = new String();
        if(!papers.isEmpty()) {
        	for(Map.Entry<String, Paper>paper:papers.entrySet()) {
        		tokenizedString = tokenizedString + paper.getValue().toString();
        	}
        	return tokenizedString;
        }
        return null;
    }


    /**
     * Export the content of the paper to a bib file, of which the full name is bibFile.
     * If any exception throws, please set the field `isErr` to true. Otherwise, `isErr` is false.
     * Hint: You may need to utilize the method `generate` to get the tokenized string of the field `papers`.
     */
    public void export() {
        //TODO: complete the definition of the method `export`
    	String tokenizedString;
    	try {
    		tokenizedString = generate();
    		File file = new File(this.bibFile);
			PrintWriter writer = new PrintWriter(file);
			writer.print(tokenizedString);
			writer.close();
    	}catch(Exception ex) {
        	isErr = true;
        }  
    }


    /**
     * Attention: You may need to define more methods to update or access the field of the class `User`
     * Feel free to define more method but remember not
     * (1) removing the fields or methods in our skeleton.
     * (2) changing the type signature of `public` methods
     * (3) changing the modifiers of the fields and methods, e.g., changing a modifier from "private" to "public"
     */
    public void yourMethod() {
    }
}
