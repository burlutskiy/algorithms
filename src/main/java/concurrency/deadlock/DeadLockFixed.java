package concurrency.deadlock;

import java.lang.Thread.State;
import java.util.concurrent.Phaser;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Assert;
import org.junit.Test;

public class DeadLockFixed {
	
	static class Wallet {
		double balance;

		Wallet(double balance) {
			this.balance = balance;
		}

		synchronized void deposit(double amount) {
			if (amount < 0)
				throw new RuntimeException("negative amount");
			balance += amount;
		}

		synchronized void withdraw(double amount) {
			if (balance < amount)
				throw new RuntimeException("not enough balance");
			balance -= amount;
			assert balance > 0;
		}

		double balance() {
			return balance;
		}

		void pay(Wallet toWallet, double amount) {
			withdraw(amount);
			toWallet.deposit(amount);
		}
	}

	@Test
	public void testDeadLock() throws InterruptedException {
		Phaser p = new Phaser(2);
		Wallet alice = new Wallet(100);
		Wallet bob = new Wallet(20);
		Thread t1 = new Thread(() -> {
			p.arriveAndAwaitAdvance();
			alice.pay(bob, 10);
		});
		Thread t2 = new Thread(() -> {
			p.arriveAndAwaitAdvance();
			bob.pay(alice, 13);
		});
		t1.start();
		t2.start();
		t1.join(200000);
		t2.join(200000);
		Assert.assertEquals(t1.getState(), State.BLOCKED);
		Assert.assertEquals(t2.getState(), State.BLOCKED);
	}

}
