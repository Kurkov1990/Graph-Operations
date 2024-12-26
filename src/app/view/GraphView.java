package app.view;

import java.util.Scanner;

public class GraphView {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        System.out.println("\nGraph Operations:");
        System.out.println("1. Add Vertex");
        System.out.println("2. Add Edge");
        System.out.println("3. Remove Vertex");
        System.out.println("4. Remove Edge");
        System.out.println("5. Verify Vertex");
        System.out.println("6. Verify Edge");
        System.out.println("7. Show Graph");
        System.out.println("8. Exit");
        System.out.print("\nChoose an option to Continue: ");
        return scanner.nextInt();
    }

    public int getVertexInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showResult(String result) {
        System.out.println(result);
    }
}