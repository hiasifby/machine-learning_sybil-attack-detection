package Initial;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String dirPath = "D:/Asif/m1";
		String topologypath = "";
		String folderpath = "";
		String filepath = "";
		File dir = new File(dirPath);
		String[] files = dir.list();
		
		Helpclass helpobj = new Helpclass();
		if (files.length == 0) {
		    System.out.println("The directory is empty");
		} else {
		    for (String aFile : files) {
		        System.out.println(aFile);   //topologyname
		        topologypath = dir +"/"+ aFile;
		        File folder = new File(topologypath);
		        String[] fol = folder.list();
		        for (String afol : fol){
		        	System.out.println(afol);  //foldername
		        	folderpath = topologypath + "/" + afol;
		        	File cchain = new File(folderpath);
		        	String[] cc = cchain.list();
		        	if(cc.length != 0){
		        		filepath = folderpath + "/" + "CChain.txt";
		        		helpobj.Parseline(filepath, afol);
		        		
		        	}
		        	
		        }
		    }
		}
		helpobj.Calxyhof();
		helpobj.Calavg();
		helpobj.Caldistance();
		System.out.println("finish");
	}

}
