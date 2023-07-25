package JavaProgramming;
import java.util.Scanner;

public class TempConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Conversion Tool");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Enter your choice (1 or 2): ");

    	int choice, n;
		double temp;
		
		System.out.println("Enter number for Loop Iteration");
		n = scanner.nextInt();
		
		for(int i=1; i<=n; i++) {
			
			System.out.println("Enter your choice for Temperature Conversion");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				System.out.println("Enter temperature in Fahrenhiet to convert in Celsius");
				temp = scanner.nextDouble();
				double cels = (temp - 32) * 5/9;
				System.out.println(temp + " " + "Fahrenhiet in Celsius is equal to : " + cels);
				break;
			case 2:
				System.out.println("Enter temperature in Celsius to convert in Fahrenhiet");
				temp = scanner.nextDouble();
				double fhrn = (temp * 9/5 ) + 32;
				System.out.println(temp + " " + "Celsius in Fahrenhiet is equal to : " + fhrn);
				break;
			default :
				System.out.println("You Enter wrong choice. Please Enter 1 or 2 !!!!");
				break;
			}
			
		}
		
        scanner.close();
    }
}
