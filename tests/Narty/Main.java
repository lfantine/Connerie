import java.util.Scanner;

public class Main {
	// VAR
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] argv) {
		System.out.println("Starting !");
		System.out.println("Ecriver quelque chose :");
		String s = scanner.nextLine();
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (isNumeric(s.charAt(i))) {
				res = s.charAt(i) - 48;
				i++;
				while (i < s.length() && isNumeric(s.charAt(i))) {
					res *= 10;
					res += s.charAt(i) - 48;
					i++;
				}
				i = s.length() + 1;
			}
		}
		System.out.println("dizaine du chiffre : " + (res - (res % 10))/10);
	}

	public static boolean isNumeric(char c) {
		if (c >= 48 && c <= 57)
			return true;
		return false;
	}
}