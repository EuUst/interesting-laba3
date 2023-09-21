public class Main {
    public static void main(String[] args) {
        char[][] map = {
                {'#', 's', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '.', '.', '.', '#', '.', '.', '.', 'f'},
                {'#', '.', '#', '.', '#', '.', '#', '.', '#'},
                {'#', '.', '#', '.', '.', '.', '#', '.', '#'},
                {'#', '.', '#', '#', '#', '#', '#', '.', '#'},
                {'#', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '#', '#', '#', '#', '#', '.', '.', '#'},
        };
        var a = createPath(map);

        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < a[i].length; j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    public static char[][] createPath(char[][] labirint) {
        int startRow = 0;
        int startCol = 0;
        for(int i = 0; i < labirint.length; i++) {
            for(int j = 0; j < labirint.length; j++) {
                if(labirint[i][j] == 's') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        canGo(labirint, startRow, startCol);

        return labirint;
    }

    public static boolean canGo(char[][] labirint, int row, int col) {
        if(row < 0 || row >= labirint.length || col < 0 || col >= labirint[row].length)
            return false;

        if(labirint[row][col] == 'f')
            return true;

        if(labirint[row][col] == '#' || labirint[row][col] == '*')
            return false;

        labirint[row][col] = '*';

        if(canGo(labirint, row, col - 1) ||
                canGo(labirint, row, col + 1) ||
                canGo(labirint, row - 1, col) ||
                canGo(labirint, row + 1, col))
            return true;

        labirint[row][col] = '.';

        return false;
    }
}