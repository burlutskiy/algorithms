package stacks.hanoi;

/**
 * 
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks
 * of different sizes which can slide onto any tower. The puzzle starts with
 * disks sorted in ascending order of size from top to bottom (i.e., each disk
 * sits on top of an even larger one). You have the following constraints: <br>
 * (1) Only one disk can be moved at a time. <br>
 * (2) A disk is slid off the top of one tower onto the next tower. <br>
 * (3) A disk can only be placed on top of a larger disk. <br>
 * <br>
 * Write a program to move the disks from the first tower to the last using
 * stacks.
 * 
 * This puzzle and solution differs from the original, cause it has few more constraints:<br>
 * - the disk cannot be moved from 1 to 3, only to the next one.
 * 
 * For this version of Tower of Hanoi puzzle is 3^n - 1, where n is the number of disks.
 * 
 * @author burlutal
 *
 */
public class HanoiTowersNotOriginalSolution2 extends HanoiTowersOriginal {
	public HanoiTowersNotOriginalSolution2(int depth) {
		super(depth);
	}

	@Override
	public void solve() {
		do {
			swapFirstSecond();
			swapSecondThird();
		} while (!isHanoiSolved());
	}
}
