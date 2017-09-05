package datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AboutCalendar {

	public static void main(String[] args) {

		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.submit(new Runnable() {

			@Override
			public void run() {
				Calendar time1 = Calendar.getInstance();

				while (true) {
					System.out.printf("%1$s -> %2$s\n", Thread.currentThread().getName(), time1.getTime());
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		pool.submit(new Runnable() {

			@Override
			public void run() {
				try {
					Thread.sleep(7000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Calendar time2 = Calendar.getInstance();
				
				time2.set(2016, 3, 4);;
				System.out.printf("%1$s -> %2$s\n", Thread.currentThread().getName(), time2.getTime());			
				
			}
		});

	}

}
