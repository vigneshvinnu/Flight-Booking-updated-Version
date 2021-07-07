import React, { Component } from "react";
import flightservice from "../flightsservices/flightservice";
import { withRouter } from "react-router-dom";
class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      filter: "",
      flights: [],
    };
  }

  componentDidMount() {
    flightservice.getFlights().then((res) => {
      this.setState({ flights: res.data });
    });
  }

  addFlights() {
    this.props.history.push("/add-flight");
    window.location.reload();
  }

  logout() {
    localStorage.removeItem("role");
  }

  render() {
    return (
      <div>
       <div className="card bg-dark w-25 p-0">
        <h2 className="text-center" style={{"color":"white","fontSize":"30px","padding":"5px"}}>FLIGHT DETAILS</h2>
        </div>
        <div className="row card">
          <table className="table table-borderless m-0 table-hover">
            <thead className="thead-dark">
              <tr>
                <th>FlightId</th>
                <th>Source</th>
                <th>Departure Date</th>
                <th>Departure Time</th>
                <th>Destination</th>
                <th>Arrival Date</th>
                <th>Arrival Time</th>
                <th>Price</th>
              </tr>
            </thead>
            <tbody className="tbody-light">
              {this.state.flights.map((flight) => (
                <tr key={flight.flightId}>
                  <td>{flight.flightId}</td>
                  <td>{flight.flightTakeOffStation}</td>
                  <td>{flight.departureDate}</td>
                  <td>{flight.departureTime}</td>
                  <td>{flight.flightLandingStation}</td>
                  <td>{flight.arrivalDate}</td>
                  <td>{flight.arrivalTime}</td>
                  <td>{flight.price}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
        <div>
        <footer className="footer">
          <span className="text-muted">All Rights Reserved 2021 @Vignesh</span>
        </footer>
        </div>
      </div>
    );
  }
}

export default withRouter(Home);
