
public class ThreadPigeon extends Thread {

	

		public ThreadPigeon() {
		}

		public ThreadPigeon(String name) {
			super(name);

		}

		public ThreadPigeon(ThreadGroup group, Runnable target) {
			super(group, target);

		}

		public ThreadPigeon(ThreadGroup group, String name) {
			super(group, name);

		}

		public ThreadPigeon(Runnable target, String name) {
			super(target, name);

		}

		public ThreadPigeon(ThreadGroup group, Runnable target, String name) {
			super(group, target, name);

		}

		public ThreadPigeon(ThreadGroup group, Runnable target, String name, long stackSize) {
			super(group, target, name, stackSize);

		}

		@Override
		public void run() {
			super.run();
			while (true) {
				Pigeon.game();
			}
		}

	
}
