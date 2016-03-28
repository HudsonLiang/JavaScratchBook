package roadrotation.service;

import java.util.Arrays;

import roadrotation.service.impl.QueryServiceEnum;

public class Client {

	public static void main(String... args) throws InterruptedException {
		Query service = QueryServiceEnum.INSTANCE;
		while(true){

			Arrays.stream(service.whatNow())
			.forEach(n -> System.out.print(n + " "));

			Thread.sleep(20000);
		}

	}

}
