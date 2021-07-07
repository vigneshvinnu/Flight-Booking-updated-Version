package com.Capgemini.Project.userandadminoperations.controller;

import com.Capgemini.Project.userandadminoperations.model.Flights;
import com.Capgemini.Project.userandadminoperations.service.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class FlightsController {

@Autowired
    FlightsService flightsService;

@GetMapping("/flights")
public List<Flights>  getFlightsList()
{
    return flightsService.getFlightsList();
}


@GetMapping("/flights/{flightId}")
    public ResponseEntity<?> getFlightsById(@PathVariable("flightId") String flightId)
{
    return ResponseEntity.ok(flightsService.getFlightById(flightId));
}


@DeleteMapping("/flights/{flightId}")
    public ResponseEntity<?> deleteFlight(@PathVariable("flightId") String flightId)
{
        flightsService.delete(flightId);
        return new ResponseEntity<>("Successfully deleted with id " + flightId, HttpStatus.OK);
}


@PostMapping("/flights")
    public ResponseEntity<?> saveFlightDetails(@RequestBody Flights flights)
{
         flightsService.saveOrUpdate(flights);
        return new ResponseEntity<>("Successfully Saved with Details ", HttpStatus.OK);
}

@PutMapping("/flights/{flightId}")
    public ResponseEntity<?> updateFlightDetails(@PathVariable("flightId") String flightId,@RequestBody Flights flights)
{
        flightsService.update(flightId,flights);
        return  ResponseEntity.ok("Successfully Updated with Details ");
}


}
