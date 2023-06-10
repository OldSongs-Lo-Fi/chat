package server.unity.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import server.unity.chat.Repositories.UserRepository;
import server.unity.chat.ServiceInterface.UserService;

@SpringBootApplication
@EnableScheduling
public class ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatApplication.class, args);
		printServerRunningTime();
	}

	private static int iterations = 0;
	private final static double timeStepMin = 0.5;

	@Scheduled(fixedDelay = 30000) // Задержка в 30 секунд (30000 миллисекунд)
	static public void printServerRunningTime() {
		System.out.println("The server has been running for " + (iterations * timeStepMin) + " minutes...");
		iterations++;
	}

}
