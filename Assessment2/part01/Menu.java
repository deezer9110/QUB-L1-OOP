package part01;

import java.util.Scanner;
import java.awt.Font;
import javax.swing.ImageIcon;
import console.Console;

/**
 * This class represents ...
 * 
 * @author Paul Sage
 * @version V1.0
 *
 */
public class Menu {
	private String options[]; // array of strings representing user options
	private String title; // menu title
	private Scanner input; // for KB input

	/**
	 * Constructor for class
	 * 
	 * @param title   - the menu title
	 * @param options - the options for user selection
	 */
	public Menu(String title, String options[]) {
		this.title = title;
		// this.options = options;
		copyOptions(options);
		input = new Scanner(System.in);
	}

	/**
	 * Requests and read a user choice
	 * 
	 * @return - the user choice
	 */
	public int getChoice() {
		try {
			System.out.print("Enter (valid) choice: ");
			int choice = input.nextInt();
			input.nextLine();
			return choice;
		} catch (Exception e) {
			input.nextLine();
			return -1;
		}
	}

	/**
	 * /**
	 * Same purpose as getChoice but with console output
	 * @param con - Desired console for outputs
	 * @return - int value of choice
	 */
	public int getChoiceConsole(Console con) {
		try {
			con.print("Enter (valid) choice: ");
			String choiceS = con.readLn();
			int choice = Integer.parseInt(choiceS);
			return choice;
		} catch (Exception e) {
			return -1;
		}
	}

	/**
	 * displays the menu title followed by the user option for selection
	 */
	public void display() {
		System.out.println("\n");
		if (title != null && options != null) {
			// title and options are valid
			// display title and underline with '+'
			for (int i = 0; i < title.length(); i++) {
				System.out.print("+");
			}
			System.out.println("\n" + title);
			for (int i = 0; i < title.length(); i++) {
				System.out.print("+");
			}
			System.out.println("\n");
			// display the menu options
			// prefix each with an int starting at 1
			int count = 1;
			for (String str : options) {
				System.out.println(count + ". " + str);
				count++;
			}
			System.out.println();
		} else {
			// title and/or options are not valid
			System.out.println("Menu not defined.");
		}
	}

	/**
	 * Same purpose as display but with console output
	 * @param con - Desired console for outputs
	 */
	public void displayConsole(Console con) {
		con.print(menuImage(title));
		con.print("\n");
		con.setFont(new Font("Arial", Font.BOLD, 40));
		
		if (title != null && options != null) {
			// title and options are valid
			// display title and underline with '+'
			for (int i = 0; i < title.length(); i++) {
				con.print("+");
			}
			con.print("\n" + title + "\n");
			for (int i = 0; i < title.length(); i++) {
				con.print("+");
			}
			con.print("\n");
			// display the menu options
			// prefix each with an int starting at 1
			con.setFont(new Font("Arial", Font.PLAIN, 25));
			int count = 1;
			for (String str : options) {
				con.println(count + ". " + str);
				count++;
			}
			con.print("\n");
		} else {
			// title and/or options are not valid
			con.println("Menu not defined.\n");
		}
	}

	/**
	 * Displays relative menu images
	 * @param menu - menu passed through
	 * @return - image
	 */
	private static ImageIcon menuImage(String menu) {
		ImageIcon image;
		switch (menu) {
		case "QUBKitchen":
			image = new ImageIcon("Images\\QUBKitchen3.png");
			break;
		case "Manage Ingredients":
			image = new ImageIcon("Images\\Ingredients3.png");
			break;
		case "Manage Recipes":
			image = new ImageIcon("Images\\Recipes3.png");
			break;
		case "Manage Weekly Menu":
			image = new ImageIcon("Images\\Menu3.png");
			break;
		default:
			image = new ImageIcon("Images\\noImage.webp");
			break;
		}
		return image;
	}

	/**
	 * will initialise the options array by copying contents of data
	 * 
	 * @param data - array of Strings - options for user to select from
	 */
	private void copyOptions(String data[]) {
		if (data != null) {
			options = new String[data.length];
			for (int index = 0; index < data.length; index++) {
				options[index] = data[index];
			}
		} else {
			options = null;
		}
	}

}
