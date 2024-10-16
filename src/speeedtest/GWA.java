import java.util.ArrayList;
import java.util.Scanner;
public class GWA {

	
		public static ArrayList<String[]> subjects  = new ArrayList<>();
		public static ArrayList<String[]> GWA = new ArrayList<>(); 
		static {
		       subjects.add(new String[] {"COMP212A", "COMPUTER PROGRAMMING - OOP","Prelim","Midterm","Endterm","Grade"});
		       subjects.add(new String[] {"COMP222A", "COMPUTER PROGRAMMING - JAVA EE","Prelim","Midterm","Endterm","Grade"});
		       subjects.add(new String[] {"COMP312A", "WEB PROGRAMMING","Prelim","Midterm","Endterm","Grade"});
	}
		public static void main (String Args[]) {
			String code;
			double gwaa=0;
            String choice = "yes";
			double prelim;
			double midterm;
			double endterm;
			double total=0;
			do {
                Scanner input = new Scanner(System.in);
            System.out.println("\n");
			System.out.print("Enter your subject Code: ");
			code = input.nextLine();
			System.out.print("Enter your Prelim grade:");
			prelim = input.nextDouble();
			System.out.print("Enter your Midterm grade:");
			midterm= input.nextDouble();
			System.out.print("Enter your Endterm grade:");
			endterm= input.nextDouble();
			
			for(String []subject:subjects) {
			if (subject [0].equals(code)) {
			 total = (prelim * 0.3)+(midterm * 0.3)+(endterm * 0.4);
			 gwaa = gwaa + total;
			GWA.add(new String[] {subject[0],subject[1], String.valueOf(prelim),String.valueOf(midterm),String.valueOf(endterm),String.valueOf(total)});
			break;
			}
			//stop
			}
			System.out.println("Enter Y to continue");
			choice = input.nextLine();
			choice = input.nextLine();
			
			} while (choice.equals("Y"));
			
			System.out.println("Code:" +"\t"+ "Description"+"\t"+"\t" +"Prelim"+"\t" +"\t"+"Midterm" +"\t"+"Endterm"+"\t"+"Grade" );
			
	for (String [] item:GWA) {
		
				System.out.println(item[0] +"\t"+ item[1]+"\t" +item[2]+"\t" + item[3]  + item[4]  + item[5]  );
				System.out.println();
			
			}
	
	 gwaa = gwaa/subjects.size();
		System.out.println("YOUR FINAL GWA IS: " + gwaa );
		System.out.println();
	
		}
}