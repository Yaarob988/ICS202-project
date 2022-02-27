import java.util.*;
public class ProjectDriver {
	public static void main(String[] args) throws Exception {
		
		Scanner sc=new Scanner(System.in);
		MSLL<String> m= new MSLL<String>();
		String cityname;
		double lati;
		double longi;
		int choice = 0;
		String st;
		City c1;
	
		do {
			try {
			choice=getMenuChoice();
			
			switch (choice) {
			case 1:
				System.out.println("Enter the cityname:");
				 cityname=sc.next();
				System.out.println("Enter the Latitude:");
				 lati=sc.nextDouble();
				System.out.println("Enter the Longitude:");
				 longi=sc.nextDouble();
				 c1=new City(cityname,lati,longi);
				m.addCityToSublistAtRear(c1);
				System.out.println("Added!");
				System.out.println();
				break;
			case 2:
				System.out.println("Enter the cityname:");
				 cityname=sc.next();
				System.out.println("Enter the Latitude:");
				 lati=sc.nextDouble();
				System.out.println("Enter the Longitude:");
				 longi=sc.nextDouble();
				c1=new City(cityname,lati,longi);
				System.out.println("Enter position");
				int position=sc.nextInt();
				m.addToCitySublistList(c1, position);
				System.out.println("Added!");
				System.out.println();
				break;
			case 3:
				System.out.println("Enter the cityname:");
				 cityname=sc.next();
				 c1=new City(cityname);
				 System.out.println(m.cityIsInSubList(c1));
				 System.out.println();
				break;
			case 4: 
				System.out.println("Enter the cityname:");
				 cityname=sc.next();
				 c1=new City(cityname);
				 m.deleteCityFromSublist(c1);
				 System.out.println("Deleted!");
				 System.out.println();
				 break;
			case 5: 
				do {
				System.out.println("Enter 1 letter to delete city sublist");
				 st=sc.next();
				 }while(st.length()!=1);
				m.deleteCitySublist(st);
				System.out.println("Done");
				System.out.println();
				break;
			case 6: 
				do {
					System.out.println("Enter 1 letter to delete city sublist");
					 st=sc.next();
					 }while(st.length()!=1);
				m.makeCitySublistEmpty(st);
				System.out.println("Done!");
				System.out.println();
				break;
				
			case 7: 
				do {
					System.out.println("Enter 1 letter to dispay city sublist");
					 st=sc.next();
					 }while(st.length()!=1);
				m.displayCitySublist(st);
				break;
			case 8: 
				do {
					System.out.println("Enter 1 letter to add to city sublist to head");
					 st=sc.next();
					 }while(st.length()!=1);
				m.addToMSLLHead(st);
				System.out.println("Added to head!");
				break;
			case 9:
				do {
					System.out.println("Enter 1 letter to add to city sublist to tail");
					 st=sc.next();
					 }while(st.length()!=1);
				m.addToMSLLTail(st);
				System.out.println("Added to tail!");
				break;
			case 10:
				do {
					System.out.println("Enter 1 letter to search");
					 st=sc.next();
					 }while(st.length()!=1);
				System.out.println(m.isInMList(st));
				System.out.println();
				break;
			case 11:
				System.out.println("Enter 2 cities to get destance");
				String city1=sc.next();
				String city2=sc.next();
				System.out.println("thr distance between "+city1+" and "+city2+"= "+m.getDistance(city1, city2));
				break;
			case 12: 
				System.out.println("thanks for using \n Done by: Yaroub Alokaily \t ID: 201852160");
				sc.close();
			}
			}catch(Exception e) {
				System.out.println(e);
			}
			}while (choice != 12);
	}
	
	public static int getMenuChoice() {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("Please select the operation: ");
			System.out.println("1. AddCityToSublistAtRear");
			System.out.println("2. AddCityToSublistAtPosition");
			System.out.println("3. SearchForCity");
			System.out.println("4. DeleteCityFromCitySublist");
			System.out.println("5. DeleteCitySublist");
			System.out.println("6. MakeCitySublistEmpty");
			System.out.println("7. DisplayCitySublist");
			System.out.println("8. addToMSSLAtHead");
			System.out.println("9. AddToMSSLAtTail");
			System.out.println("10. SearchMSLList");
			System.out.println("11. getDistance");
			System.out.println("12. Exit");

			choice = scanner.nextInt();
			if (choice < 1 || choice > 12)
				System.out.println("Error: Wrong operation!");
		} while (choice < 1 || choice > 12);
		//scanner.close();
		return choice;
	}
}
