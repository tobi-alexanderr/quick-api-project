package com.example.bagsapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bagsapi.model.Ticket;
import com.example.bagsapi.services.TicketService;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

	private final TicketService ticketService;

	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	} 
	
	
	@PostMapping
	public ResponseEntity<?> createTicket(@RequestBody Ticket ticket){
		ticketService.save(ticket); 
		return ResponseEntity.ok().build();
	}
	
	
	@GetMapping("/user/{id}")
	public ResponseEntity<List<Ticket>> getTicketsByUser(@PathVariable Long id){
		List<Ticket> tickets = ticketService.getTicketsByUserId(id); 
		return ResponseEntity.status(HttpStatus.OK).body(tickets); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicketByd(@PathVariable Long id){
		Ticket ticket = ticketService.getTicketById(id); 
		return ResponseEntity.status(HttpStatus.OK).body(ticket); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTicket(@PathVariable Long id){
		ticketService.deleteTicket(id); 
		return ResponseEntity.ok().build();
	}
	
	
}
