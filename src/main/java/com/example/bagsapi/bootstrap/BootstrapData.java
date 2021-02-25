package com.example.bagsapi.bootstrap;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

import com.example.bagsapi.model.Bag;
import com.example.bagsapi.model.BagStatus;
import com.example.bagsapi.model.Ticket;
import com.example.bagsapi.model.User;
import com.example.bagsapi.repository.BagRepository;
import com.example.bagsapi.repository.TicketRepository;
import com.example.bagsapi.repository.UserRepository;

public class BootstrapData implements CommandLineRunner{

	
	private final UserRepository userRepository; 
	private final BagRepository bagRepository; 
	private final TicketRepository ticketRepository;
	
	public BootstrapData(UserRepository userRepository, BagRepository bagRepository,
			TicketRepository ticketRepository) {
		super();
		this.userRepository = userRepository;
		this.bagRepository = bagRepository;
		this.ticketRepository = ticketRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		bootData(); 
	}

	private void bootData() {
		User user1 = new User("John", "Doe","JohnDoe@Gmail.com"); 
		User user2 = new User("Ronald", "Regan","RonaldRegan@Gmail.com");
		User user3 = new User("Josh", "Peck","JoshPeck@Gmail.com");
		
		List.of(user1, user2, user3).forEach(user -> userRepository.save(user));
		
		Bag bag1 = new Bag(30,35,BagStatus.CHECKED_IN);
		Bag bag2 = new Bag(22,45,BagStatus.CHECKED_IN);
		Bag bag3 = new Bag(36,25,BagStatus.CHECKED_IN);
		Bag bag4 = new Bag(43,15,BagStatus.NOT_CHECKED_IN);
		
		List.of(bag1, bag2, bag3, bag4).forEach(bag -> bagRepository.save(bag));
		
		
		Ticket ticket1 = new Ticket(user1, List.of(bag1), "ATL", "MIA"); 
		Ticket ticket2 = new Ticket(user2, List.of(bag2, bag3), "NYC", "MON");
		Ticket ticket3 = new Ticket(user3, List.of(bag4), "ATL", "LAX");
		
		List.of(ticket1, ticket2, ticket3).forEach(ticket -> ticketRepository.save(ticket));
		
		
	}
	
	
	

}
