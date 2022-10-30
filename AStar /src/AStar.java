import java.util.ArrayList;

public class AStar {

    private int boundary;
    private boolean pathFound = false;
    private ArrayList<Node> openList;
    private ArrayList<Node> closedList;
    private ArrayList<Node> path;
    private Node[][] nodes;
    private Node start;
    private Node goal;

    public AStar(Node[][] n, int startRo, int startCol, int goalro, int goalcol, int boundary){
        this.boundary = boundary;
        nodes = n;
        openList = new ArrayList<>();
        closedList = new ArrayList<>();
        goal = nodes[goalro][goalcol];
        start = nodes[startRo][startCol];
        start.setG(0);
        start.setH(calculateHeuristic(start));
        start.setF();
        start.setParent(null);
        openList.add(start);
        Search();
    }

    private void Search(){
        Node pres;

        while(openList.size() != 0){
            pres = findLowest();
            openList.remove(pres);

            if(pres.equals(goal)){
                pathFound = true;
                generatePath();
            }

            generateNeighbors(pres);
            closedList.add(pres);
        }
    }

    public ArrayList<Node> getPath() {
        return path;
    }

    public boolean isPathFound() {
        return pathFound;
    }

    private boolean isValid(Node n){
        return withinBounds(n) && isPathable(n) &&
                !closedList.contains(n)? true : false;
    }

    private boolean withinBounds(Node n){
        int r = n.getRow();
        int c = n.getCol();

        if(r >= 0 && r < boundary && c >= 0 && c < boundary){
            return true;
        }
        return false;
    }

    private boolean isPathable(Node n){
        if(n.getType() == Node.PATHABLE) return true;
        else return false;
    }

    private Node findLowest(){
        if(openList.size() != 0) {
            Node lowest = openList.get(0);

            for (int i = 1; i < openList.size(); i++) {
                if(openList.get(i).getF() < lowest.getF()){
                    lowest = openList.get(i);
                }
            }

            return lowest;
        }

        return null;
    }
    private void generateNeighbors(Node n){
        int r = n.getRow();
        int c = n.getCol();

        for(int i = 0; i < 8; i++){
            Node check;
            try {
                switch (i) {
                    case 0:
                        check = nodes[r + 1][c];
                        break;
                    case 1:
                        check = nodes[r - 1][c];
                        break;
                    case 2:
                        check = nodes[r][c + 1];
                        break;
                    case 3:
                        check = nodes[r][c - 1];
                        break;
                    case 4:
                        check = nodes[r - 1][c + 1];
                        break;
                    case 5:
                        check = nodes[r - 1][c - 1];
                        break;
                    case 6:
                        check = nodes[r + 1][c + 1];
                        break;
                    default:
                        check = nodes[r + 1][c - 1];
                        break;
                }
            }
            catch(IndexOutOfBoundsException e){
                continue;
            }

            if(isValid(check)){

                int moveCost = n.getG();
                if(i < 4){
                    moveCost += 10;
                }
                else{
                    moveCost += 14;
                }

                if(check.getG() == 0 ||
                        (check.getG() > 0 && moveCost < check.getG())){
                    check.setG(moveCost);
                    check.setH(calculateHeuristic(check));
                    check.setF();
                    check.setParent(n);

                    if(!openList.contains(check)) {
                        openList.add(check);
                    }
                }
            }
        }
    }

    private void generatePath(){
        path = new ArrayList<>();

        Node current = goal;
        while(current.getParent() != null){
            path.add(current);
            current = current.getParent();
        }
        path.add(current);
    }

    private int calculateHeuristic(Node n){
        int curRow = n.getRow(), curCol = n.getCol();
        int heuristic = 0;
        while(curRow < goal.getRow()){
            curRow++;
            heuristic += 10;
        }
        while(curRow > goal.getRow()){
            curRow--;
            heuristic += 10;
        }
        while(curCol < goal.getCol()){
            curCol++;
            heuristic += 10;
        }
        while(curCol > goal.getCol()){
            curCol--;
            heuristic += 10;
        }
        return heuristic;
    }
}
