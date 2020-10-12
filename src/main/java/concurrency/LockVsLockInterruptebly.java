package concurrency;

import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

public class LockVsLockInterruptebly {
	ReentrantLock lock = new ReentrantLock();
	
	void testLockInterruptibly() {
		Thread thread = new Thread(() -> {
			int i = 0;
			System.out.println("before calling lockInterruptibly");
			try {
				lock.lockInterruptibly();
				while (0 < 1) {
					System.out.println("in the block counting: " + i++);
				}
			} catch (InterruptedException e) {
				System.out.println("block interrupted");
			}
		});
		lock.lock(); // lock first to make the lock in the thread "waiting" and then interruptible
		thread.start();
		thread.interrupt();
	}

	void testLock() {
		Thread thread = new Thread(() -> {
			int i = 0;
			System.out.println("before calling lock");
			try {
				lock.lock();
				while (0 < 1) {
					System.out.println("in the ReentrankLock block counting: " + i++);
				}
			} finally {
				System.out.println("block finished");
			}
		});
		lock.lock(); // lock first to make the lock in the thread "waiting" and then interruptible
		thread.start();
		thread.interrupt();
	}

	
	@Test
	public void test() {
		testLock();
	}

	@Test
	public void test2() {
		testLockInterruptibly();
	}
	
}
