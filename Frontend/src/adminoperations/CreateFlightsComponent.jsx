import React, { Component } from "react";
import flightservice from "../flightsservices/flightservice";
import { withRouter } from "react-router-dom";
import SimpleReactValidator from 'simple-react-validator';
import swal from 'sweetalert';
class CreateFlightsComponent extends Component {
  constructor(props) {
    super(props);
    this.validator = new SimpleReactValidator();
    this.state = {
      flightId: this.props.match.params.flightId,
      flightTakeOffStation: "",
      departureDate: "",
      departureTime: "",
      flightLandingStation: "",
      arrivalDate: "",
      arrivalTime: "",
      price: "",
      errors: {
        flightId: "",
        flightTakeOffStation: "",
        flightLandingStation: "",
        price: "",
      },
    };
    this.changeflightIdHandler = this.changeflightIdHandler.bind(this);
    this.changeflightTakeOffStationHandler = this.changeflightTakeOffStationHandler.bind(
      this
    );
    this.changedepartureDateHandler = this.changedepartureDateHandler.bind(
      this
    );
    this.changedepartureTimeHandler = this.changedepartureTimeHandler.bind(
      this
    );
    this.changeflightLandingStationHandler = this.changeflightLandingStationHandler.bind(
      this
    );
    this.changearrivalDateHandler = this.changearrivalDateHandler.bind(this);
    this.changearrivalTimeHandler = this.changearrivalTimeHandler.bind(this);
    this.changepriceHandler = this.changepriceHandler.bind(this);
    this.saveFlight = this.saveFlight.bind(this);
  }

  saveFlight = (e) => {
    e.preventDefault();
    let flights = {
      flightId: this.state.flightId,
      flightTakeOffStation: this.state.flightTakeOffStation,
      departureDate: this.state.departureDate,
      departureTime: this.state.departureTime,
      flightLandingStation: this.state.flightLandingStation,
      arrivalDate: this.state.arrivalDate,
      arrivalTime: this.state.arrivalTime,
      price: this.state.price,
    };
    if (this.validator.allValid()) {
      // alert('You submitted the form and stuff!');
      flightservice.InsertingFlight(flights).then((res) => {
        this.props.history.push("/flights");
        swal({
          title: "Flight Scheduled",
          text: "Flight Travel Scheduled Successfully",
          icon: "success",
        });
      });
    } else {
      this.validator.showMessages();
      // rerender to show messages for the first time
      // you can use the autoForceUpdate option to do this automatically`
      this.forceUpdate();
    }
   
  };

  changeflightIdHandler = (event) => {
    this.setState({ flightId: event.target.value });
  };
  changeflightTakeOffStationHandler = (event) => {
    this.setState({ flightTakeOffStation: event.target.value });
  };
  changedepartureDateHandler = (event) => {
    this.setState({ departureDate: event.target.value });
  };

  changedepartureTimeHandler = (event) => {
    this.setState({ departureTime: event.target.value });
  };
  changeflightLandingStationHandler = (event) => {
    this.setState({ flightLandingStation: event.target.value });
  };
  changearrivalDateHandler = (event) => {
    this.setState({ arrivalDate: event.target.value });
  };
  changearrivalTimeHandler = (event) => {
    this.setState({ arrivalTime: event.target.value });
  };
  changepriceHandler = (event) => {
    this.setState({ price: event.target.value });
  };

  cancel() {
    this.props.history.push("admincardhome");
  }

  logout() {
    localStorage.removeItem("role");
  }

  

