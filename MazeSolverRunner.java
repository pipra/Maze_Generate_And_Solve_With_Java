import java.util.Scanner;

public class MazeSolverRunner {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean mazeGenerated = false;
        MazeGenerator mazeGenerator = new MazeGenerator();
        System.out.println("Welcome to the Maze Solver!");
        
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Generate Maze");
            System.out.println("2. Solve Maze");
            System.out.println("3. Exit");

            System.out.print("Please select an option: ");
            int response = in.nextInt();

            switch (response) {
                case 1:
                    System.out.print("Enter the width of the maze: ");
                    int width = in.nextInt();
                    System.out.print("Enter the height of the maze: ");
                    int height = in.nextInt();

                    mazeGenerator.setHeight(height);
                    mazeGenerator.setWidth(width);
                    mazeGenerator.initializeMaze();
                    mazeGenerator.generateMaze();
                    mazeGenerated = true;

                    System.out.println("\nMaze generated:");
                    mazeGenerator.printMaze();
                    break;

                case 2:
                    if (!mazeGenerated) {
                        System.out.println("Please generate a maze first!");
                    } else {
                        mazeGenerator.solveMaze();
                        System.out.println("Solving maze...\n");
                        mazeGenerator.printMaze();
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the Maze Solver!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }

            System.out.println();
        }
    }
}