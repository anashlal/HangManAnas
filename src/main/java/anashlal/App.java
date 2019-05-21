package anashlal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		Random rand = new Random();

		String[] Word = { "anas" };

		String secretWord = Word[rand.nextInt(Word.length)];
		char[] array = secretWord.toCharArray();
//		char[] array1 = new char[secretWord.length()];

		int i = 0;
		char input = 0;
		int winCount = 0;
		int tries = 10;
		int wrongCounter = 0;
		String name;

		System.out.println("What is you name?");
		name = keyboard.next();

		System.out.println("Hello " + name + "! Welcome to a game of Hangman!");
		System.out.println("Guess letters until you correctly guess the word ");
		System.out.println("or you fully assemble a complete hangman.");
		System.out.println("You have a " + array.length + " " + "letter word!");

		ArrayList<Character> list1 = new ArrayList<Character>();
		ArrayList<Character> list2 = new ArrayList<Character>();
		while (i < tries) {

			System.out.println("Guess a letter : ");

			input = keyboard.next().charAt(0);

			System.out.println("Guessed Letters are : " + input);

			for (int j = 0; j < notSame(array).length; j++) {

				if (findCorrect(array, input) > 0) {
					j++;
					System.out.println("You got it right");
					winCount++;
					list2.add(input);
					System.out.println(list2);
					break;
				} else if (!(input == notSame(array)[j])) {

					System.out.println("You got it wrong");
					list1.add(input);
					wrongCounter++;
					System.out.println("Your old trying letters");
					System.out.println(list1);
					break;

				}
			}
			if (winCount == notSame(array).length) {
				System.out.println("You have Won!");
				System.out.println(secretWord + " is the correct word!");
				break;
			} else if (hangMan(wrongCounter)) {
				break;
			}
		}

		System.out.println();
	}

	public static boolean hangMan(int wrongCounter) {

		boolean isOver = false;
		System.out.println("------------|");

		switch (wrongCounter) {
		case 1:
			System.out.println("|           O");
			break;
		case 2:
			System.out.println("|           _O");
			break;
		case 3:
			System.out.println("|           _O_");
			break;
		case 4:
			System.out.println("|           O");
			System.out.println("|           |");
			break;
		case 5:
			System.out.println("|            O");
			System.out.println("|           `|´");
			break;
		case 6:
			System.out.println("|           O");
			System.out.println("|           |");
			break;
		case 7:
			System.out.println("|           O");
			System.out.println("|          /|");
			break;
		case 8:
			System.out.println("|           O");
			System.out.println("|          /|\\");
			System.out.println();
			break;
		case 9:
			System.out.println("|           O");
			System.out.println("|          /|\\");
			System.out.println("|          /");
			break;
		case 10:
			System.out.println("|           O");
			System.out.println("|          /|\\");
			System.out.println("|          / \\");
			System.out.println("Sorry, you lost");
			System.out.println("hat is the correct word");
			isOver = true;
			break;
		}
		return isOver;

	}

	private static char[] notSame(char[] a) {
		HashSet<Integer> keys = new HashSet<Integer>();
		char[] result = new char[a.length];
		int j = 0;
		for (int i = 0; i < a.length; i++) {

			if (keys.add((int) a[i])) {
				result[j] = a[i];
				j++;
			}
		}
		return Arrays.copyOf(result, j);
	}

	public static int findCorrect(char[] a, char Input) {

		int count = 0;
		for (int i = 0; i < notSame(a).length; i++) {
			if (notSame(a)[i] == Input)
				count++;
			if (count == 10) {
				break;
			}
		}
		return count;
	}
}