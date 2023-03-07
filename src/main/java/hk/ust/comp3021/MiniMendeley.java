package hk.ust.comp3021;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

import hk.ust.comp3021.resource.Paper;



public class MiniMendeley {
	
    public static void main(String[] args) {
    	boolean isErr;
    	HashMap<String, Paper> result1 = new HashMap<String, Paper>();
        System.out.println("Begin to start MiniMendeley...");
        ArrayList<String> allFileArrayList = new ArrayList<String>();
        String[] searchKeyWordArray = {"doi = {","author = {","title = {","journal = {","keywords = {","year = {","url = {","abstract = {"};
        
    	try {
    		allFileArrayList = loadBibFile("resources/bibdata/PAData.bib");
    		allFileArrayList.forEach((eachFile)->{
    			if (eachFile.contains("@article{")||eachFile.contains("@inproceedings{")||eachFile.contains("@report{")) {
    				String paperKey = eachFile.substring(eachFile.indexOf("{")+1,eachFile.indexOf(","));
    				Paper eachPaperObj = new Paper(paperKey);
    				StringBuilder stringBuilder = new StringBuilder(eachFile);
    				stringBuilder.delete(eachFile.indexOf("@"),eachFile.indexOf(",")+1); //remove key
    				ArrayList<String> eachFileSegmentList = new ArrayList<String>(Arrays.asList(stringBuilder.toString().split("},")));
    				eachPaperObj.setDoi(getPaperInfo(eachFileSegmentList,searchKeyWordArray[0]));
    				eachPaperObj.setAuthors(getPaperAuthorsOrKeyword(eachFileSegmentList,searchKeyWordArray[1]));
    				eachPaperObj.setTitle(getPaperInfo(eachFileSegmentList,searchKeyWordArray[2]));
    				eachPaperObj.setJournal(getPaperInfo(eachFileSegmentList,searchKeyWordArray[3]));
    				eachPaperObj.setKeywords(getPaperAuthorsOrKeyword(eachFileSegmentList,searchKeyWordArray[4]));
    				eachPaperObj.setYear(Integer.parseInt(getPaperInfo(eachFileSegmentList,searchKeyWordArray[5]).substring(0,4)));
    				eachPaperObj.setUrl(getPaperInfo(eachFileSegmentList,searchKeyWordArray[6]));
    				eachPaperObj.setAbsContent(getPaperInfo(eachFileSegmentList,searchKeyWordArray[7]));
//    				System.out.println(paperKey);
    				result1.put(paperKey, eachPaperObj);
    			}else {System.out.println("no Doi");}
    		});
    		System.out.println(result1.get("Liu2022"));
    		}
        catch(Exception ex) {
        	isErr = true;
        	System.out.println(ex);
        }
    	
//        MiniMendeleyEngine engine = new MiniMendeleyEngine();
//        engine.userInterface();
    }
    public static ArrayList<String> loadBibFile(String bibfilePath)throws Exception {
    	File inputFile = new File(bibfilePath);
        ArrayList<String> fileArrayList = new ArrayList<String>();
    	Scanner sc = new Scanner(inputFile);
    	sc.useDelimiter(",\n}");  
    	while(sc.hasNext()) {
    		fileArrayList.add(sc.next());    		
    	}
    	sc.close();
    	return fileArrayList;
    }
    public static String getPaperInfo(ArrayList<String> eachFileSegmentList,String searchKeyWord){
    	String paperInfo = null;
    	for (int i =0;i<eachFileSegmentList.size();i++) {
    		String eachFileSegment = eachFileSegmentList.get(i);
    		if (eachFileSegment.contains(searchKeyWord)) {
    			paperInfo = eachFileSegment.substring(eachFileSegment.indexOf("{")+1);
    		}
    	}
    	return paperInfo;
    }
    public static ArrayList<String>getPaperAuthorsOrKeyword(ArrayList<String> eachFileSegmentList,String searchKeyWord){
    	String paperInfo = null;
    	String[] tempInfoArray = null;
    	ArrayList<String> authorArrayList = new ArrayList<String>();
    	authorArrayList.clear();;
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
