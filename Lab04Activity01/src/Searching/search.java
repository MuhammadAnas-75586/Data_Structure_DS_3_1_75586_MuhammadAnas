/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Searching;
import java.util.Scanner;
public class search {
    public static int linearSearch(int[] arr, int target)
    {
        for(int i = 0;i < arr.length;i++){
            if(arr[i]==target)
                return i;
        }
        return -1;
    }
    public static int binarySearch(int[]arr ,int l,int r,int target){
        if(l<=r){
            int mid = l+(r-l)/2;

            if(target==arr[mid])
            {
                return mid;
            }
            else if(target>arr[mid]){
                return binarySearch(arr,mid+1,r,target);          
            }
            else
            {
                return binarySearch(arr,l,mid-1,target);
            }
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the target you want to search: ");
        int[] LinearArray={45, 12, 78, 34, 23, 89, 56};
        int[] BinaryArray={12, 23, 34, 45, 56, 78, 89};
        
        int x = sc.nextInt();
        int resultBinary=binarySearch(BinaryArray,0,BinaryArray.length-1,x);
        int resultLinear=linearSearch(LinearArray,x);
        System.out.println("Result of Linear Search: Index: "+resultLinear);
        System.out.println("Result of Binary Search: Index: "+resultBinary);
    }   
}