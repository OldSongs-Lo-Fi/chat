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
				while (true){
					Thread.sleep(10000); // Задержка в 10 секунд (10000 миллисекунд)
					System.out.println("Dinara are the best!");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});

		thread.start();
	}

}
