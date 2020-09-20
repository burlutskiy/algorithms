package stacks.hanoi;

import stacks.ThreeStacksBasedOnOneArray.StackIndex;

/**
 * The Tower of Hanoi (also called the Tower of Brahma or Lucas' Tower,[1] and
 * sometimes pluralized) is a mathematical game or puzzle. It consists of three
 * rods, and a number of disks of different sizes which can slide onto any rod.
 * The puzzle starts with the disks in a neat stack in ascending order of size
 * on one rod, the smallest at the top, thus making a conical shape.<br>
 * 
 * The objective of the puzzle is to move the entire stack to another rod,
 * obeying the following simple rules:<br>
 * 
 * Only one disk can be moved at a time.<br>
 * Each move consists of taking the upper disk from one of the stacks and
 * placing it on top of another stack i.e. a disk can only be moved if it is the
 * uppermost disk on a stack. <br>
 * No disk may be placed on top of a smaller disk. With three disks, the puzzle
 * can be solved in seven moves. The minimum number of moves required to solve a
 * Tower of Hanoi puzzle is 2^n - 1, where n is the number of disks.
 * 
 * https://en.wikipedia.org/wiki/Tower_of_Hanoi
 * 
 * @author Alexey Burlutskiy
 */
public class HanoiTowersOriginal extends HanoiTowers {
	public HanoiTowersOriginal(int depth) {
		super(depth);
	}

	@Override
	public void solve() {
		do {
			if (depth % 2 == 0) {
				swapFirstSecond();
				swapFirstThird();
				swapSecondThird();
			} else {
				swapFirstThird();
				swapFirstSecond();
				swapSecondThird();
			}
		} while (!isHanoiSolved());
	}

	protected void swapFirstSecond() {
		if (!isHanoiSolved())
			swap(StackIndex.FIRST, StackIndex.SECOND);
	}

	protected void swapFirstThird() {
		if (!isHanoiSolved())
			swap(StackIndex.FIRST, StackIndex.THIRD);
	}

	protected void swapSecondThird() {
		if (!isHanoiSolved())
			swap(StackIndex.SECOND, StackIndex.THIRD);
	}

	private void swap(StackIndex one, StackIndex two) {
		Integer v1 = towerValue(one);
		Integer v2 = towerValue(two);
		if (v2 != null && v1 != null) {
			if (v2 > v1) {
				move(one, two);
			} else {
				move(two, one);
			}
		} else if (v2 == null) {
			move(one, two);
		} else {
			move(two, one);
		}
	}

	private void move(StackIndex from, StackIndex to) {
		Integer value = towers.pop(from);
		towers.push(to, value);
		moves++;
	}

}
