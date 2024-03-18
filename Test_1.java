
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Test_1 {

	

	public static void main(String[] args) throws FileNotFoundException, IOException  {
		
		
		//Creating stack and queue.
		Stack S1 = new Stack(300);
		Stack tempS2 = new Stack(300);
		Stack tempS22 = new Stack(300);
		Stack tempRandom = new Stack(300);
		Stack tempCountry = new Stack(300);
		Stack tempNumber = new Stack(300);
		Stack tempInteger = new Stack(300);
		Stack tempName = new Stack(300);
		Stack S2 = new Stack(300);
		Stack S3 = new Stack(300);
		Stack S4 = new Stack(300);
		Queue Q1 = new Queue(5000);
		Queue tempQ1 = new Queue(5000);
		Queue tempQ2 = new Queue(5000);
		Queue tempQ22 = new Queue(5000);
		Queue Q2 = new Queue(5000);
		
		//Variables
		int tColumnCount = 2;
		String strQ2 = "";
		String strQ1 = "";
		String randomL = "";
		int countStep = 1;
		int countScore = 0;
		
		//-----------------Getting gamer's name--------------------//
		System.out.print("Please enter your name: ");
		System.out.println("");
		try (Scanner scanner = new Scanner(System.in)) {
			String gamer = scanner.nextLine();
			//System.out.print(gamer);
			
			//-----------------Reading File---------------------------//
			//Reading the unsorted file of HighScoreTable. 
			//Finding the file in the computer.
			Path tablePath = Paths.get("HighScoreTable.txt");											
			Scanner table = new Scanner(tablePath);
			//Counting the HighScoreTable file lines for arrays rows.
			int tRowCount = (int)Files.lines(tablePath).count();
			//Creating 2d array for high score.															
			String[][] arrayTable = new String[tRowCount][tColumnCount];	
			//Putting file's data to the array for moving the file to Stack.
			while (table.hasNextLine()) {						
			    for(int i=0;i<arrayTable.length;i++) {
			        String[] line = table.nextLine().trim().split(" ");
			        for (int j=0; j<line.length; j++) {
			            arrayTable[i][j] =line[j];
			            //System.out.println(arrayTable[i][j]);
			        }
			    }
			}
			table.close();
			//Putting the array's data to the stack.
			for(int i=0;i<arrayTable.length;i++) {
			    S3.push(arrayTable[i][0]);
			    S4.push(arrayTable[i][1]);
			}
			//Converting to integer.
			while (!S4.isEmpty()) {
				int number = Integer.parseInt((String) S4.pop());
				tempInteger.push(number);
			}
			while (!tempInteger.isEmpty()) {
				S4.push(tempInteger.pop());
			}
			
			//---------------------Random number for countries---------------//
			//Creating instance of Random class.
			Random randomN = new Random();
			//Generating random integers in range 0 to 194.
			int randNumber = randomN.nextInt(195);
			System.out.println("Randomly generated number: " + randNumber);
			System.out.println("");
			//Reading the unsorted file of countries.
			//Finding the file in the computer.
			Path countryPath = Paths.get("countries.txt");											
			Scanner country = new Scanner(countryPath);
			//Putting file's data to the array for moving the file to Stack.
			String [] arrayCountry = new String[195];
			for (int i=0; i<195; i++) {
				arrayCountry[i] = country.nextLine();
			    arrayCountry[i]=arrayCountry[i].toUpperCase(Locale.ENGLISH);
			    //System.out.println(arrayCountry[i]);
			}
			country.close();
			//Putting the array's data to the stack.
			for (int j=0; j<arrayCountry.length; j++) {
				S1.push(arrayCountry[j]);
			}
			
			//----------------------Sorting-------------------------------//
			while(!S1.isEmpty())
			{
			    //Pop out the first element.
			    String tmpSS = (String) S1.pop();
			 
			    //While temporary stack is not empty and top of stack is greater than temp.
			    while(!tempCountry.isEmpty() &&  ((String) tempCountry.peek()).compareTo(tmpSS)>0)
			    {
			        //Pop from temporary stack and push it to the input stack.
			        S1.push(tempCountry.pop());;
			    }
			     
			    //Push temp in temporary of stack
			    tempCountry.push(tmpSS);
			}
			while (!tempCountry.isEmpty())
			{
				S1.push(tempCountry.pop());
			}
			/*
			while (!S1.isEmpty())
			{
				System.out.println(S1.pop());
			}
			*/
			////////////////////////////////////////////////////////////////////
			//Finding the country in the stack.
			int countCoutry=1;
			while(countCoutry<randNumber) {
				S1.pop();
				countCoutry++;
			}
			//Getting the number of letters in the country.
			int countChar = S1.peek().toString().length();
			//System.out.println(countChar);
			//System.out.println(S1.peek());
			
			//Storing this country in a Queue (Q1).
			String sCountry = S1.peek().toString();
			for(int m=0; m<countChar; m++) {
				Q1.enqueue(sCountry.charAt(m));
			}
			//System.out.println(Q1.peek());
			
			//--------------------Queue (Q2)--------------------//
			int countWord = 1;
			System.out.print("Word: ");
			while(countWord<countChar+1) {
				Q2.enqueue("-");
				System.out.print(Q2.dequeue());
				countWord++;
			}
			if (Q2.isEmpty()) {
				for (int n=0; n<countChar; n++) {
					Q2.enqueue("-");
				}
			}
			//Printing Step and Score.
			System.out.print("     " + "Step: " + countStep + "     " + "Score: " + countScore + "        ");
			
			
			//-------------------------Stack (S2)---------------------//
			//Adding all letters in a Stack.
			S2.push("Z");S2.push("Y");S2.push("X");S2.push("W");S2.push("V");S2.push("U");
			S2.push("T");S2.push("S");S2.push("R");S2.push("Q");S2.push("P");
			S2.push("O");S2.push("N");S2.push("M");S2.push("L");S2.push("K");
			S2.push("J");S2.push("I");S2.push("H");S2.push("G");S2.push("F");
			S2.push("E");S2.push("D");S2.push("C");S2.push("B");S2.push("A");
			
			
			//-------------------------Game----------------------//
			boolean flag = true;
			while(flag) {
				
			    int countWheel = 0;
			    while (!S2.isEmpty()) {
					System.out.print(S2.peek());
			    	tempS22.push(S2.pop());
			    }
				while (!tempS22.isEmpty()) {
			    	S2.push(tempS22.pop());
			    }
				System.out.println("");
			    //-------------------Wheel------------------------//
			    //Creating instance of Random class.
			    Random randomW = new Random();
			    //Generating random integers in range 0 to 7.
			    int randWheel = randomW.nextInt(8);
			    
			    if(randWheel == 0) {
			    	System.out.println("Wheel: " + 10);
			    	countWheel = 10;
			    }
			    else if(randWheel == 1) {
			    	System.out.println("Wheel: " + 50);
			    	countWheel = 50;
			    }
			    else if(randWheel == 2) {
			    	System.out.println("Wheel: " + 100);
			    	countWheel = 100;
			    }
			    else if(randWheel == 3) {
			    	System.out.println("Wheel: " + 250);
			    	countWheel = 250;
			    }
			    else if(randWheel == 4) {
			    	System.out.println("Wheel: " + 500);
			    	countWheel = 500;
			    }
			    else if(randWheel == 5) {
			    	System.out.println("Wheel: " + 1000);
			    	countWheel = 1000;
			    }
			    else if(randWheel == 6) {
			    	System.out.println("Wheel: " + "Double Money");
			    	countWheel = 2 * countScore;
			    }
			    else {
			    	System.out.println("Wheel: " + "Bankrupt");
			    }
			    
			    //Creating instance of Random class.
				Random randomG = new Random();
			    //Generating random integers in range 1 to 26.
			    int randGuess = randomG.nextInt(S2.size())+1;
			    //System.out.println(randGuess);
			    
			    //------------//
			    int countRandom = 1;
			    while (countRandom<randGuess) {
			    	tempRandom.push(S2.pop());
			    	countRandom++;
			    }
			    tempS2.push(S2.pop());
			    //System.out.println(tempS2.pop());
			    //////////////////////////////////////
			    while (!S2.isEmpty()) {
			    	tempRandom.push(S2.pop());
			    }
			    //////////////////////////////////////
			    while (!tempRandom.isEmpty()) {
			    	S2.push(tempRandom.pop());
			    }
			    //////////////////////////////////////
			    System.out.println("Guess: " + tempS2.peek());
			    
			    ///////////////////////////////////////////////////////
			    randomL = "";
			    while (!tempS2.isEmpty()) {
			    	randomL = randomL + (String) tempS2.pop();
			    }
			    //System.out.println(randomL);
			    
			    //Controlling the letters one by one and placing them if they are equal.
			    //Simultaneously, giving points if the letters were equal.
				while (!Q1.isEmpty()) {
					char randomCharLetter = randomL.charAt(0);
					if (Q1.peek().equals(randomCharLetter)) {
						Q2.dequeue();
						tempQ1.enqueue(Q1.dequeue());
						Q2.enqueue(randomCharLetter);
						if (randWheel == 0 || randWheel == 1 || randWheel == 2 || randWheel == 3 || randWheel == 4 || randWheel == 5) {
							countScore = countScore + countWheel;
						}
						if (randWheel == 6) {
							countScore = countWheel;
						}
						if (randWheel == 7) {
							countScore = 0;
						}
					}
					else {
					    tempQ1.enqueue(Q1.dequeue());
						Q2.enqueue(Q2.dequeue());
					}
				}
				//Printing the word made.
				System.out.print("Word: ");
				while (!Q2.isEmpty()) {
					tempQ2.enqueue(Q2.peek());
					System.out.print(Q2.dequeue());
				}
				while (!tempQ2.isEmpty()) {
					tempQ22.enqueue(tempQ2.dequeue());
				}
				countStep++;
				
				//Printing Step and Score.
			    /////////////////////////////////////////////////////////////////////////////////////////////
			    //Displaying space.
			    String space="";
			    if(countScore<10) {
			        space="        ";
			    }
			    else if(countScore>=10&&countScore<100) {
			        space="       ";
			    }
			    else if(countScore>=100&&countScore<1000) {
			        space="      ";
			    }
			    else if(countScore>=1000&&countScore<10000) {
			        space="     ";
			    }
			    else {
			    	space="    ";
			    }	
			    //--------------------------------------------------------------------
			    System.out.print("     " + "Step: " + countStep + "     " + "Score: " + countScore + space);	
			    /////////////////////////////////////////////////////////////////////////////////////////////
				
				//Converting the two queues into strings and checking whether they are equal or not.If they are not, the cycle rotates again.
				strQ2 = "";
				while (!tempQ22.isEmpty()) {
					strQ2 = strQ2 + tempQ22.peek().toString();
					Q2.enqueue(tempQ22.dequeue());
				}
				//System.out.print(strQ2.toString());
				strQ1 = "";
				while (!tempQ1.isEmpty()) {
					strQ1 = strQ1 + tempQ1.peek().toString();
					Q1.enqueue(tempQ1.dequeue());
				}    
				//System.out.print(strQ1.toString());
				if (strQ1.equals(strQ2)) {
					flag = false;
				}
				else {
					flag = true;
				}
			}
			
			System.out.println("");
			System.out.println("");
			System.out.println("You win $" + countScore + "!!!");
			System.out.println("");
			System.out.println("High Score Table");
			//Putting the new gamer and score into the stack.
			S3.push(gamer);
			S4.push(countScore);
			
			//--------------Writing the new gamer and score into the file-------------------//
			Writer output;
			output = new BufferedWriter(new FileWriter(tablePath.toString(), true));
			output.append("\r\n");
			output.append(gamer + " " + countScore);
			output.close();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//-----------Sorting-----------------//
        while(!S4.isEmpty())
        {
            //Pop out the first element.
            int tmpI = (int) S4.pop();
            String tmpS = (String) S3.pop();

            //While temporary stack is not empty and top of stack is greater than temp.
            while(!tempNumber.isEmpty() && (int) tempNumber.peek()< tmpI)
            {
                //Pop from temporary stack and push it to the input stack.
                S4.push(tempNumber.pop());
                S3.push(tempName.pop());
            }

            //Push temp in temporary of stack.
            tempNumber.push(tmpI);
            tempName.push(tmpS);
        }
        while (!tempNumber.isEmpty())
        {
            S4.push(tempNumber.pop());
            S3.push(tempName.pop());
        }
        int countS4 = 1;
        while (!S4.isEmpty() && countS4 < 11)
        {
            System.out.print(S3.pop() + "  ");
            System.out.println(S4.pop());
            countS4++;
        }
        while (!S4.isEmpty())
        {
            S3.pop();
            S4.pop();
        }
        //////////////////////////////////////
        
        
               	
	}
}
