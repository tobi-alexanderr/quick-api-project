package com.example.bagsapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.bagsapi.exception.TicketNotFoundException;
import com.example.bagsapi.exception.UserNotFoundException;
import com.example.bagsapi.model.Bag;
import com.example.bagsapi.model.Ticket;
import com.example.bagsapi.model.User;
import com.example.bagsapi.repository.TicketRepository;
import com.example.bagsapi.repository.UserRepository;

@Service
public class TicketServiceImpl implements TicketService{

	private final TicketRepository ticketRepository;
	private final UserRepository userRepository; 
	
	
	public TicketServiceImpl(TicketRepository ticketRepository, UserRepository userRepository) {
		super();
		this.ticketRepository = ticketRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<Ticket> getTicketsByUserId(Long id) {
		
		User user = userRepository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id.toString()));

		
		List<Ticket> tickets = ticketRepository.findAllByUserId(user.getId());

		//If ticket is marked as deleted remove it.
		return tickets.stream()
				.filter(ticket -> !ticket.isDeleted())
				.collect(Collectors.toList());

	}

	@Override
	public void save(Ticket ticket) {
		ticketRepository.save(ticket); 
	}

	@Override
	public Ticket getTicketById(Long id) {
		Ticket ticket = ticketRepository.findById(id)
				.orElseThrow(() -> new TicketNotFoundException(id.toString()));

		if(ticket.isDeleted())
			throw new TicketNotFoundException(id.toString());

		return ticket;
	}

	@Override
	public void deleteTicket(Long id) {
		Ticket ticket = getTicketById(id); 
		ticket.setDeleted(true);
		save(ticket);
	}

}
