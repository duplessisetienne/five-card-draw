package com.duplessis.etienne.five.card.draw;

import com.duplessis.etienne.five.card.draw.model.Card;
import com.duplessis.etienne.five.card.draw.model.Deck;
import com.duplessis.etienne.five.card.draw.model.Hand;
import com.duplessis.etienne.five.card.draw.service.GameService;
import com.duplessis.etienne.five.card.draw.service.HandEvaluator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {


	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);


	}
	@Bean
	public CommandLineRunner run(GameService gameService) {
		return args -> {
			Hand hand = gameService.dealHand();
			System.out.println("Your hand: " + hand);
			System.out.println("You have: " + hand.getHandRank());
		};
	}
}
