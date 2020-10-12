package concurrency.pingpong;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PingPongOOP {

	public void ping() {
		System.out.println("ping");
	}

	public void pong() {
		System.out.println("pong");
	}


	abstract class PingPongRunnable implements Runnable {
		private final Object monitor;

		public PingPongRunnable(Object monitor) {
			super();
			this.monitor = monitor;
		}

		public void run() {
			while (!Thread.interrupted()) {
				synchronized (monitor) {
					try {
						play();
						monitor.notify();
						monitor.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		}
		abstract void play();
	}
	
	class Ping extends PingPongRunnable {
		final PingPongOOP pp;
		public Ping(Object monitor, PingPongOOP pp) {
			super(monitor);
			this.pp = pp;
		}

		void play() {
			pp.ping();
		}
	}

	class Pong extends PingPongRunnable {
		final PingPongOOP pp;
		public Pong(Object monitor, PingPongOOP pp) {
			super(monitor);
			this.pp = pp;
		}
		void play() {
			pp.pong();
		}
	}

	@Test
	public void test() throws InterruptedException {
		final Object obj = new Object();
		List<Thread> list = Arrays.asList(new Thread(new Ping(obj, this)), new Thread(new Pong(obj, this)));
		list.stream().forEach(th -> th.start());
		Thread.sleep(1000);
		list.stream().forEach(th -> th.interrupt());
	}

}
