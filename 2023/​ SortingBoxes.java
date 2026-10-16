/*
​ SORTING BOXES

Little Jill jumbled up the order of the letters in our dictionary. Now, Jack uses this list to find the smallest lexicographical string that can be made out of this new order. Can you help him? You are given a string P that denotes the new order of letters in the English dictionary. You need to print the smallest lexicographic string made from the given string S.
​
Input Format
    • The first line contains an integer T, representing the number of test cases. 
    • For each test case: 
        ◦ The first line contains the string P (the custom alphabet order). 
        ◦ The second line contains the string S (the string to be reordered). 
​
Output Format
Print a single string in a new line for every test case giving the result
​
Constraints
    • 1≤T≤1000 
    • Length (P)=26 
    • 1≤ length (S)≤100 

Input
2
polikujmnhytgbvfredcxswqaz
abcd
qwryupcsfoghjkldezxvbintma
ativedoc

Output
bdca
codevita

*/
//Solution

import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String p = sc.next();
            String s = sc.next();
            StringBuilder result = new StringBuilder();
            int freq[] = new int[26];
            for(int i=0; i<s.length(); i++)
            {
                freq[s.charAt(i)-'a']++;
            }
            for(int i=0; i<p.length(); i++)
            {
                char ch = p.charAt(i);
                int x = freq[ch -'a'];
                while(x>0)
                {
                    result.append(ch);
                    x--;
                }
            }
            System.out.println(result.toString());
            
        }
    }
}


