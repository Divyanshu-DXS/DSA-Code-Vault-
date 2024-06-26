package Sorting;
import java.util.Scanner;

// Quick Sort
/* Time Complexity : 
In worst case scenario where the array is sorted or if the pivot element selected is largest or smalles: O(n^2)
Average : O(nlogn)
*/

/* Quick Sort sorts the array by selecting a pivot element and then paritioning the array into a left partitoin  and a right partition
Left partition (  tores elements less than the pivot element's value )
Right element ( stores element that are larger in value than that of pivot element's )
Then performing swap on the pivot element within its correct position. 
*/

public class QuickSort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of the array: ");
        int size = sc.nextInt();
        System.out.println("size of the array is : " + size);
        System.out.println(" Enter the elements of the array : ");
        int []arr=new int[size];
        int j=0;
        for (int i : arr) {
            System.out.print("Element at index: "+j+" is :- ");
            i=sc.nextInt();
            arr[j]=i;
            j++;           
        }
        System.out.println("Original Array is : ");
        print(arr);
        
        System.out.println("Sorted Array is: ");
        quickSort(arr,0, size-1);
        print(arr);

        sc.close();
    }
    
    private static void quickSort(int[] arr, int lowIndex, int highIndex) {
        
        //base case
        if(lowIndex>=highIndex){
            return;
        }

        // We decide a pivot element
        int pivot = arr[highIndex];

        //setting up left-pointer(lp) and right-pointer(rp)
        int lp = lowIndex;
        int rp = highIndex-1;

        while (lp <= rp) {
            // Move lp to the right until it finds an element greater than or equal to the pivot
            while (lp <= highIndex && arr[lp] < pivot) {
                lp++;
            }
            // Move rp to the left until it finds an element less than or equal to the pivot
            while (rp >= lowIndex && arr[rp] > pivot) {
                rp--;
            }
    
            // Swap elements if lp is less than or equal to rp
            if (lp <= rp) {
                swap(arr, lp, rp);
                lp++;
                rp--;
            }
        }
        // when the above main while loop closes the lp and rp should be pointing to same locatoin 
        // this is where we swap the pivot (element at [highIndex]) value with the value at that lp location
        swap(arr, lp, highIndex);
        
        // recursively quick sorting the left partition and the right partition 
        quickSort(arr, lowIndex, lp-1);
        quickSort(arr, lp+1, highIndex);

        
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }

    public static void print(int[] arr){
        for (int i : arr) {
            System.out.print(i+ " ");
        }
        System.out.println();
    }
}
