package concurrency;

public class PubChannel<E>{
	Channel<E> chan;
	public PubChannel(int limit) {
		// TODO Auto-generated constructor stub
		chan = new Channel<E>(limit);
	}

	public PubChannel(Channel<E> channel){
		this.chan = channel;
	}
	
	public synchronized void send(E item) throws InterruptedException{
		chan.send(item);
	}
}
