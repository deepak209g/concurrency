package concurrency;

import java.util.LinkedList;
import java.util.List;

public class Channel<E>{
	private List<E> queue = new LinkedList<E>();
	  private int  limit = 1;

	  public Channel(int limit){
	    this.limit = limit;
	  }


	  public Channel(){
	    this.limit = 1;
	  }

	  public synchronized void send(E item)
	  throws InterruptedException  {
	    while(this.queue.size() == this.limit) {
	      wait();
	    }
	    if(this.queue.size() == 0) {
	      notifyAll();
	    }
	    this.queue.add(item);
	  }


	  public synchronized E receive()
	  throws InterruptedException{
	    while(this.queue.size() == 0){
	      wait();
	    }
	    if(this.queue.size() == this.limit){
	      notifyAll();
	    }

	    return this.queue.remove(0);
	  }
}
