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
        boolean active = true;
        do {
            System.out.print("Enter an X value to solve with the equation above: ");
            if (s.nextLine().contains("q")) {
                active = false;
            }
            System.out.println(l.solve(Double.parseDouble(s.nextLine())));
        } while (active);
    }
 }

