//circular array implementation
//imput size  = 5 and elements = 1,2,3,4,5,6,7,8,9,10
//output  = 6,7,8,9,10
import java.util.Scanner;
public class CircularArray {
    public static void main(String[] args){
        int[] arr = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter elements:");
        int n = sc.nextInt();
        for(int  i = 0;i<n;i++){
            arr[(i+1)%5] = sc.nextInt();
        }
        for(int i = 0;i<5;i++){
            System.out.print(arr[(i+1)%5] + " ");
        }
    }
}
