package project2;
import java.util.*;

public class States {
    // Prints available options to the user
    public static void displayMenu() {
        try {
            Thread.sleep(2500); // Used to create a delay for the menu to print
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("1. Display Text\n");
        System.out.println("2. Search the text\n");
        System.out.println("3. Exit the program\n");
    }

    // Prints all states to the terminal
    public static void displayText(String[] states) {
        for (String state : states) {
            System.out.println(state);
        }
        System.out.println();
        displayMenu();
    }

    public static Set<String> searchText(String input, String[] words) {
        Set <String> result = new HashSet<>(); // Creates set
        input = input.toLowerCase(); // Standardizes case

        // For each word in the list of words
        for (String word : words) {
            String tempWord = word.toLowerCase();
            // For each group of letters the length of the user's search term that can fit in the word
            for (int i = 0; i < word.length() - input.length(); i++) {
                if (input.equals(tempWord.substring(i, i + input.length()))) {
                    result.add(word); // If match, add the word to the result set
                }            
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("\nWelcome to the text search engine.\n");
        Scanner scnr = new Scanner(System.in);
        displayMenu();
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
                        displayText(theStates); // Prints all states
                        break;
                    case 2:

                        try {
                            // Gets search term from user, then returns a set with all words containing a match
                            System.out.print("Enter search term: ");
                            String searchTerm = scnr.next();
                            Set <String> output = searchText(searchTerm, theStates);

                            // Prints the results
                            System.out.println("\nResults:");
                            for (String result : output) {
                                System.out.println(result);
                            }
                            
                            System.out.println();

                        } catch (Exception e) { System.out.println("\nInvalid input.\n"); }
                        break;
                    case 3: 
                    // Exits the program early
                        System.out.println("\nTerminating program...\n");
                        scnr.close(); // Addresses memory leaks
                        System.exit(0);
                    default:
                        System.out.println("Invalid input");
                        break;
                }
            } finally {}
        }
    }
}