  render() {

    return (
      <div>
       

        <div>
          <div className="container">
            <div className="row card mb-0 pb-0" style={{ backgroundColor:"lightblue"}}>
              <div className="card-body mb-0 pb-0">
              <div className="card bg-dark p-3 mt-0" style={{"width":"15%"}}>
        <h2 className="text-center" style={{"color":"white","fontSize":"20px"}}>ADD FLIGHT</h2>
        </div>
                <form className="mb-0 pb-0">
                  <div className="row mb-0 pb-0">
                    <div className="col-sm-6 mb-0 pb-0">
                      <div className="form-group">
                        <label>flightId:</label>
                        <input
                          type="text"
                          placeholder="flightId"
                          name="flightId"
                          className="form-control"
                          value={this.state.flightId}
                          onChange={this.changeflightIdHandler}
                        />
                        <div style={{ color: 'red' }}>
                        {this.validator.message('flightId', this.state.flightId, 'required|alpha Num|min:5|max:6')}
                        </div>
                      </div>
                    </div>

                    <div className="col-sm-6">
                      <div className="form-group">
                        <label htmlFor="flightTakeOffStation">
                          flightTakeOffStation:
                        </label>
                        <input
                          type="text"
                          placeholder="flightTakeOffStation"
                          name="flightTakeOffStation"
                          className="form-control"
                          value={this.state.flightTakeOffStation}
                          onChange={this.changeflightTakeOffStationHandler}
                        />
                        <div style={{ color: 'red' }}>
                         {this.validator.message('flightTakeOffStation', this.state.flightTakeOffStation, 'required|string|alpha|min:2|max:20')}
                        </div>
                      </div>
                    </div>
                  </div>

                  <div className="row mb-2">
                    <div className="col-sm-6">
                      <div className="form-group">
                        <label>departureDate:</label>
                        <input
                          type="date"
                          name="departureDate"
                          className="form-control"
                          value={this.state.departureDate}
                          onChange={this.changedepartureDateHandler}  
                        />
                        <div style={{ color: 'red' }}>
                        {this.validator.message('departureDate', this.state.departureDate, 'required')}
                        </div>
                      </div>
                    </div>

                    <div className="col-sm-6">
                      <div className="form-group">
                        <label>departureTime:</label>
                        <input
                          type="time"
                          name="departureTime"
                          className="form-control"
                          value={this.state.departureTime}
                          onChange={this.changedepartureTimeHandler}
                        />
                        <div style={{ color: 'red' }}>
                         {this.validator.message('departureTime', this.state.departureTime, 'required')}
                        </div>
                      </div>
                    </div>
                  </div>

                  <div className="form-group">
                    <label>flightLandingStation:</label>
                    <input
                      type="text"
                      placeholder="flightLandingStation"
                      name="flightLandingStation"
                      className="form-control"
                      value={this.state.flightLandingStation}
                      onChange={this.changeflightLandingStationHandler}
                    />
                    <div style={{ color: 'red' }}>
                    {this.validator.message('flightLandingStation', this.state.flightLandingStation, 'required|string|alpha|min:2|max:20')}
                   </div>
                  </div>

                  <div className="row mb-2">
                    <div className="col-sm-6">
                      <div className="form-group">
                        <label>arrivalDate:</label>
                        <input
                          type="date"
                          name="arrivalDate"
                          className="form-control"
                          value={this.state.arrivalDate}
                          onChange={this.changearrivalDateHandler}
                        />
                        <div style={{ color: 'red' }}>
                         {this.validator.message('arrivalDate', this.state.arrivalDate, 'required')}
                         </div>
                      </div>
                    </div>

                    <div className="col-sm-6">
                      <div className="form-group">
                        <label>ArrivalTime:</label>
                        <input
                          type="time"
                          name="arrivalTime"
                          className="form-control"
                          value={this.state.arrivalTime}
                          onChange={this.changearrivalTimeHandler}
                        />
                        <div style={{ color: 'red' }}>
                        {this.validator.message('arrivalTime', this.state.arrivalTime, 'required')}
                        </div>
                      </div>
                    </div>
                  </div>

                  <div className="form-group" style={{borderBlockColor:"ActiveCaption"}}>
                    <label>price:</label>
                    <input
                      type="text"
                      placeholder="price"
                      name="price"
                      className="form-control"
                      value={this.state.price}
                      onChange={this.changepriceHandler}
                    />
                    <div style={{ color: 'red'}}>
                    {this.validator.message('price', this.state.price, 'required|numeric|min:1000,num|max:5000000,num')}
                   </div>
                  </div>
               <div className="text-center mb-0">
                  <button className="btn btn-success mt-3" style={{"fontSize":"20px"}} onClick={this.saveFlight}>
                    Save
                  </button>
                  <button
                    className="btn btn-danger mt-3"
                    onClick={this.cancel.bind(this)}
                    style={{ marginLeft: "10px" ,fontSize:"20px"}}
                  >
                    Cancel
                  </button>
                  </div>
                </form>
              </div>
              {/*</div>*/}
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default withRouter(CreateFlightsComponent);
