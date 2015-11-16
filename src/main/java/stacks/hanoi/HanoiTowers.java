package stacks.hanoi;

import stacks.ThreeStacksBasedOnOneArray;
import stacks.ThreeStacksBasedOnOneArray.StackIndex;
import stacks.ThreeStacksBasedOnOneArray.ThreeStack;

public abstract class HanoiTowers {
	protected final int depth;
	protected final ThreeStack towers;
	protected long moves = 0;

	public HanoiTowers(int depth) {
		this.depth = depth;
		this.towers = new ThreeStacksBasedOnOneArray.ThreeStack(depth);
		for (int i = 0; i < depth; i++) {
			towers.push(StackIndex.FIRST, depth - i);
		}
	}
	
	public abstract void solve();

	public boolean isHanoiSolved() {
		return towers.isEmpty(StackIndex.FIRST) && towers.isEmpty(StackIndex.SECOND);
	}

	protected Integer towerValue(StackIndex index) {
		return towers.peek(index);
	}

	public long getMoves() {
		return moves;
	}
	
}