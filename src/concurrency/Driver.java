package concurrency;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Channel<String> mychan = new Channel();
		final SubChannel<String> schan = new SubChannel<String>(mychan);
		final PubChannel<String> pchan = new PubChannel<String>(mychan);
		
		Thread ping = new Thread(){
			int x = 1;
			public void run(){
				while(true){
					try {
						pchan.send("Ping : " + x++);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
				
			}
		};
		
		Thread pong1 = new Thread(){
			String msg;
			public void run(){
				while(true){
					try {
						msg = schan.receive();
						System.out.println(msg + " pong1");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
		};

		Thread pong2 = new Thread(){
			String msg;
			public void run(){
				while(true){
					try {
						msg = schan.receive();
						System.out.println(msg + " pong2");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				}
			}
		};
		ping.start();
		pong1.start();
		pong2.start();
		
		
	}

}
