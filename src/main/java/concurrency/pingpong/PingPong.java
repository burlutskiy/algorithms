package concurrency.pingpong;

import java.util.Arrays;
import java.util.List;

public class PingPong {

	static class PingPongRunnable implements Runnable {
		private final Object monitor;
		private final String text;

		public PingPongRunnable(Object monitor, String text) {
			super();
			this.monitor = monitor;
			this.text = text;
		}

		public void run() {
			while (!Thread.interrupted()) {
				synchronized (monitor) {
					try {
						System.out.println(text);
						monitor.notify();
						monitor.wait();
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
					}
				}
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		final Object obj = new Object();
		List<Thread> list = Arrays.asList(new Thread(new PingPongRunnable(obj, "ping")), new Thread(new PingPongRunnable(obj, "pong")));
		list.stream().forEach(th -> th.start());
		Thread.sleep(1000);
		list.stream().forEach(th -> th.interrupt());
	}

}
