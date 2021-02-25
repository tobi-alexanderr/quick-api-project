package com.example.bagsapi.services;

import java.util.List;

import com.example.bagsapi.model.Ticket;

public interface TicketService {

	List<Ticket> getTicketsByUserId(Long id);

	void save(Ticket ticket);

	Ticket getTicketById(Long id);

	void deleteTicket(Long id);

	
	
	
}
