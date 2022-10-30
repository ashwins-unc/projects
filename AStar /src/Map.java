import java.util.ArrayList;

public class Map {
    private int mapSize = 15;
    private ArrayList<Node> path;
    public static String UNPATHABLE = "x";
    public static String PATHABLE = "-";
    private String[][] mapPath;
    private Node[][] nodes;
    private String[][] map;

    public Map(){
        map = new String[mapSize][mapSize];
        generateMap();
        nodes = new Node[mapSize][mapSize];
        generateNodes();
        mapPath = new String[mapSize][mapSize];
    }
    public void resetPath(){
        path.clear();
    }

    public String getType(int row, int col){
        return map[row][col];
    }

    public void setElement(int row, int column, String symbol){
        map[row][column] = symbol;
    }

    private void resetPathedMap(){
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                mapPath[i][j] = map[i][j];
            }
        }
    }

    public void resetNodes(){
        nodes = new Node[mapSize][mapSize];
        generateNodes();
    }

    public void generateMap(){
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                double prob = Math.random();
                if(prob < 0.10){ map[i][j] = UNPATHABLE; }
                else{ map[i][j] = PATHABLE; }
            }
        }
    }

    private void generateNodes(){
        for(int i = 0; i < mapSize; i++){
            for(int j = 0; j < mapSize; j++){
                int type = map[i][j].equals(PATHABLE)? Node.PATHABLE : Node.UNPATHABLE;
                nodes[i][j] = new Node(i, j, type);
            }
        }
    }

    public void generatePath(int startRow, int startCol, int goalRow, int goalCol){
        AStar a = new AStar(nodes, startRow, startCol, goalRow, goalCol, mapSize);

        if(a.isPathFound()) {
            path = a.getPath();
        }
        else path = null;
    }

    public String displayPath(){
        if(path == null){
            return "No path could not be found";
        }
        else{
            String result = "";
            for(int i = path.size() - 1; i >= 0; i--){
                result += path.get(i).toString() + " ";
            }
            return result;
        }
    }

    public String toString() {
        String result = "";
        result += "\t";
        for (int i = 0; i < mapSize; i++){
            result += i + "\t";
        }
        result += "\n";
        for (int i = 0; i < mapSize; i++) {
            result += i + "\t";
            for (int j = 0; j < mapSize; j++) {
                result += map[i][j] + "\t";
            }
            result += "\n";
        }
        return result;
    }

    public String pathToString() {
        String result = "";
        result += "\t";
        for (int i = 0; i < mapSize; i++){
            result += i + "\t";
        }
        result += "\n";

        for (int i = 0; i < mapSize; i++) {
            result += i + "\t";
            for (int j = 0; j < mapSize; j++) {
                result += mapPath[i][j] + "\t";
            }
            result += "\n";
        }

        return result;
    }
    public void updateMap(){
        resetPathedMap();

        if(path != null){
            int counter = 1;

            for(int i = path.size() - 1; i >= 0; i--){
                Node next = path.get(i);
                int r = next.getRow();
                int c = next.getCol();
                mapPath[r][c] = ""+ counter;
                counter++;
            }
        }
    }

}