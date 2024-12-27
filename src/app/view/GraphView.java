package app.view;

import java.util.Scanner;

public class GraphView {

    Scanner scanner = new Scanner(System.in);

    public int getMenuChoice() {
        String menu = """
                Graph Operations:
                1. Add Vertex
                2. Add Edge
                3. Remove Vertex
                4. Remove Edge
                5. Verify Vertex
                6. Verify Edge
                7. Show Graph
                8. Exit
                """;
        System.out.println(menu);
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