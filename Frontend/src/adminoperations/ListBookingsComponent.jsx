import React, { Component } from "react";
import flightservice from "../flightsservices/flightservice";
import Swal from 'sweetalert2';
import withReactContent from 'sweetalert2-react-content';
import { withRouter } from "react-router-dom";
class ListBookingsComponent extends Component {
  constructor(props) {
    super(props);
    this.Swal=new withReactContent(Swal);
    this.state = {
      bookings: [],
    };

    this.deleteBooking = this.deleteBooking.bind(this);
  }

  deleteBooking(bookingid) {
    flightservice.deleteBooking(bookingid).then((res) => {
      this.setState({
        bookings: this.state.bookings.filter(
          (booking) => booking.bookingid !== bookingid
        ),
      });
    });
  }

  componentDidMount() {
    flightservice.getBookings().then((res) => {
      this.setState({ bookings: res.data });
    });
  }

  addBooking() {
    this.props.history.push("/admincardhome");
    window.location.reload();
  }

  logout() {
    localStorage.removeItem("role");
  }

  opensweetalert(bookingid){
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
         this.deleteBooking (bookingid)
         this.props.history.push("/userlistinadmin");
       
       } else if (result.dismiss === Swal.DismissReason.cancel) {
         this.props.history.push("/userlistinadmin");
         
       }
     })
   }

  render() {
    return (
      <div>
      <div className="card bg-dark p-1" style={{"width":"20%"}}>
       <h2 className="text-center" style={{"color":"white","fontSize":"30px","padding":"5px"}}>BOOKINGS</h2>
       </div>
        {/* </div> */}
        <div className="row card">
        <table className="table table-borderless m-0 table-hover">
            <thead className="thead-dark">
              <tr>
                <th>Flight Id</th>
                <th>User name</th>
                <th>Booking Id</th>
                <th>Flight Price</th>
                <th>Actions</th>
              </tr>
            </thead>

            <tbody>
              {this.state.bookings.map((booking) => (
                <tr key={booking.bookingid}>
                  <td>{booking.flightId}</td>
                  <td>{booking.userid}</td>
                  <td>{booking.bookingid}</td>
                  <td>{booking.bookingAmount}</td>
                  <td>
                  <button
                    style={{ marginLeft: "10px" }}
                    onClick={() =>  this.opensweetalert(booking.bookingid)}
                    className="btn btn-danger delete button"
                  ><i class="fa fa-trash"> </i>
                    <b>Delete </b>
                  </button>
                    {/* <button
                      title="delete"
                      onClick={() => { 
                        const confirmBox =window.confirm("Deleting this booking Yes or No?") 
                      if (confirmBox === true) {
                        this.deleteBooking(booking.bookingid)
                      }}}
                      className="btn btn-danger"
                    >
                      Delete
                    </button> */}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    );
  }
}

export default withRouter(ListBookingsComponent);
