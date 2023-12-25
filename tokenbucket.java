/*Token Bucket for congestion control*/

/* In this the bucket is filled with constant rate called token_generation_rate untill the bucket is full */
//saad-->
import java.util.Scanner;
import java.util.*;

public class tokenbucket{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int token_remaining=0;//total tokens in the bucket
        int token_requested,token_sent;
        System.out.println("Enter the bucket capacity");
        int bucket_capacity=in.nextInt();
        System.out.println("Enter the Token generation rate (Rate at which tokens are sent to the bucket)");
        int token_gen_rate=in.nextInt();
        System.out.println("Enter the number of Cycles the host computer sends the Tokens to the bucket(at constant rate)");
        int n=in.nextInt();
        System.out.println(String.format("%s\t%s\t%s\t%s", "TimeΔt", "Tokens Requested", "Tokens Sent", "Tokens Remaining in bucket"));
        for(int i=0;i<n;i++){
            token_requested=token_gen_rate;
            if(token_requested+token_remaining>bucket_capacity){
                token_sent=bucket_capacity-token_remaining;
                token_remaining=bucket_capacity;
            }
            else{
                token_sent=token_requested;
                token_remaining+=token_requested;
            }
            System.out.println(String.format("%d\t%d\t%d\t%d", i + 1, token_requested, token_sent, token_remaining));
        }
    }
}

/*OUTPUT:-
Enter the bucket capacity
5
Enter the Token generation rate (Rate at which tokens are sent to the bucket)
2
Enter the number of Cycles the host computer sends the Tokens to the bucket(at constant rate)
6
TimeΔt  Tokens Requested    Tokens Sent   Tokens Remaining in bucket
1             2                    2       2
2             2                    2       4
3             2                    1       5
4             2                    0       5
5             2                    0       5
6             2                    0       5
*/    

/*OUTPUT:-
Enter the bucket capacity
5
Enter the Token generation rate (Rate at which tokens are sent to the bucket)
2
Enter the number of Cycles the host computer sends the Tokens to the bucket(at constant rate)
6
TimeΔt  Tokens Requested    Tokens Sent   Tokens Remaining in bucket
1             2                    2       2
2             2                    2       4
3             2                    1       5
4             2                    0       5
5             2                    0       5
6             2                    0       5
*/







//abhi-->
// import java.util.Scanner;

// public class tokenbucket {
//     public static void main(String[] args) {
//         int tokens = 0; // initial number of tokens in the bucket
//         int rate = 10; // rate at which tokens are added to the bucket
//         int capacity;// maximum number of tokens the bucket can hold

//         int[] request = new int[100];

//         Scanner scanner = new Scanner(System.in);
//         System.out.println("ENTER THE BUCKET SIZE");
//         capacity = scanner.nextInt();

//         System.out.print("Enter number of requests: ");
//         int n = scanner.nextInt();

//         System.out.print("Enter no. of packets per request: ");
//         for (int i = 0; i < n; i++) {
//             request[i] = scanner.nextInt();
//         }

//         for (int i = 0; i < n; i++) {
//             // add tokens to the bucket at a fixed rate
//             tokens = Math.min(tokens + rate, capacity);

//             /*
//              * try IF U WANT U CAN ADD JUST TO SHOW PACKET MOVING TIME
//              * {
//              * // wait for 1 second
//              * Thread.sleep(1000);
//              * } catch (InterruptedException e) {
//              * e.printStackTrace();
//              * }
//              */
//             System.out.println("Number of packets" + request[i]);
//             if (tokens >= request[i]) {
//                 // remove the requested tokens from the bucket
//                 tokens -= request[i];
//                 System.out.println("Request granted, tokens remaining: " + tokens);
//             } else {
//                 System.out.println("Request denied, not enough tokens: " + tokens);
//             }
//         }

//         scanner.close();
//     }
// }
