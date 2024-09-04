import java.util.Scanner;

public class Literal {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       String input = scanner.nextLine();

       if(input.contains("'")) {
           System.out.println("char");
       } else if(input.contains(".")) {
           if (input.contains("f")) {
               System.out.println("float");
           } else {
               System.out.println("double");
           }
       } else if(input.matches("\\d+L")) {
           System.out.println("long");
       } else if(input.matches("\\d+")) {
           System.out.println("integer");
       } else if (input.matches("true|false")) {
           System.out.println("boolean");
       }

       scanner.close();
    }
}
