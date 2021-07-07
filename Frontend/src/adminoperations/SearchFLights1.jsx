import React, { useState, useEffect } from "react";
import { Button ,Table} from "react-bootstrap";
import flightservice from "../flightsservices/flightservice";

function SearchFLights1() {
  const [flights, setFlights] = useState([]);
  const [airportList, setAirportList] = useState([]);
  const [flightTakeOffStation, setFlightTakeOffStation] = useState("");


  useEffect(() => {
    flightservice
      .getFlights()
      .then((response) => {
        setAirportList(response.data);
        setAirportList(response.data);
        console.log(response.data);
      })
      .catch((error) => console.error(`Error :  ${error}`));
  }, []);

  const searchFlights = async (event) => {
    event.preventDefault();

    let search = {
      flightTakeOffStation,
    };
    const flightResp = await flightservice.getByTakeoff(search);
    console.log(flightResp);
    setFlights(flightResp.data);
  };

  return (
    <div className="container">
      
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
                <div className="text-center">
                  <Button title="search"  className=" btn btn-block px-4 py-2 text-sm text-purple-600 font-semibold rounded-full border border-purple-200 hover:text-white hover:bg-purple-600 hover:border-transparent focus:outline-none focus:ring-2 focus:ring-purple-600 bg-orange-500  focus:ring-2
 text-white rounded "  onClick={searchFlights}>
                    Search
                  </Button>

                </div>



                </form>

                {flights.length !== 0 ? (
          <div className="col-lg-9 mb-5 grid-margin">
            <div className="card10 h-100">
              <div className="">
                <Table
                  striped
                  borderless
                  hover
                  
                  style={{
                    height: "350px",
                    overflow: "scroll",
                    display: "block",
                    width:"850px",
                    
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
                        {/* <td>
                          {" "}
                          <button
                            name="book"
                            onClick={() => selectFlight(flight.flightId)}
                            className="btn btn-info"
                          >
                            Select
                          </button>
                        </td> */}
                      </tr>
                    ))}
                  </tbody>
                </Table>
              </div>
            </div>
          </div>
        ) : null}
      </div>  );
}

export default SearchFLights1;
