package project2;
import java.util.Scanner;

public class States {

    public void displayMenu() {
        try {
            Thread.sleep(2500); // Used to create a delay for the menu to print
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1. Display Text\n");
        System.out.println("2. Search the text\n");
        System.out.println("3. Exit the program\n");
    }

    public static void displayText(String[] states) {
        for (String state : states) {
            System.out.println(state);
        }
    }

    public String[] searchText(String input, String[] words) {
        String[] result = new String[50];

        // For each word in the list of words
        for (String word : words) {
            // For each group of letters the length of the user's search term that can fit in the word
            for (int i = 0; i < word.length() - (input.length() - 1); i++) {
                // For each letter in the search term
                for (int j = 0; j < input.length(); j++) {
                    
                }
            }
        }

        return new String[5];
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the text search engine.\n");
        Scanner scnr = new Scanner(System.in);
        String[] theStates = {
            "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delaware", 
            "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", 
            "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", 
            "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", 
            "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", 
            "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", 
            "Wisconsin", "Wyoming"
        };
        
        while (true) {
            try {
                System.out.print("Select Option: ");
                int input = scnr.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Here is the text you can search through:\n");
                        displayText(theStates);
                        break;
                    case 2:

                        try {
                            System.out.print("Enter search term: ");
                            String searchTerm = scnr.next();
                            String[] output = searchText(searchTerm, theStates);
                        } catch (Exception e) {
                            System.out.println("Invalid input.\n");
                        }

                        break;
                    case 3: 
                        System.out.println("Terminating program...\n");
                        scnr.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid input\n");
                        break;
                }
            } finally {}
        }
    }
}