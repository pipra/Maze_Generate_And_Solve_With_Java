class MazeSolver{
    public boolean solve(char[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == '#' || maze[x][y] == 'X') {
            return false;
        }

        if (maze[x][y] == 'E') {
            return true; // Reached the end of the maze
        }

        maze[x][y] = 'X'; // Mark the current cell as visited

        // Try moving in all four directions (up, down, left, right)
        if (solve(maze, x - 1, y) || solve(maze, x + 1, y) || solve(maze, x, y - 1) || solve(maze, x, y + 1)) {
            return true;
        }
        // If none of the directions lead to the end, backtrack
        maze[x][y] = '.'; // Mark the current cell as part of the solution path
        return false;
    }
}