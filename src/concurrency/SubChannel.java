package concurrency;

public class SubChannel<E> {
	Channel<E> chan;
	public SubChannel(int limit) {
		// TODO Auto-generated constructor stub
		chan = new Channel<E>(limit);
	}
	
	public SubChannel(Channel<E> channel){
		this.chan = channel;
	}

	public synchronized E receive() throws InterruptedException{
		return chan.receive();
	}
}
