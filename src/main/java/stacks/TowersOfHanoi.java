package stacks;

import org.junit.Assert;
import org.junit.Test;

import stacks.ThreeStacksBasedOnOneArray.StackIndex;
import stacks.ThreeStacksBasedOnOneArray.ThreeStack;

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
 * @author burlutal
 *
 */
public class TowersOfHanoi {

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

	class HanoiTowers {
		final int depth;
		final ThreeStack towers;
		Stack<Swipe> operations;

		public HanoiTowers(int depth) {
			this.depth = depth;
			this.operations = new Stack<>();
			this.towers = new ThreeStacksBasedOnOneArray.ThreeStack(depth);
			for (int i = 0; i < depth; i++) {
				towers.push(StackIndex.FIRST, depth - i);
			}
		}

		public boolean isHanoiSolved() {
			return towers.isEmpty(StackIndex.FIRST) && towers.isEmpty(StackIndex.SECOND);
		}

		private Integer towerValue(StackIndex index) {
			return towers.peek(index);
		}

		public void solve() {
			while (!isHanoiSolved()) {
				if(operations.isEmpty()){
					if(towerValue(StackIndex.FIRST) != null)
						operations.push(new Swipe(Direction.right, StackIndex.FIRST));
					else if(towerValue(StackIndex.SECOND) != null)
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

	@Test
	public void test() {
		HanoiTowers hanoi = new HanoiTowers(20);
		hanoi.solve();
		Assert.assertTrue(hanoi.isHanoiSolved());
	}
}
