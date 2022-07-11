package com.harsh.flightreservation.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.harsh.flightreservation.entities.Flight;
import com.harsh.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@RequestMapping("/findFlights")
	public String findFlights(@RequestParam("from")String from,@RequestParam("to")String to,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate,
			ModelMap modelmap) {
		
		List<Flight> flights=flightRepository.findFlights(from,to,departureDate);
		modelmap.addAttribute("flights",flights);
		return "displayFlights";
	} 

	@RequestMapping("/showAddFlight")
	public String showAddFlight() {
		return "addFlight";
	}
}