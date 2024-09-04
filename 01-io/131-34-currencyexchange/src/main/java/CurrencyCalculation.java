import java.util.Scanner;

public class CurrencyCalculation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("How many euros are you exchanging?\n");
		double euros = scanner.nextDouble();

		System.out.print("What is the exchange rate?\n");
		double rate = scanner.nextDouble();

		double usd = (euros / 100) * rate;
		System.out.printf("%.2f euros at an exchange rate of %.2f is %.2f U.S. dollars.\n", euros, rate, usd);
	}
}


