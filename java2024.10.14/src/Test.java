import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
//        char[][] array = {{'1','1','0','0','0'},{'0','1','0','1','1'},{'0','0','0','1','1'},{'0','0','0','0','0'},{'0','0','1','1','1'}};
//        System.out.println(solve(array));

//        int[] array = {7,6,5,4,3,2,1};
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//        int[] array = {999999999, 999999999, 999999999, 999999999, 999999999, 1};
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(Long.MAX_VALUE);
    }
    public static int solve (char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        return gridSum(grid,visited);
    }
    public static int gridSum(char[][] grid,boolean[][] visited){
        int ret = 0;
        for(int i = 0;i<grid.length;i++){
            for(int k = 0;k<grid[0].length;k++){
                if(grid[i][k]=='1'&&visited[i][k]==false){
                    printGrid(grid,visited,i,k);
                    ret++;
                }
            }
        }
        return ret;
    }
    public static void printGrid(char[][] grid,boolean[][] visited,int i,int k){
        int m = grid.length;
        int n = grid[0].length;
        if(i<0||i>=m||k<0||k>=n) return;
        if(grid[i][k]=='0'||visited[i][k]==true) return;


        visited[i][k] = true;
        printGrid(grid,visited,i-1,k);
        printGrid(grid,visited,i+1,k);
        printGrid(grid,visited,i,k-1);
        printGrid(grid,visited,i,k+1);
    }
}
