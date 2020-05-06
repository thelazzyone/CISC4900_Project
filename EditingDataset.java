package EditingCSVFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.File;
import java.io.FileReader;		//read file
import java.io.FileWriter;		//write into a file
import java.io.PrintWriter;
//import java.util.Scanner;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EditingDataset {
	
	//private static Scanner x;
	static ArrayList<String> alist = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filepath = "C:\\Users\\eddie\\eclipse-workspace\\Remember Java\\src\\EditingCSVFile\\featMatVersion2_5.csv";
		
		editRecord(filepath);

	}
	
	public static void editRecord(String filepath) {
		String tempFile = "C:\\Users\\eddie\\eclipse-workspace\\Remember Java\\src\\EditingCSVFile\\DataSet.csv";
		
		try {
			//read each line and combine 2 at a time
			FileWriter fw = new FileWriter(tempFile, true);	//write into the new file
			FileReader fr = new FileReader(filepath);
			
			BufferedWriter bw = new BufferedWriter(fw);		//write into new file
			BufferedReader br = new BufferedReader(fr);		//read file
			
			PrintWriter pw = new PrintWriter(bw);
			
			//read each line one by one
			String line;
			while((line = br.readLine()) != null) {
				//System.out.println(line);
				alist.add(line);		//adding all the read line into the list
				//pw.println(line);
			}
			
			//print into the the new file
			//combined 2 rows into 1
			for(int i = 0; i < alist.size(); i = i + 2) {
				pw.println(alist.get(i) + "," + alist.get(i + 1));
			}
			
			br.close();
			pw.flush();
			pw.close();
			JOptionPane.showMessageDialog(null, "Record transfered");
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Record not transfered");
		}
	}

}
