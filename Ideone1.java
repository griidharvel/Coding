/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan= new Scanner(System.in);
		String str=scan.nextLine();
		HashMap<Character, Integer> countHash = new HashMap<>();
		int n = str.length();
		for(int i=0;i<n;i++){
			int cnt = countHash.getOrDefault(str.charAt(i),0);
			countHash.put(str.charAt(i), cnt+1);
		}
		int l=0, r=0;
		HashMap<Character, Integer> windHash = new HashMap<>();
		int min=Integer.MAX_VALUE, i=0, j=n-1;
		int hSize = countHash.size();
		while(r<n){
			int cnt = windHash.getOrDefault(str.charAt(r),0);
			windHash.put(str.charAt(r), cnt+1);
			int hSize1 = windHash.size();
			if(hSize1 == hSize){
				if(min>((r-l)+1)){
					min = (r-l)+1;
					i=l;
					j=r;
				}
				while(l<r && windHash.size() == hSize){
					int cnt1 = windHash.getOrDefault(str.charAt(l),0);
					if(cnt1 == 1){
						windHash.remove(str.charAt(l));
					}else{
						windHash.put(str.charAt(l), cnt1-1);	
					}
					if(min>((r-l)+1)){
						min = (r-l)+1;
						i=l;
						j=r;
					}
					l++;
				}
			}
			r++;
		}
		System.out.println(str.substring(i,j+1));
		// your code goes here
	}
}