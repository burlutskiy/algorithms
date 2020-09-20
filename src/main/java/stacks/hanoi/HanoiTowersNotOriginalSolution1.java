package stacks.hanoi;

import stacks.Stack;
import stacks.ThreeStacksBasedOnOneArray.StackIndex;

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
 * @author Alexey Burlutskiy
 *
 */
public class HanoiTowersNotOriginalSolution1 extends HanoiTowers {
	enum Direction {
		right, left;

		public Direction opposite() {
			return this == right ? left : right;
		}
	}

	class Swipe implements Comparable<Swipe> {
		Direction direction;
		StackIndex index;

		@Override
		public int compareTo(Swipe o) {
			return o.direction == Direction.right ? 1 : -1;
		}

		public Swipe(Direction direction, StackIndex index) {
			this.direction = direction;
			this.index = index;
		}

		@Override
		public String toString() {
			return "Swipe [direction=" + direction + ", index=" + index + "]";
		}
	}

	Stack<Swipe> operations;
	public HanoiTowersNotOriginalSolution1(int depth) {
		super(depth);
		this.operations = new Stack<>();
	}

	public void solve() {
		while (!isHanoiSolved()) {
			if (operations.isEmpty()) {
				if (towerValue(StackIndex.FIRST) != null)
					operations.push(new Swipe(Direction.right, StackIndex.FIRST));
				else if (towerValue(StackIndex.SECOND) != null)
					operations.push(new Swipe(Direction.right, StackIndex.SECOND));
			}
			doSwipe();
		}
	}

	private void doSwipe() {
		if (operations.peek().direction == Direction.right) {
			swipeRight();
		} else {
			swipeLeft();
		}
	}

	private void swipeLeft() {
		Swipe swipe = operations.peek();
		if (swipe.index.toTheLeft() != null) {
			if (canMoveToLeftTower(swipe)) {
				Integer value = towers.pop(swipe.index);
				towers.push(swipe.index.toTheLeft(), value);
				swipe.index = swipe.index.toTheLeft();
				moves++;
			} else {
				operations.push(new Swipe(swipe.direction.opposite(), swipe.index.toTheLeft()));
			}
		} else {
			operations.pop();
		}
	}

	private void swipeRight() {
		Swipe swipe = operations.peek();
		if (swipe.index.toTheRight() != null) {
			if (canMoveToRightTower(swipe)) {
				Integer value = towers.pop(swipe.index);
				towers.push(swipe.index.toTheRight(), value);
				swipe.index = swipe.index.toTheRight();
				moves++;
			} else {
				operations.push(new Swipe(swipe.direction.opposite(), swipe.index.toTheRight()));
			}
		} else {
			operations.pop();
		}
	}

	protected boolean canMoveToRightTower(Swipe swipe) {
		return towerValue(swipe.index.toTheRight()) == null
				|| towerValue(swipe.index) < towerValue(swipe.index.toTheRight());
	}

	protected boolean canMoveToLeftTower(Swipe swipe) {
		return towerValue(swipe.index.toTheLeft()) == null
				|| towerValue(swipe.index) < towerValue(swipe.index.toTheLeft());
	}

	@Override
	public String toString() {
		return towers.toString();
	}
}