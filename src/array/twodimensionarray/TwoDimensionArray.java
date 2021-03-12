package array.twodimensionarray;

public class TwoDimensionArray {

    private int[][] arr = null;

    //Constructor
    public TwoDimensionArray(int row, int col) {
        this.arr = new int[row][col];

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                arr[r][c] = Integer.MIN_VALUE;
            }
        }
    }


    //Traversal of Array
    public void traversal() {
        if (arr==null){
            System.out.println("Array does not exists");
            return;
        }

        System.out.println("Printing the array now:");
        try {
            for (int[] ints : arr) {
                for (int col = 0; col < ints.length; col++) {
                    System.out.print(ints[col] + " ");
                }
                System.out.println();
            }
            System.out.println("\n");

        } catch (Exception e) {
            System.out.println("Array does not exists");
        }
    }


    //Inserting a value in Array
    public void insert(int row, int col, int value) {
        if (arr==null){
            System.out.println("Array does not exists");
            return;
        }

        System.out.println("Inserting a value in Array");
        try {
            if (arr[row][col] == Integer.MIN_VALUE) {
                arr[row][col] = value;
                System.out.println("Value successfully inserted");
            } else {
                System.out.println("Given row and Column cell already occupied by another value!");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Given row & Column doesn't exists in Array!!");
        }
    }


    //Accessing value in Array

    public void access(int row, int col) {
        if (arr==null){
            System.out.println("Array does not exists");
            return;
        }
        System.out.println("Accessing Row# " + row + " Column# " + col + "...");
        try {
            System.out.println("Cell value is # " + arr[row][col]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index to access array!!");
        }
    }


    //Searching value in array
    public void search(int value) {
        System.out.println("\nSearching value " + value + "...");

        if (arr==null){
            System.out.println("Array does not exists");
            return;
        }

        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                if (arr[row][col] == value) {
                    System.out.println("Value is found at row: " + row + " column: " + col);
                    return;
                }
            }
        }
        System.out.println("Value is not found in Array\n");

    }


    //Deleting value in an array
    public void delete(int row, int col) {
        if (arr==null){
            System.out.println("Array does not exists");
            return;
        }

        System.out.println("Deleting value from row# " + row + " & column# " + col);

        try {
            arr[row][col] = Integer.MIN_VALUE;
            System.out.println("Successfully deleted :" + arr[row][col]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nCan't delete the value, As cell# provided is not in range of array!!");
        }
    }


    public void deleteThisArray() {
        if (arr==null){
            System.out.println("Array already deleted");
            return;
        }

        arr = null;
        System.out.println("Array has been successfully deleted.");
    }
}
