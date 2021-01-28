
package day02cachingfibonacci;

import java.util.ArrayList;

public class FibCached {
    
    private static ArrayList<Long> fibsCached = new ArrayList<>(); // NOT a HashMap !
    private int fibsCompCount = 2;


	FibCached() {
		fibsCached.add(0L); // #0
		fibsCached.add(1L); // #1
	}
       
        public static long getNthFib(int num) {
              return fibsCached.get(num-1);
            
        }
       
        public static long generateNFibNum(int num)
        {
            if(num >= fibsCached.size())
            {
                return getNthFib(num);
            }
   
            long fibNum = generateNFibNum(num-1) + generateNFibNum(num-2);
            fibsCached.add(fibNum);
            return fibsCached.get(num -1);
        }
    
}
