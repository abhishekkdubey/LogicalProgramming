import com.example.tree.AVL.Node;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Test {


    public static void main(String[] args) {
//        String[] arr = new String[]{"tommy", "tom", "tomorrow"};
//        String[] arr = new String[]{"tommy", "tom", "geek", "apple"};
//        String[] arr = new String[]{ "apple", "ape", "april"};
//        String[] arr = new String[]{ "apple", "ape", ""};
//        String[] arr = new String[]{ "geeksforgeeks", "geeks", "geek", "geezer"};

//        System.out.println(new Test().binarySearch(new int[]{-1,0,3,5,9,12}, 0, 6, 9));
//        System.out.println(new Test().firstBadVersion(2126753390));
//        System.out.println(new Test().searchInsert(new int[]{1,3,5,6}, 7));
//        System.out.println(new Test().searchInsert(new int[]{1}, 2));
//        System.out.println(new Test().searchInsert(new int[]{1,3,5,6}, 2));
//        System.out.println(new Test().searchInsert(new int[]{1,3,5,6}, 0));

        System.out.println(Arrays.toString(new Test().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(new Test().sortedSquares(new int[]{-1})));
//        new Test().test();

//        Arrays.sort(arr);
//
//        System.out.println(Arrays.toString(arr));
//        String longestPrefix = arr[0];
//        boolean isPrefixAvailable = true;
//
//
//        for (int i = 1; i < arr.length; i++) {
//            boolean available = false;
//            while (!available) {
//                if (arr[i].startsWith(longestPrefix)) {
//                    available = true;
//                } else {
//                    if (longestPrefix.length() == 1) {
//                        isPrefixAvailable = false;
//                        System.out.println("Prefix Not available!!");
//                        break;
//                    }
//                    longestPrefix = longestPrefix.substring(0, longestPrefix.length() - 1);
//                }
//
//            }
//        }
//        if (isPrefixAvailable) {
//            System.out.println("Largest Prefix is " + longestPrefix);
//        }
    }


    void test(){
        int i =0;
        int sum = 0;
        while (i<100){
            sum = sum+i;
            sum = i+sum;
            i+=1;

        }
        System.out.println(sum);
    }

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            next = null;
        }
    }

    public Node deleteNode(Node root, int index) {

        if (root == null) {
            System.out.println("LinkedList is Empty");
        } else {
            int count = 0;
            Node curent = root;

            while (count < index) {
                if (curent.next != null) {
                    count++;
                    curent = curent.next;
                } else {
                    System.out.println("Given Index is not available");
                    break;
                }
            }
            if (index==0){
                return curent.next;
            }

            Node next= curent.next;
            if (next.next!=null){
                curent.next= next.next;
            }else {
                curent.next= null;
            }
            next.next=null;
        }
        return root;

    }
    //    0,  1,  2,  3,  4,  5
    //    11, 12, 13, 14, 15, 16


    /**
     * [geek, tom, tommy]
     * [tom, tommy, tomorrow]
     * [ape, apple, april]
     * [geek, geeks, geeksforgeeks, geezer]
     * [apple, geek, tom, tommy]
     *
     */


//        geek,
//        geeks,
//        geeksforgeeks,
//        geezer


    public int binarySearch(int[] arr, int start, int end, int target){
        if(start<end){
            int mid= (start+end)/2;

            if(arr[mid] == target){
                return mid;
            }else if(arr[mid]>target){
                return binarySearch(arr, start, mid-1, target);
            }else if(arr[mid]<target){
                return binarySearch(arr, mid+1, end, target);
            }
        }
        return -1;
    }


    public int firstBadVersion(int n) {

        int low=0 , high = n, mid;
        while((high-low)>1){

            mid = low/2+high/2;
            if(isBadVersion(mid)){
                high = mid;
            }else{
                low = mid;
            }
        }
        if(isBadVersion(low)){
            return low;
        }else{
            return high;
        }

    }

    boolean isBadVersion(int val){
        if (val ==1702766719) return true; else return  false;
    }



    public int searchInsert(int[] nums, int target) {

        int s=0, e=nums.length-1, m= 0;

        while(s<=e){
            m= (s+e)/2;
            if(nums[m] ==target){
                return m;
            }else if(target<nums[m]){
                e= m-1;
            }else {
                s= m+1;
            }
        }
        if(nums[m]<target){return m+1;}else{return m
                ;}




    }



    public int[] sortedSquares(int[] nums) {
        int end= nums.length-1;
        int[] negArr = new int[nums.length];
        int negArrStart= 0;
        int orgArrStart= 0;
        while(end >= 0){
            int iVal = nums[end];
            int iValSqr =   iVal*iVal;
            if(iVal>0){
                nums[end] = iValSqr;
            }else {
                if(orgArrStart==0){
                    orgArrStart= end+1;
                }
                negArr[negArrStart] = iValSqr;
                negArrStart++;

            }
            end --;
        }


        int i =0, j= orgArrStart, k=0;
        int[] result = new int[nums.length];
        while(i<negArrStart && j<nums.length){
            if(negArr[i]<nums[j]){
                result[k]= negArr[i];
                i++;
            }else{
                result[k]= nums[j];
                j++;
            }
            k++;
        }
        for(;i<negArrStart; i++){
            result[k]= negArr[i];
            k++;
        }
        for(;j<nums.length; j++){
            result[k]= nums[j];
            k++;
        }

        return result;
    }
}
