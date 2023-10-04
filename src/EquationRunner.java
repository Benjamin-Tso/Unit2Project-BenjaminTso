import java.util.Scanner;
public class EquationRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Hello!\nEnter a set of coordinates, please include both parentheses, use a period for decimal points, and separate x and y values with a comma. ");
        String c1 = s.nextLine().replace("\n", "").replace("\r", "").replaceAll(" ", "");
        System.out.print("Now Enter another set of coordinates, follow the same rules as above. ");
        String c2 = s.nextLine().replace("\n", "").replace("\r", "").replaceAll(" ", "");
        LinearEquation l = new LinearEquation(c1, c2);
        System.out.println(l);
        do {
            System.out.print("Enter an X value to solve with the equation above(q to quit): ");
            String in = s.nextLine().replace("\n", "").replace("\r", "").replaceAll(" ", "");
            boolean isNumber = true;
            for (int i = 0; i < in.length(); i++) {
                if (!Character.isDigit(in.charAt(i)) && !String.valueOf(in.charAt(i)).equals(".")){
                    isNumber = false;
                }
            }
            if (in.contains("q")) {
                break;
            }
            else if (isNumber){
                System.out.println(l.solve(Double.parseDouble(in)));
            }
        } while (true);
        System.out.println("Goodbye!");
    }
 }

