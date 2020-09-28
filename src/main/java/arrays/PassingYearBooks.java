package arrays;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PassingYearBooks {

	  void traveseAndAssignGroup(Map<Integer, Integer> groupMap, int[] arr, int studentIdx, int newGroup) {
	    int nextStudentIdx = arr[studentIdx] - 1;
	    groupMap.put(studentIdx, newGroup);  
	    while(studentIdx != nextStudentIdx) {
	        groupMap.put(nextStudentIdx, newGroup);
	        nextStudentIdx = arr[nextStudentIdx] - 1;
	    }
	  }
	  
	  int[] findSignatureCounts(int[] arr) {
	    final int n = arr.length;
	    final int[] signatures = new int[n];
	    final Map<Integer, Integer> groupMap = new HashMap<>();
	    int group = 0;
	    for(int i = 0; i < n; i++) {
	      if(groupMap.containsKey(i))
	        continue;
	      traveseAndAssignGroup(groupMap, arr, i, group++);
	    }
	    Map<Object, Long> map = groupMap.values().stream().collect(Collectors.groupingBy(v -> v, Collectors.counting()));
	    groupMap.entrySet().forEach( e -> signatures[e.getKey()] = map.get(e.getValue()).intValue() );
	    return signatures;
	  }

	  @Deprecated
	  int[] _findSignatureCounts(int[] arr) {
	    final int n = arr.length;
	    final int[] signatures = new int[n];
	    Arrays.fill(signatures, 1);
	    
	    for(int i = 0; i < n; i++) {
	      int nextStudentIdx = arr[i] - 1;
	      while(nextStudentIdx != i){
	        signatures[i]++;
	        nextStudentIdx = arr[nextStudentIdx] - 1;
	      }
	    }
	    return signatures;
	  }












	  // These are the tests we use to determine if the solution is correct.
	  // You can add your own at the bottom, but they are otherwise not editable!
	  int test_case_number = 1;
	  void check(int[] expected, int[] output) {
	    int expected_size = expected.length; 
	    int output_size = output.length; 
	    boolean result = true; 
	    if (expected_size != output_size) {
	      result = false;
	    }
	    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
	      result &= (output[i] == expected[i]);
	    }
	    char rightTick = '\u2713';
	    char wrongTick = '\u2717';
	    if (result) {
	      System.out.println(rightTick + " Test #" + test_case_number);  
	    }
	    else {
	      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
	      printIntegerArray(expected); 
	      System.out.print(" Your output: ");
	      printIntegerArray(output);
	      System.out.println();
	    }
	    test_case_number++;
	  }
	  void printIntegerArray(int[] arr) {
	    int len = arr.length; 
	    System.out.print("[");
	    for(int i = 0; i < len; i++) {
	      if (i != 0) {
	        System.out.print(", ");
	      }
	      System.out.print(arr[i]);
	    }
	    System.out.print("]");
	  }
	  
	  public void run() {
	    int[] arr_1 = {2, 1};
	    int[] expected_1 = {2, 2};
	    int[] output_1 = findSignatureCounts(arr_1);
	    check(expected_1, output_1);
	    
	    int[] arr_2 = {1, 2};
	    int[] expected_2 = {1, 1};
	    int[] output_2 = findSignatureCounts(arr_2);
	    check(expected_2, output_2);
	    check(new int[] {4,4,4,4,1}, findSignatureCounts(new int[] {4,3,1,2,5}));
	    
	    // Add your own test cases here
	    
	  }
	  
	  public static void main(String[] args) throws IOException {
	    new PassingYearBooks().run();
	  }
}
