package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintPaths {

        static ArrayList<ArrayList<Integer>> allPaths =
                new ArrayList<ArrayList<Integer>>();
        static void findPathsUtil(ArrayList<ArrayList<Integer>> maze,
                                  int m, int n, int i,int j,
                                  ArrayList<Integer> path,int indx)
        {

            // If we reach the bottom of maze,
            // we can only move right
            if(i == m - 1)
            {
                for(int k = j; k < n; k++)
                {
                    // path.append(maze[i][k])
                    path.set(indx + k - j, maze.get(i).get(k));

                }

                // If we hit this block, it means one
                // path is completed. Add it to paths
                // list and print
                System.out.print("[" + path.get(0) + ", ");
                for(int z = 1; z < path.size() - 1; z++)
                {
                    System.out.print(path.get(z) + ", ");
                }
                System.out.println(path.get(path.size() - 1) + "]");
                allPaths.add(path);
                return;
            }

            // If we reach to the right most
            // corner, we can only move down
            if(j == n - 1)
            {
                for(int k = i; k < m; k++)
                {
                    path.set(indx + k - i,maze.get(k).get(j));
                }

                // path.append(maze[j][k])
                // If we hit this block, it means one
                // path is completed. Add it to paths
                // list and print
                System.out.print("[" + path.get(0) + ", ");
                for(int z = 1; z < path.size() - 1; z++)
                {
                    System.out.print(path.get(z) + ", ");

                }
                System.out.println(path.get(path.size() - 1) + "]");
                allPaths.add(path);
                return;
            }

            // Add current element to the path list
            //path.append(maze[i][j])
            path.set(indx,maze.get(i).get(j));

            // Move down in y direction and call
            // findPathsUtil recursively
            findPathsUtil(maze, m, n, i + 1, j, path, indx + 1);

            // Move down in y direction and
            // call findPathsUtil recursively
            findPathsUtil(maze, m, n, i, j + 1, path, indx + 1);

        }
        static void findPaths(ArrayList<ArrayList<Integer>> maze,
                              int m, int n)
        {
            ArrayList<Integer> path = new ArrayList<Integer>();
            for(int i = 0; i < m + n - 1; i++)
            {
                path.add(0);
            }
            findPathsUtil(maze, m, n, 0, 0, path, 0);
        }

        // Driver code
        public static void main (String[] args)
        {
            ArrayList<ArrayList<Integer>> maze =
                    new ArrayList<ArrayList<Integer>>();
            maze.add(new ArrayList<Integer>
                    (Arrays.asList(1,2,3)));
            maze.add(new ArrayList<Integer>
                    (Arrays.asList(4,5,6)));
            maze.add(new ArrayList<Integer>
                    (Arrays.asList(7,8,9)));

            findPaths(maze, 3, 3);
        }
    }

// This code is contributed by avanitrachhadiya2155
