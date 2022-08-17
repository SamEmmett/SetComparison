import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.io.*;


public class Run {
	public void runThis() {
	HashSet StaticSet = new HashSet(); // declares a HashSet that will hold static values.

	HashSet DynaSetA = new HashSet(); // This set will be generated based upon the users inputs

	HashSet DynaSetB = new HashSet(); // This set will be generated based upon the users inputs

	ArrayList<Integer> StaticIn = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 3, 0, 11)); // Generates an Array of all
																						// static values
	StaticSet.addAll(StaticIn); // adds all values from the array into the HashSet

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	DynaSetA = genDynaSetA(); // Sets the Dynamic set to what the user generates
	DynaSetB = genDynaSetB(); // Sets the Dynamic set to what the user generates

	System.out.println("Set S is: " + StaticSet);
	System.out.println("Set A is: " + DynaSetA);
	System.out.println("Set B is: " + DynaSetB);
	System.out.println();

	Validate(StaticSet, DynaSetA, DynaSetB); // runs validate

	Union(StaticSet, DynaSetA, DynaSetB); // runs Union

	Intersection(StaticSet, DynaSetA, DynaSetB); // runs Intersection

	ComplimentSet(StaticSet, DynaSetA, DynaSetB); // Runs ComplimentSet
}

private static HashSet genDynaSetA() { // Used to generate a set for comparison

	
	
	Scanner input = new Scanner(System.in); // Scanner to accept input from the user

	HashSet DynaSetShell = new HashSet(); // generates the DynamicSet place holder

	int in; // initializing 'in' to hold input value and pass it too the HashSet
	
	System.out.println("Let's generate Set A...");
	for (int i = 0; i < 4; i++) {
		System.out.println("Please enter a number from 0 to 12 (no repeats):");
		in = input.nextInt();

		// A check in case the user doesn't use a number from 0 to 12
		if ((in > 12 || in < 0) || DynaSetShell.contains(in) == true) {
			System.out.println("The number that was entered does not meet the requested parameters, or is already in the set...");
			i--; // this lowers the count so that the users bad input is not added to the array
					// AND it prevents the counter of the loop from increasing
		} else {
			DynaSetShell.add(in);
			System.out.println();
		}
	}
	
	return DynaSetShell;

}

private static HashSet genDynaSetB() { // Used to generate a set for comparison

	Scanner input = new Scanner(System.in); // Scanner to accept input from the user

	HashSet DynaSetShell = new HashSet(); // generates the DynamicSet place holder

	int in; // initializing 'in' to hold input value and pass it too the HashSett

	System.out.println("Let's generate Set B...");
	
	for (int i = 0; i < 4; i++) {
		System.out.println("Please enter a number from 0 to 12:");
		in = input.nextInt();

		// A check in case the user doesn't use a number from 0 to 12
		if ((in > 12 || in < 0) || DynaSetShell.contains(in) == true) {
			System.out.println("The number that was entered does not meet the requested parameters, or is already in the set...");
			i--; // this lowers the count so that the users bad input is not added to the array
					// AND it prevents the counter of the loop from increasing
		} else {
			DynaSetShell.add(in);
			System.out.println();
		}

	}


	return DynaSetShell;

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

private static boolean Validate(HashSet S, HashSet A, HashSet B) { // Checks if the DynaSet is a SubSet of the
																	// Static Set
	// Also returns true or false based on whether the set is or is not a subset

	boolean SubSet;
	System.out.println();

	if (S.containsAll(A) == true) { // Checks if set A contains ALL of the contents of set B
		SubSet = true;
		System.out.println("Set A is a SubSet of Set S (Static)");
		System.out.println();
	} else {
		SubSet = false;
		System.out.println("Set A is not a SubSet of Set S (Static)");
		System.out.println();
	}

	if (S.containsAll(B) == true) { // Checks if set A contains ALL of the contents of set B
		SubSet = true;
		System.out.println("Set B is a SubSet of Set S (Static)");
		System.out.println();
	} else {
		SubSet = false;
		System.out.println("Set B is not a SubSet of Set S (Static)");
		System.out.println();
	}

	return SubSet;
}

private static void Union(HashSet S, HashSet A, HashSet B) { // Displays the union of set A and set B.

	HashSet temp = new HashSet(S);
	HashSet temp2 = new HashSet(S);
	temp.addAll(A); // Adds the content of set A to set S while omitting any duplicate elements
	temp2.addAll(B);// Adds the content of set B to set S while omitting any duplicate elements

	System.out.println("The Union of Set S (Static) and Set A is: " + temp);
	System.out.println("The Union of Set S (Static) and Set B is: " + temp2);

	temp.addAll(temp2); // Union of all sets
	System.out.println("The Union of all sets is: " + temp);

	System.out.println();

}

private static void Intersection(HashSet S, HashSet A, HashSet B) { // Finds the intersection of sets A and B and
																	// also

	HashSet temp = new HashSet(S);
	HashSet temp2 = new HashSet(S);

	temp.retainAll(A); // Finds the intersection of Sets A and B
	temp2.retainAll(B);

	System.out.println("The Intersection of Set S (Static) and Set A (Dynamic) is: " + temp);
	System.out.println("The Intersection of Set S (Static) and Set B (Dynamic) is: " + temp2);

	temp.retainAll(temp2); // intersection of all sets
	System.out.println("The intersection of all sets is: " + temp);

	System.out.println();

}

private static void ComplimentSet(HashSet S, HashSet A, HashSet B) { // Finds the compliment between sets A and B
																		// and then

	HashSet temp = new HashSet(S);
	HashSet temp2 = new HashSet(S);

	temp.removeAll(A);
	temp2.removeAll(B);

	System.out.println("The Compliment between Set S (Static) and Set A (Dynamic) is: " + temp);
	System.out.println("The Compliment between Set S (Static) and Set B (Dynamic) is: " + temp2);

	temp.removeAll(temp2); // compliment of all sets

	System.out.println("The compliment of all sets is: " + temp);
	System.out.println();

}

}

