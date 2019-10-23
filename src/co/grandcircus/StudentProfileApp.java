package co.grandcircus;

import java.util.Scanner;

public class StudentProfileApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] names = { "Joe", "Chris", "Nina", "John", "Abby", "Alexa", "Siri", "Cortana", "Google", "Charlie" };
		String[] hometown = { "Detroit", "Southfield", "Los Angeles", "New York City", "New Orleans", "Denver",
				"Topeka", "Dallas", "San Diego", "Tokyo" };
		String[] favFood = { "tacos", "meatballs", "pizza", "spaghetti", "quinoa", "sushi", "microchips", "data",
				"private data", "hamburgers" };

		int userInput = 0;
		String data = "";
		String cont = "yes";

		while (cont.equals("yes")) {
			// your code should start here!
			userInput = Validator.getInt(scan,
					"Welcome to our Java class. Which student would you like to learn more about? (enter a number 1-10): ",
					1, 10);
			String prompt = "Student " + userInput + " is " + names[userInput - 1] + "."
					+ " What would you like to know about " + names[userInput - 1] + "? (enter hometown or food): ";
			data = Validator.getString(scan, prompt);
			if (data.equalsIgnoreCase("hometown") || data.equalsIgnoreCase("food")) {
				cont = searchDatabasesAndGetUserResponse(scan, data, userInput, hometown, favFood, names);
			} else {
				data = Validator.getString(scan,
						"That data does not exist. Please try again. (enter hometown or food): ");
				cont = searchDatabasesAndGetUserResponse(scan, data, userInput, hometown, favFood, names);
			}

		}

		System.out.println("Thanks!");
		scan.close();
	}

	private static String searchDatabasesAndGetUserResponse(Scanner scan, String data, int i, String[] arr, String[] arr2,
			String[] arr3) {
		String cont = "";
		if (data.equalsIgnoreCase("hometown")) {
			cont = Validator.getString(scan,
					arr3[i - 1] + " is from " + arr[i - 1] + ". Would you like to know more? (enter yes or no): ");
		} else if (data.equalsIgnoreCase("food")) {
			cont = Validator.getString(scan, arr3[i - 1] + "'s favorite food is " + arr2[i - 1]
					+ ". Would you like to know more? (enter yes or no): ");
		}
		return cont;
	}

}