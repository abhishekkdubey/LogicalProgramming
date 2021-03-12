package array.onedimensionarray;

public class SingleDimensionArray {

    private int[] arr;

    //Constructor
    public SingleDimensionArray(int sizeOfArray) {
        if (sizeOfArray < 0) {
            throw new IllegalArgumentException("sizeOfArray value must be positive");
        }
        arr = new int[sizeOfArray];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }

    }


    //Print the array
    public void traverseArray() {
        try {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        } catch (Exception e) {
            System.out.println("Array no longer exists !");
        }
    }


    //Insert value in the array
    public void insert(int location, int valueToBeInserted) {
        try {
            if (arr[location] == Integer.MIN_VALUE) {
                arr[location] = valueToBeInserted;
                System.out.println("Successfully inserted " + valueToBeInserted + " at location " + location);
            } else {
                System.out.println("This cell is already occupied by another value");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array !");
//            e.printStackTrace();
        }

    }

    //Accessing particular element of an Array
    public void accessingCell(int cellNumber) {
        try {
            System.out.println(arr[cellNumber]);
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }

    //Search in an Array
    public void search(int valueToSearch) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToSearch) {
                System.out.println("Value found!");
                System.out.println("Index of " + valueToSearch + " is: " + i);
                return;
            }
        }
        System.out.println(valueToSearch + " is not found!!");
    }

    //Delete value from Array
    public void delete(int cellIndex) {
        try {
            arr[cellIndex] = Integer.MIN_VALUE;

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println();
            System.out.println("Can't delete the value as index# provided is not in the range of array !");
        }
    }

}
