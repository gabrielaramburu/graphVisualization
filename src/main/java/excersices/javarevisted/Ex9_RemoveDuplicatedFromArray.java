package excersices.javarevisted;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
 * removeDuplicate() which takes the array 
 * A[] and its size N as inputs and returns an array with 
 * no duplicate element present, in the same order as input.
 *
 */
public class Ex9_RemoveDuplicatedFromArray {
	public int[] removeDuplicate(int A[], int N)
    {
        Map<Integer,Integer> result = new LinkedHashMap<Integer, Integer>();
        for (int i = 0; i < N; i++) {
            result.put(A[i], A[i]);
        }
        
        return result.entrySet().stream().map(e -> e.getValue()).mapToInt(v->v).toArray();
     
    }
}
