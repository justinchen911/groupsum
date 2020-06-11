/**
 * 
 */
package hsbc.GroupSum;


/**
 * @author jiaxin
 *
 */
public class GroupSum {
	
	/**
	 * additional constraint: all 7's must be chosen.
	 */
	private static Integer MANDATORY_7_IF_PRESENT = 7;
	private static Integer DEFAULT_START_INDEX_ZERO = 0;
	
	/**
	 * add up every element from the array to see if condition was meet
	 * @param integers
	 * @param startIndex
	 * @param target
	 * @return
	 */
	private static boolean groupSum(int[] integers, Integer startIndex, Integer target) {
		// check if satified at the end of the array
		if (startIndex >= integers.length) 
			return (target == 0);
		
		if (integers[startIndex] == MANDATORY_7_IF_PRESENT) {
			if (groupSum(integers, startIndex + 1, target - integers[startIndex])) 
				return true;
		} else {
			if (groupSum(integers, startIndex + 1, target - integers[startIndex])) 
				return true;
			// skip current element
			if (groupSum(integers, startIndex + 1, target)) 
				return true;
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		int[] integers1 = {5,7,4};
		int[] integers2 = {3,7,1};
		int[] integers3 = {5,7,2};
		int[] integers4 = {};
		System.out.println(String.format("groupSum({5,7,4}, 0, 11) --> %s", groupSum(integers1, DEFAULT_START_INDEX_ZERO, 11)));
		System.out.println(String.format("groupSum({3,7,1}, 0, 4) --> %s", groupSum(integers2, DEFAULT_START_INDEX_ZERO, 4)));
		System.out.println(String.format("groupSum({5,7,2}, 0, 7) --> %s", groupSum(integers3, DEFAULT_START_INDEX_ZERO, 7)));
		System.out.println(String.format("groupSum({}, 0, 0) --> %s", groupSum(integers4, DEFAULT_START_INDEX_ZERO, 0)));
	}
	
}
