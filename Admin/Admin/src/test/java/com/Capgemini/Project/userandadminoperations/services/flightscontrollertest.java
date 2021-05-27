package com.Capgemini.Project.userandadminoperations.services;

import com.Capgemini.Project.userandadminoperations.AdminApplication;
import com.Capgemini.Project.userandadminoperations.Repository.FlightsRepository;
import com.Capgemini.Project.userandadminoperations.model.Flights;
import com.Capgemini.Project.userandadminoperations.service.UserService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AdminApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class flightscontrollertest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private FlightsRepository flightsRepository;

    @Autowired
    private UserService userService;


    @LocalServerPort
    private int port;

    private String getRootUrl() {
        return "http://localhost:" + port;
    }

    @Test
    public void contextLoads() {

    }

    @Test
    @After
    public void Successful()
    {
        System.out.println("Successfully tested");
    }

    @Test
    @Before
    public void testSaveFlightDetails() {

        Flights flights = new Flights("CE6258", "Hyderabad",  "2021-05-16",
                "20:39","Delhi", "2021-05-17","21:40",10);
        Flights flights1 = flightsRepository.save(flights);
        assertNotNull(flights1);
    }

    @Test
    public void testGetAllFlights() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/admin/flights",
                HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetFlightsByFlightLandingStation() {
        List<Flights> flights = userService.getFlightlandingstation("Delhi");
        assertNotNull(flights);
    }

    @Test
    public void testGetFlightsByFlightTakeOffStation() {
        String fn="Hyderabad";
        List<Flights> flights = userService.getFlighttakeoffstation(fn);
        assertNotNull(flights);
    }

    @Test
    public void testGetsrcdest() {
        List<Flights> flights =userService.getFLighttakeoffandlandingStation
                ("Hyderabad","Delhi","2021-05-16");
        assertNotNull(flights);
    }


    @Test
    public void testGetFlightsById() {
        Flights flights = restTemplate.getForObject(getRootUrl() + "/admin/flights/CE6258", Flights.class);
        assertNotNull(flights);
    }

    @Test
    public void testUpdateFlight(){
        String flightId = "CE6258";
        Flights flights = restTemplate.getForObject(getRootUrl() + "/admin/flights/" + flightId, Flights.class);
        flights.setFlightLandingStation("Chandigarh");
        restTemplate.put(getRootUrl() + "/admin/flights/" + flightId, flights);
        Flights updatedDetails = restTemplate.getForObject(getRootUrl() + "/admin/flights/" + flightId, Flights.class);
        assertNotNull(updatedDetails);
    }

    @Test
    public void testDeleteFlight() {
        String id = "CE6258";
        Flights flights = restTemplate.getForObject(getRootUrl() + "/admin/flights/" + id, Flights.class);
        assertNotNull(flights);
        restTemplate.delete(getRootUrl() + "/admin/flights/" + id);

    }
}


