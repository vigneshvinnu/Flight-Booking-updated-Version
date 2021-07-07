import React, { Component } from "react";
import flightservice from "../flightsservices/flightservice";
import { withRouter } from "react-router-dom";
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';
class Listregistration extends Component {
  constructor(props) {
    super(props);
    this.Swal=new withReactContent(Swal);
    this.state = {
      filter: "",
      flights: [],
    };
    this.addFlights = this.addFlights.bind(this);
    this.editFlight = this.editFlight.bind(this);
    this.deleteFlight = this.deleteFlight.bind(this);
  }

  

  deleteFlight(flightId) {
    flightservice.deleteFlights(flightId).then(() => {
      this.setState({
        flights: this.state.flights.filter(
          
          (flight) => flight.flightId !== flightId
        ),
        
      });
      window.location.reload();
    });
  }


  editFlight(flightId) {
    this.props.history.push(`/update-flights/${flightId}`);
    window.location.reload();
  }

  componentDidMount() {
    flightservice.getFlights().then((res) => {
      this.setState({ flights: res.data });
    });
  }

  opensweetalert(flightId){
   new Swal({
      title: 'Are you sure?',
      text: 'You will not be able to recover this flight details!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'No, keep it'
    })
    .then((result) => {
      if (result.isConfirmed) {
        this.deleteFlight(flightId)
        this.props.history.push("/flights");
        
      
      } else if (result.dismiss === Swal.DismissReason.cancel) {
        this.props.history.push("/flights");
        
      }
    })
  }
  
  addFlights() {
    this.props.history.push("/add-flight");
  }

  render() {
    return (
      <div>
        <div className="card bg-dark w-25 p-0">
          <h2
            className="text-center"
            style={{ color: "white", fontSize: "30px", padding: "5px" }}
          >
            UPDATE FLIGHT
          </h2>
        </div>
        <div className="row">
          <div className="d-flex flex-wrap justify-content-around ">
            {this.state.flights.map((flight) => (
                <div
                className="card m-10 p-15 shadow-lg"
                style={{  width: "21rem"}}
                key={flight.flightId}
              >
                <div className="card-body">
                  <h5 className="card-title" style={{backgroundColor:"#fff"}}>
                    <b>{flight.flightId}</b>
                  </h5>

                  <h6 className="card-text" style={{fontWeight:"600"}}>
                    Flight Id :<b> {flight.flightId}</b>
                  </h6>
                  <h6 className="card-text" style={{fontWeight:"600"}}>
                    Source :<b> {flight.flightTakeOffStation}</b>
                  </h6>
                  <h6 className="card-text" style={{fontWeight:"600"}}>
                    Departure Date :<b> {flight.departureDate}</b>
                  </h6>
                  <h6 className="card-text" style={{fontWeight:"600"}}>
                    Departure Date : <b>{flight.departureTime}</b>
                  </h6>
                  <h6 className="card-text" style={{fontWeight:"600"}}> 
                    Destination : <b>{flight.flightLandingStation}</b>
                  </h6>
                  <h6 className="card-text" style={{fontWeight:"600"}}>
                    Arrival Date : <b>{flight.arrivalDate}</b>
                  </h6>
                  <h6 className="card-text" style={{fontWeight:"600"}}>
                    Arrival Time : <b>{flight.arrivalTime}</b>
                  </h6>
                  <h6 className="card-text pb-2" style={{fontWeight:"600"}}>
                    Price : <b>{flight.price}</b>
                  </h6>

                  <button
                  className="btn btn-info"
                   onClick={() => this.editFlight(flight.flightId)}><b>
                    <i class="fa fa-edit"> </i>
                       Update
                    </b>{" "}
                  </button>
                
                  <button
                    style={{ marginLeft: "10px" }}
                    onClick={() =>  this.opensweetalert(flight.flightId)}
                    className="btn btn-danger delete button"
                  ><i class="fa fa-trash"> </i>
                    <b>Delete </b>
                  </button>
                  </div>
              </div>
            ))}
            
              {/* </div>
            ))} */}
          </div>
        </div>
      </div>
    );
  }
}
export default withRouter(Listregistration);
