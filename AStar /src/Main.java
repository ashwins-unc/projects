import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Map map = new Map();
        System.out.println("----------------------------------------");
        System.out.println("        generated map.        ");
        System.out.println("----------------------------------------\n");
        System.out.println(map.toString() + "\n\n");

        char nogo = 'N';
        do {
            System.out.println("----------------------------------------");
            System.out.println("     Select Start Position.  (row,col)   ");
            System.out.println("----------------------------------------");
            System.out.print("row: ");
            int startRow = scan.nextInt();
            System.out.print("column: ");
            int startColumn = scan.nextInt();

            while ((map.getType(startRow, startColumn)).equals(Map.UNPATHABLE)) {
                System.out.println("\nInvalid starting position.\n" + "Try again...");
                System.out.print("Row: ");
                startRow = scan.nextInt();
                System.out.print("Column: ");
                startColumn = scan.nextInt();
                map.setElement(startRow, startColumn, "s");
            }

            map.setElement(startRow, startColumn, "s");

            System.out.println("----------------------------------------");
            System.out.println("       Select Goal Position.  (row,col)     ");
            System.out.println("----------------------------------------");
            System.out.print("row: ");
            int goalRow = scan.nextInt();
            System.out.print("column: ");
            int goalColumn = scan.nextInt();

            while ((map.getType(goalRow, goalColumn)).equals(Map.UNPATHABLE)) {
                System.out.println("\ninvalid goal position.\n" + "Try again...");
                System.out.print("Row: ");
                goalRow = scan.nextInt();
                System.out.print("Column: ");
                goalColumn = scan.nextInt();
                map.setElement(goalRow, goalColumn, "g");
            }

            map.setElement(goalRow, goalColumn, "g");

            System.out.println("\n\n" + map.toString()); //displaying all tiles with start and goal positions


            map.generatePath(startRow, startColumn, goalRow, goalColumn);
            System.out.println("Path to goal is...\n" + map.displayPath());
            System.out.println("\n----------------------------------------");
            System.out.println("           Pathway from start to goal...         ");
            System.out.println("----------------------------------------");
            map.updateMap();
            System.out.println("\n\n" + map.pathToString());

            System.out.print("\n\nWould you like to go again?\n");
            System.out.print("Enter Y or N: ");
            nogo = scan.next().charAt(0);

            map.resetNodes();
            map.resetPath();
            map.setElement(startRow, startColumn, "-");
            map.setElement(goalRow, goalColumn, "-");

        }while(nogo == 'Y' || nogo == 'y');


        System.out.println("Finished search!");

    }
}
