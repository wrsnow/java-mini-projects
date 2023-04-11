import java.util.Random;
import java.util.Scanner;

public class Game {
	enum Choice {
		ROCK, PAPER, SCISSORS
	}

	public static Choice getChoice(String input) {
		try {
			return Choice.valueOf(input.toUpperCase());
		} catch (IllegalArgumentException e) {
			return null;
		}
	}

	public static int getRandomNum(int max) {
		return (int) Math.floor(Math.random() * max);
	}

	public static String checkWin(Choice user, Choice computer) {
		if (user == computer) {
			return "IT'S A TIE";
		}
		switch (user) {
			case ROCK:
				return computer == Choice.SCISSORS ? "USERS WINS" : "COMPUTER WINS";
			case PAPER:
				return computer == Choice.ROCK ? "USERS WINS" : "COMPUTER WINS";
			case SCISSORS:
				return computer == Choice.PAPER ? "USERS WINS" : "COMPUTER WINS";
			default:
				return "Whoops... That's not a valid option";
		}
	}

	public static void PrintResult(String result, Choice userPick, Choice computerPick) {
		System.out.println("---------------------------------------");
		System.out.println(result);
		System.out.println("---------------------------------------");
		System.out.println("USER PICKED: " + userPick);
		System.out.println("---------------------------------------");
		System.out.println("COMPUTER PICKED: " + computerPick);
		restart();
	}

	public static void restart() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("---------------------------------------");
			System.out.println("DO YOU WANNA PLAY AGAIN?");
			String userInput = scanner.nextLine();
			switch (userInput.toUpperCase()) {
				case "YES":
				case "YE":
				case "Y":
					start();
					break;
				default:
					return;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void start() {
		try (Scanner scanner = new Scanner(System.in)) {
			Random random = new Random();
			System.out.println("Rock, Paper or Scissors?");
			String userInput = scanner.nextLine();
			Choice userPick = getChoice(userInput);
			Choice computerPick = Choice.values()[random.nextInt(Choice.values().length)];
			String result = checkWin(userPick, computerPick);
			PrintResult(result, userPick, computerPick);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		start();
	}
}
