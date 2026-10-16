/*
​ PRIME TIME AGAIN

Here on earth, our 24−hour day is composed of two parts, each of 12 hours. Each hour in each part has a corresponding hour in the other part separated by 12 hours: the hour essentially measures the duration since the start of the daypart. For example, 1 hour in the first part of the day is equivalent to 13, which is 1 hour into the second part of the day. Now, consider the equivalent hours that are both prime numbers. We have 3 such instances for a 24−hour 2−part day:

Examples:
- 5 17
- 7 19
- 11 23

Accept two natural numbers D, P >1 corresponding respectively to several hours per day and the number of parts in a day separated by a space. D should be divisible by P, meaning that the number of hours per part (D/P) should be a natural number. Calculate the number of instances of equivalent prime hours. Output zero if there is no such instance. Note that we require each equivalent hour in each part of a day to be a prime number.
​
 Input Format
The single line consists of two space-separated integers, D and P corresponding to the number of hours per day and number of parts in a day respectively
​
 Output Format
Output must be a single number, corresponding to the number of instances of equivalent prime number, as described above
​
 Constraints
    • 10 ≤ D < 500 
    • 2 ≤ P < 50 

Input 
36 3

Output 
2

​ Explanation:
In the given test case D = 36 and P = 3
Duration of each daypart = 12
2 14 X
3 15 X
5 17 29 - an instance of equivalent prime hours
7 19 31 - an instance of equivalent prime hours
11 23 X
Hence the answer is 2.
*/

//Solution
import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
    public static boolean isPrime(int n)
    {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws java.lang.Exception
    {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int p = sc.nextInt();
        int part = d / p;

        int count = 0;
        for (int i = 2; i <= part; i++)
        {
            boolean flag = true;
            for (int j = 0; j < p; j++)
            {
                int k = i + j * part;
                if (isPrime(k))
                    continue;
                else
                {
                    flag = false;
                    break;
                }
            }
            if (flag)
                count++;
        }
        System.out.println(count);
    }
}
