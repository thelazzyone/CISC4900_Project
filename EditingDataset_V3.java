package EditingCSVFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class EditingDataset_V3 {
		//new lables
		static String X = "User_ID1,Doc_ID1,Inter-Stroke time1,Stroke Duration1,Start X1,Start Y1,Stop X1,Stop Y1,"
				+ "			Direct end-to-end Distance1,Mean resulant length1,WSAD Flag1,Direction of end-to-end Time1,"
				+ "			Phone_ID1,20 per pairwise velocity1,50 per pairwise velocity1,80 per pairwise velocity1,"
				+ "			20 per pairwise acc1,50 per pairwise acc1,80 per pairwise acc1,Median velocity at last 3pts1,"
				+ "			Largest deviation from end-to-end line1,20 per dev line1,50 per dev line1,80 per dev line1,"
				+ "			Average Direction1,Length of Trajectory1,Ratio dist and length of trajectory1,Average velocity1,"
				+ "			Median acceleration at first 5 pts1,Mid-Stroke pressure1,Mid-Stroke area covered1,"
				+ "			Mid-Stroke finger orientation1,Change of finger orientation1,Phone orientation1";
		
		static String Y = "User_ID2,Doc_ID2,Inter-Stroke time2,Stroke Duration2,Start X2,Start Y2,Stop X2,Stop Y2,"
				+ "			Direct end-to-end Distance2,Mean resulant length2,WSAD Flag2,Direction of end-to-end Time2,"
				+ "			Phone_ID2,20 per pairwise velocity2,50 per pairwise velocity2,80 per pairwise velocity2,"
				+ "			20 per pairwise acc2,50 per pairwise acc2,80 per pairwise acc2,Median velocity at last 3pts2,"
				+ "			Largest deviation from end-to-end line2,20 per dev line2,50 per dev line2,80 per dev line2,"
				+ "			Average Direction2,Length of Trajectory2,Ratio dist and length of trajectory2,Average velocity2,"
				+ "			Median acceleration at first 5 pts2,Mid-Stroke pressure2,Mid-Stroke area covered2,"
				+ "			Mid-Stroke finger orientation2,Change of finger orientation2,Phone orientation2";

		
		//private static Scanner x;
		static ArrayList<String> alist = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String filepath = "C:\\Users\\eddie\\eclipse-workspace\\Remember Java\\src\\EditingCSVFile\\featMatVersion2_10.csv";
		
		editRecord(filepath);

	}
	
	public static void editRecord(String filepath) {
		String tempFile = "C:\\Users\\eddie\\eclipse-workspace\\Remember Java\\src\\EditingCSVFile\\DataSet_V4.csv";
		
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
			
			
			//print the new lables
			pw.println(X + "," + Y);
			
			
			int NewRowCounter = 0;
			int DiffUser = 0;
	        String sep = ",";
			
			//looping through the dataset
	        //row 0 is labels and can't compare row 1 with row 0
			for(int i = 2; i < alist.size(); i++) {
				String currentRow = alist.get(i);		//current row
				String previousRow = alist.get(i - 1);		//previous row

				//seperate/split the rows to compare them later
				String[] checkC = currentRow.split(sep);
				String[] checkP = previousRow.split(sep);
				
				//0, 1, 2, 3, .... , n
				//compare the user column
				if(checkC[0].equals(checkP[0])) {	//if users are the same
					pw.println(alist.get(i - 1) + "," + alist.get(i));
					NewRowCounter++;
				} else {
					DiffUser++;
				}
				
			}
			
			System.out.println("The amount of rows = " + alist.size());
			System.out.println("The amount of new rows = " + NewRowCounter);
			System.out.println("Different amount of users = " + DiffUser);
			
			br.close();
			pw.flush();
			pw.close();
			JOptionPane.showMessageDialog(null, "Record transfered");
			
		} catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Record not transfered");
		}
	}

}
