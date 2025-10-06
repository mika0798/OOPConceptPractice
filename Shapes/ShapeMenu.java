import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeMenu {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in);) {
            while (true) {
                System.out.println("Choose an option by entering a number: ");
                System.out.println("1. Add a Rectangle" +
                        "\n2. Add a Circle" +
                        "\n3. Add a Triangle" +
                        "\n4. Display all shapes" +
                        "\nAny other keys to exit");
                String choice = scanner.nextLine();
                if (choice.equals("1")) {
                    System.out.print("Enter the shape name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter its color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter the length: ");
                    double length = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter the width: ");
                    double width = scanner.nextDouble();
                    scanner.nextLine();
                    shapes.add(new Rectangle(name, color, length, width));
                    System.out.println("Shape added successfully!");
                } else if (choice.equals("2")) {
                    System.out.print("Enter the shape name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter its color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter the radius: ");
                    double radius = scanner.nextDouble();
                    scanner.nextLine();
                    shapes.add(new Circle(name, color, radius));
                    System.out.println("Shape added successfully!");
                } else if (choice.equals("3")) {
                    System.out.print("Enter the shape name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter its color: ");
                    String color = scanner.nextLine();
                    System.out.print("Enter the first side: ");
                    double side1 = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter the second side: ");
                    double side2 = scanner.nextDouble();
                    System.out.print("Enter the third side: ");
                    double side3 = scanner.nextDouble();
                    scanner.nextLine();
                    shapes.add(new Triangle(name, color, side1, side2, side3));
                    System.out.println("Shape added successfully!");
                } else if (choice.equals("4")) {
                    if (shapes.size() > 0) {
                        System.out.println("=====Displaying all shapes=====");
                        for (Shape s : shapes) {
                            if (s != null) {
                                System.out.println(s);
                                System.out.println("Area: " + s.area());
                                System.out.println("Perimeter: " + s.perimeter());
                                System.out.println();
                            }
                        }
                    } else {
                        System.out.println("No shapes to display!");
                    }
                } else {
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number!");
        }
    }
}
