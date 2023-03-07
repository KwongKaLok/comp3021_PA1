package hk.ust.comp3021.utils;

import hk.ust.comp3021.resource.Paper;

import java.io.File;
import java.util.*;

public class BibParser {
    private String bibfilePath;
    private boolean isErr;
    private HashMap<String, Paper> result;
    
    public BibParser(String bibfilePath) {
        //TODO: complete the definition of the constructor
    	this.bibfilePath = bibfilePath;
    }


    /**
     * Extract the papers from the content of a bib file.
     * * If any exception throws, please set the field `isErr` to true. Otherwise, `isErr` is false.
     *
     * Please note that the string after @ is exactly the key of the paper.
     * For example:
     * @article{Bourdoncle1993,
     *    abstract = {Abstract interpretation ...},
     *    author = {François Bourdoncle},
     *    isbn = {9783540573166},
     *    issn = {16113349},
     *    journal = {Lecture Notes in Computer Science ...},
     *    pages = {128-141},
     *    title = {Efficient chaotic iteration strategies with widenings},
     *    volume = {735 LNCS},
     *    year = {1993},
     * }
     * The key of the paper should be Bourdoncle1993.
     *
     * Hint: The function might be quite verbose if you just define this method to achieve the functionality.
     *       You can try to define several helper methods to process different kinds of lines in the bib file,
     *       and then invoke them in this method.
     */
    public void parse() {
        //TODO: complete the definition of the method `parse`
        ArrayList<String> AllFileArrayList = new ArrayList<String>();
        String[] searchKeyWordArray = {"doi = {","author = {","title = {","journal = {","keywords = {","year = {","url = {","abstract = {"};
    	try {
    		AllFileArrayList = loadBibFile(bibfilePath);
    		AllFileArrayList.forEach((eachFile)->{
    			if (eachFile.contains("@article{")||eachFile.contains("@inproceedings{")||eachFile.contains("@report{")) {
    				String paperKey = eachFile.substring(eachFile.indexOf("{")+1,eachFile.indexOf(","));
    				Paper eachPaperObj = new Paper(paperKey);
    				StringBuilder stringBuilder = new StringBuilder(eachFile);
    				stringBuilder.delete(eachFile.indexOf("@"),eachFile.indexOf(",")+1); //remove key
    				ArrayList<String> eachFileSegmentList = new ArrayList<String>(Arrays.asList(stringBuilder.toString().split("},"))); //Break each information into a single element
    				eachPaperObj.setDoi(getPaperInfo(eachFileSegmentList,searchKeyWordArray[0]));
    				eachPaperObj.setAuthors(getPaperAuthorsOrKeyword(eachFileSegmentList,searchKeyWordArray[1]));
    				eachPaperObj.setTitle(getPaperInfo(eachFileSegmentList,searchKeyWordArray[2]));
    				eachPaperObj.setJournal(getPaperInfo(eachFileSegmentList,searchKeyWordArray[3]));
    				eachPaperObj.setKeywords(getPaperAuthorsOrKeyword(eachFileSegmentList,searchKeyWordArray[4]));
    				eachPaperObj.setYear(Integer.parseInt(getPaperInfo(eachFileSegmentList,searchKeyWordArray[5]).substring(0,4)));
    				eachPaperObj.setUrl(getPaperInfo(eachFileSegmentList,searchKeyWordArray[6]));
    				eachPaperObj.setAbsContent(getPaperInfo(eachFileSegmentList,searchKeyWordArray[7]));
    				result.put(paperKey, eachPaperObj);
    			}else {isErr = true;}
    		});
    		}
        catch(Exception ex) {
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
    public ArrayList<String> loadBibFile(String bibfilePath)throws Exception {
    	File inputFile = new File(bibfilePath);
        ArrayList<String> fileArrayList = new ArrayList<String>();
    	Scanner sc = new Scanner(inputFile);
    	sc.useDelimiter(",\\n}");  
    	while(sc.hasNext()) {
    		fileArrayList.add(sc.next());    		
    	}
    	sc.close();
    	return fileArrayList;
    }
    public String getPaperInfo(ArrayList<String> eachFileSegmentList,String searchKeyWord){
    	String paperInfo = null;
    	for (int i =0;i<eachFileSegmentList.size();i++) {
    		String eachFileSegment = eachFileSegmentList.get(i);
    		if (eachFileSegment.contains(searchKeyWord)) {
    			paperInfo = eachFileSegment.substring(eachFileSegment.indexOf("{")+1);
    		}
    	}
    	return paperInfo;
    }
    public ArrayList<String>getPaperAuthorsOrKeyword(ArrayList<String> eachFileSegmentList,String searchKeyWord){
    	String paperInfo = null;
    	String[] tempInfoArray = null;
    	ArrayList<String> authorArrayList = new ArrayList<String>();
    	for (int i =0;i<eachFileSegmentList.size();i++) {
    		String eachFileSegment = eachFileSegmentList.get(i);
    		if (eachFileSegment.contains(searchKeyWord)) {
    			paperInfo = eachFileSegment.substring(eachFileSegment.indexOf("{")+1);
    			if (searchKeyWord == "author = {") {
    				tempInfoArray = paperInfo.split("and");
    			}else {
    				tempInfoArray = paperInfo.split(",");
    			}
    			for (String tempAuthor:tempInfoArray) {
    				authorArrayList.add(tempAuthor);
    			}
    		}
    	}
    	return authorArrayList;
    }
}
