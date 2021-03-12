package array.onedimensionarray;

public class SingleDimensionArrayMain {

    public static void main(String[] args) {
        SingleDimensionArray sda = new SingleDimensionArray(10);

        //Printing the array
        sda.traverseArray();


        System.out.println("Inserting the values in the array...");

        sda.insert(0, 10);
        sda.insert(1, 20);
        sda.insert(2, 30);
        sda.insert(3, 40);
        sda.insert(4, 50);
        sda.insert(5, 60);
        sda.insert(6, 70);
        sda.insert(7, 80);
        sda.insert(8, 90);
        sda.insert(9, 200);
        sda.insert(1, 100);
        sda.insert(12, 20);

        System.out.println("Accessing cell number#1...");
        sda.accessingCell(1);
        System.out.println();
        System.out.println();


        System.out.println("Searching 30 in the array ...");

        sda.search(30);

        System.out.println();
        System.out.println("Searching 400 in the array... ");

        sda.search(400);


        System.out.println();
        System.out.println("Deleting cell number#4 of array...");
        System.out.println("Before deleting");
        sda.traverseArray();
        sda.delete(4);
        System.out.println();
        System.out.println("After Deleting");
        sda.traverseArray();
        System.out.println();System.out.println();
    }

}
