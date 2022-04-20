public class Solution {

    //***SOLUTION 1
    public static void swap(int x, int y){
        System.out.println("x before: " + x);
        System.out.println("y before: " + y);

        //NOTE: i'm aware of the possibility of integer overflow,
        //but due to how java evaluates, this will work even when that happens
        x += y;
        y = x - y;
        x -= y;

        System.out.println("x after: " + x);
        System.out.println("y after: " + y);
    }

    //***SOLUTION 2
    //rotates array idx position in place
    //general algorithm is reverse entire array, then reverse two different sides depending on idx
    public static char[] rotateArrayToTheLeft(char[] arr, int idx){
        System.out.println("before rotation: " + new String(arr));

        if(idx != 0)    idx--;  //need to do this since example in email is 1 indexed

        int rotate = idx % arr.length;  //chops rotate to less than arr length
        rotate = arr.length - rotate;   //allows us to use right rotation logic

        reverseArrInRange(arr, 0, arr.length -1);
        reverseArrInRange(arr, 0, rotate - 1);
        reverseArrInRange(arr, rotate, arr.length - 1);

        System.out.println("after rotation:  " + new String(arr));
        return arr;
    }


    //reverse array arr from indices [l,r]
    public static void reverseArrInRange(char[] arr, int l, int r){
        while(l < r){
            char temp = arr[l];

            arr[l] = arr[r];
            arr[r] = temp;

            l++;
            r--;
        }
    }

    //using main method for mini tests, multiline comments indicate output
    public static  void main(String args[]){
        //basic show of solution
        swap(1,5);
        /*
        x before: 1
        y before: 5
        x after: 5
        y after: 1
        */

        //show that this works w/ overflow
        swap(123456, Integer.MAX_VALUE);
        /*
        x before: 123456
        y before: 2147483647
        x after: 2147483647
        y after: 123456
         */

        String testStr = "TheQuickBrownFoxJumpedOverTheLazyDog";
        char[] testArr = testStr.toCharArray();

        rotateArrayToTheLeft(testArr, 16);
        /*
        before rotation: TheQuickBrownFoxJumpedOverTheLazyDog
        after rotation:  xJumpedOverTheLazyDogTheQuickBrownFo
         */



    }
}
