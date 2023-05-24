package server.unity.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import server.unity.chat.Repositories.UserRepository;
import server.unity.chat.ServiceInterface.UserService;

@SpringBootApplication
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
		Thread thread = new Thread(() -> {
			try {
				int iterations = 0;
				double timeStepMin = 0.5;
				while (true){
					Thread.sleep(Math.round(timeStepMin * 60000)); // Задержка в 10 секунд (10000 миллисекунд)
					iterations++;
					System.out.println("The server has been running for " + (iterations*timeStepMin) + " minutes...");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		thread.start();
	}

}
