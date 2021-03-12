package array.twodimensionarray;

public class TwoDimensionArrayMain {


    public static void main(String[] args) {

        System.out.println("Creating 2D Array of size 5*5 and initializing...");
        TwoDimensionArray tda = new TwoDimensionArray(5, 5);
        tda.traversal();


        System.out.println("Inserting 120 in row: 4, Column: 2 ...");
        System.out.println();
        tda.insert(4, 2, 230);

        System.out.println();
        System.out.println("Trying to insert value 100 in row: 10, column: 4");
        tda.insert(10, 4, 100);

        System.out.println("Inserting value in all the cells#");
        tda.insert(0, 0, 10);
        tda.insert(0, 1, 20);
        tda.insert(0, 2, 30);
        tda.insert(0, 3, 40);
        tda.insert(0, 4, 50);
        tda.insert(1, 0, 60);
        tda.insert(1, 1, 70);
        tda.insert(1, 2, 80);
        tda.insert(1, 3, 90);
        tda.insert(1, 4, 100);
        tda.insert(2, 0, 110);
        tda.insert(2, 1, 120);
        tda.insert(2, 2, 130);
        tda.insert(2, 3, 140);
        tda.insert(2, 4, 150);
        tda.insert(3, 0, 160);
        tda.insert(3, 1, 170);
        tda.insert(3, 2, 180);
        tda.insert(3, 3, 190);
        tda.insert(3, 4, 200);
        tda.insert(4, 0, 210);
        tda.insert(4, 1, 220);
        tda.insert(4, 3, 240);
        tda.insert(4, 4, 250);

        System.out.println("Printing the entire array");
        tda.traversal();

        System.out.println();
        tda.access(4, 2);


        System.out.println();
        tda.access(4, 6);

        System.out.println();
        tda.access(1, 1);

        System.out.println();
        System.out.println("Searching the value 210 in Array");
        tda.search(120);

        System.out.println();
        System.out.println("Searching the value 260 in Array");
        tda.search(260);

        System.out.println();
        System.out.println("Deleting the value from row#: 4 and Column# 3 ...");
        tda.delete(4, 3);
        tda.traversal();

        System.out.println();
        System.out.println("Deleting the value from row#: 6 and Column# 6 ...");
        tda.delete(6, 6);

        System.out.println();
        tda.deleteThisArray();

        System.out.println();
        System.out.println("Searching the value 260 in Array");
        tda.search(260);

        System.out.println();
        System.out.println("Deleting the value from row#: 4 and Column# 3 ...");
        tda.delete(4, 3);
        tda.traversal();

        System.out.println();
        System.out.println("Deleting the value from row#: 6 and Column# 6 ...");
        tda.delete(6, 6);



    }
}
