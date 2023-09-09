import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
class MazeGenarator{
    public int coloum;
    public int row;
    public int startI;
    public int startJ;
    public char[][] maze;

    public MazeGenarator(){
        coloum = 0 ;
        row = 0 ;
    }

    public void generateMaze() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < coloum; j++) {
                maze[i][j] = '#'; // Initialize all cells as walls
            }
        }
        Random random = new Random();
        int startX = random.nextInt(coloum);
        int startY = random.nextInt(row);
        startI = startY;
        startJ = startX;
        maze[startY][startX] = 'S'; // Set the starting cell as 'S'
        List<int[]> walls = new ArrayList<>();
        walls.add(new int[] { startX, startY });
        while (!walls.isEmpty()) {
            int[] wall = walls.remove(random.nextInt(walls.size()));
            int x = wall[0];
            int y = wall[1];
            List<int[]> neighbors = new ArrayList<>();
            if (x >= 2)
                neighbors.add(new int[] { x - 2, y });
            if (x <= coloum - 3)
                neighbors.add(new int[] { x + 2, y });
            if (y >= 2)
                neighbors.add(new int[] { x, y - 2 });
            if (y <= row - 3)
                neighbors.add(new int[] { x, y + 2 });

            Collections.shuffle(neighbors);
            for (int[] neighbor : neighbors) {
                int nx = neighbor[0];
                int ny = neighbor[1];
                if (maze[ny][nx] == '#') {
                    maze[ny][nx] = '.';
                    maze[y + (ny - y) / 2][x + (nx - x) / 2] = '.';
                    walls.add(new int[] { nx, ny });
                }
            }
        }
        // Set the ending point 'E'
        int endX = random.nextInt(coloum);
        int endY = random.nextInt(row);
        maze[endY][endX] = 'E';
    }

    public void solveMaze() {
        MazeSolver mazeSolver = new MazeSolver();
        mazeSolver.solve( maze , startI , startJ );
        maze[startI][startJ] = 'S' ;
    }


}