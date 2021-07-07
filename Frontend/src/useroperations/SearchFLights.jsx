import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import { Button, Table } from "react-bootstrap";
import flightservice from "../flightsservices/flightservice";
function FlightSearch() {
  const history = useHistory();
  const [flights, setFlights] = useState([]);
  const [airportList, setAirportList] = useState([]);
  const [flightTakeOffStation, setFlightTakeOffStation] = useState("");
  const [flightLandingStation, setFlightLandingStation] = useState("");

  const [departureDate, setdepartureDate] = useState("");

  useEffect(() => {
    flightservice
      .getFlights()
      .then((response) => {
        setAirportList(response.data);
        setAirportList(response.data);
      })
      
  }, []);

  const searchFlights = async (event) => {
    event.preventDefault();

    let search = {
      flightTakeOffStation,
      flightLandingStation,
      departureDate,
    };
    const flightResp = await flightservice.getBysrcanddestanddate(search)
    setFlights(flightResp.data);
      
  };

  const selectFlight = (flightId) => {
    history.push(`/bookings/ ${flightId}`);
    window.location.reload();
  };


  return (
    <div className="container">

      <div className="row alert">
        <div className="col-lg-4 mb-5 grid-margin card" >
          <div className="cards1 bg-blue-200" style={{width:"100%"}}>
            <h2 className="card-header text-center" style={{fontWeight:"1000",fontFamily:"cursive",fontSize:"20px"}}>SEARCH FLIGHTS</h2>
            <div className="card-body">
              <form>
                <div className="form-group" style={{fontWeight:"500"}}>
                  <label> Source : </label>
                  <select
                    className="form-control"
                    name="departureAirport"
                    value={flightTakeOffStation || ""}
                    onChange={(e) => {
                      setFlightTakeOffStation(e.target.value);
                    }}
                  >
                    <option value="">-</option>
                    {airportList.map((flight) => (
                      <option
                        key={flight.flightId}
                        value={flight.flightTakeOffStation}
                      >
                        {flight.flightTakeOffStation}
                      </option>
                    ))}
                  </select>
                </div>
                <br/>

                <div className="form-group" style={{fontWeight:"500"}}>
                  <label> Destination : </label>
                  <select
                    className="form-control"
                    name="destinatonAirport"
                    value={flightLandingStation || ""}
                    onChange={(e) => {
                      setFlightLandingStation(e.target.value);
                    }}
                  >
                    <option value="">-</option>
                    {airportList.map((flight) => (
                      <option
                        key={flight.flightId}
                        value={flight.flightLandingStation}
                      >
                        {flight.flightLandingStation}
                      </option>
                    ))}
                  </select>
                </div>
<br/>
                <div className="form-group" style={{fontWeight:"500"}}>
                  <label>Date:</label>
                  <input
                    type="date"
                    name="DepartureDate"
                    className="form-control"
                    onChange={(e) => {
                      setdepartureDate(e.target.value);
                    }}
                  />
                </div>
                <br/>
                <div className="text-center">
                  <Button title="search"  className=" btn btn-block px-4 py-2 text-sm text-purple-600 font-semibold rounded-full border border-purple-200 hover:text-white hover:bg-purple-600 hover:border-transparent focus:outline-none focus:ring-2 focus:ring-purple-600 bg-orange-500  focus:ring-2
 text-white rounded "  onClick={searchFlights}>
                    Search
                  </Button>

                </div>
              </form>
            </div>
          </div>
        </div>
        {flights.length !== 0 ? (
          <div className="col-lg-8 mb-5 grid-margin">
            <div className="cards h-100">
              <h4 className="card text-center p-2" style={{fontSize:"30px",fontWeight:"500"}}>
                Available Flights from {flightTakeOffStation} to {flightLandingStation}
              </h4>
              <div className="card">
                <Table
                  striped
                  borderless
                  hover
                  
                  style={{
                    height: "300px",
                    overflow: "scroll",
                    display: "block",
                  }}

                 
                >
                  <thead className="thead-dark">
                    <tr>
                      <th>FlightId</th>
                      <th>Source</th>
                      <th>DepartureDate</th>
                      <th>DepartureTime</th>
                      <th>Destination</th>
                      <th>ArrivalDate</th>
                      <th>ArrivalTime</th>
                      <th>Price</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {flights.map((flight) => (
                      <tr key={flight.flightId}>
                        <td>{flight.flightId}</td>
                        <td>{flight.flightTakeOffStation}</td>
                        <td>{flight.departureDate}</td>
                        <td>{flight.departureTime}</td>
                        <td>{flight.flightLandingStation}</td>
                        <td>{flight.arrivalDate}</td>
                        <td>{flight.arrivalTime}</td>
                        <td>{flight.price}</td>
                        <td>
                          {" "}
                          <button
                            name="book"
                            onClick={() => selectFlight(flight.flightId)}
                            className="btn btn-info"
                          >
                            Select
                          </button>
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </Table>
              </div>
            </div>
          </div>
        ) : null}
      </div>
    </div>
  );
}

export default FlightSearch;
