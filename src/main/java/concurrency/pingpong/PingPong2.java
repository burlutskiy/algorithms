package concurrency.pingpong;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Phaser;

public class PingPong2 {

	static class PingPongRunnable implements Runnable {
		private final Phaser phaser;
		private final String text;
		private int phase;

		public PingPongRunnable(Phaser phaser, int phase, String text) {
			super();
			this.phaser = phaser;
			this.text = text;
			this.phase = phase;
		}

		public void run() {
			while (!Thread.interrupted()) {
				phaser.arriveAndAwaitAdvance();
				if(phaser.getPhase() % 2 == phase)
					System.out.println(text);
				phaser.arriveAndDeregister();
			}
		}

	}

	public static void main(String[] args) throws InterruptedException {
		final Phaser phaser  =  new Phaser(2);
		List<Thread> list = Arrays.asList(new Thread(new PingPongRunnable(phaser, 1, "ping")), 
				new Thread(new PingPongRunnable(phaser, 0, "pong")));
		list.stream().forEach(th -> th.start());
		Thread.sleep(1000);
		list.stream().forEach(th -> th.interrupt());
	}

}
