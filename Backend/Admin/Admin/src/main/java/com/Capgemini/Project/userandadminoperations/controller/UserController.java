package com.Capgemini.Project.userandadminoperations.controller;

import com.Capgemini.Project.userandadminoperations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/flights")
    public Object getFlightsList()
    {
        return userService.getFlightsList();

    }

    @GetMapping("/flights/land/{flightLandingStation}")
    public ResponseEntity<?> getFlightsLanding(@PathVariable("flightLandingStation") String flightLandingStation)
    {
        return ResponseEntity.ok(userService.getFlightlandingstation(flightLandingStation));

    }

    @GetMapping("/flights/takeoff/{flightTakeOffStation}")
    public ResponseEntity<?> getTakeOff(@PathVariable("flightTakeOffStation") String flightTakeOffStation)
    {
            return ResponseEntity.ok(userService.getFlighttakeoffstation(flightTakeOffStation));
    }

    @GetMapping("/flights/src/{flightTakeOffStation}/{flightLandingStation}/{departureDate}")
    public ResponseEntity<?> getsrcdest(@PathVariable String flightTakeOffStation,
                                         @PathVariable String flightLandingStation,
                                         @PathVariable String departureDate)
    {
        return ResponseEntity.ok(userService.getFLighttakeoffandlandingStation(flightTakeOffStation,flightLandingStation,departureDate));
    }

}
