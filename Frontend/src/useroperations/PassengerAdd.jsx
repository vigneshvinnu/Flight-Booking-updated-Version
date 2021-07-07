import { useState } from "react";
import BookingForm from "./BookingForm";
import { useParams, withRouter } from "react-router-dom";
import flightservice from "../flightsservices/flightservice";
import { useHistory } from "react-router-dom";
import Swal from 'sweetalert2';
const BookingPage = () => {
  const [passengers, setPassengers] = useState([]);
  const [addingPassenger, setAddingPassenger] = useState(false);
  const { flightId } = useParams();
  const {loading} = false;
  const history = useHistory();
  const proceedNext = async () => {
    const userid = localStorage.getItem("userid");
  
    const bookingData = {
      passengerNames: passengers,
      userid,
      flightId,
      loading: true,
    };
console.log(bookingData);
    const resp = await flightservice.createBooking(bookingData);
console.log(resp);
    const bookingid = resp.data.bookingid;
    console.log(bookingid);
    const fareData = { bookingid };
    console.log(fareData);
    const fareResp = await flightservice.createFare(fareData);
    console.log(fareResp);
    history.push(`/payment/${fareResp.data.farenum}`);
    window.location.reload();
  };

  const deletePassenger = (index) => {
    let allPassengers = [...passengers];
    allPassengers = allPassengers.filter((pas, ind) => ind !== index);
    setPassengers(allPassengers);
  };

  const opensweetalert = (proceedNext,flightId) => {
    new Swal({
       title: 'Are you sure?',
       text: 'Make sure all passengers details are correct',
       icon: 'warning',
       showCancelButton: true,
       confirmButtonText: 'Do payment!',
       cancelButtonText: 'Keep waiting'
     })
     .then((result) => {
       if (result.isConfirmed) {
         proceedNext();
       } else if (result.dismiss === Swal.DismissReason.cancel) {
        
         
       }
     })
   }

  return (
    <div >
      {passengers.length > 0 && (
        <div className="row " >
          {passengers.map((passenger, index) => (
            <div className="col-sm-4 ">
              <div className="cards1 flight-table mt-3 card" >
                <div className="card-header" style={{backgroundColor:"lightgreen"}}>
                  <div className="d-flex justify-content-between" >
                    <div className="text-center">
                    <h5>Passenger {index + 1}</h5>
                    </div>
                    <div className="text-secondary">
                      <span
                        role="button"
                        onClick={() => {
                          deletePassenger(index);
                        }} className="btn btn-danger"
                      >
                        X
                      </span>
                    </div>
                  </div>
                </div>
                <div className="card-body">
                  <div><strong>First Name:</strong> {passenger.firstName}</div>
                  <div><strong>Last Name:</strong> {passenger.lastName}</div>
                  <div><strong>Gender:</strong> {passenger.gender}</div>
                </div>
              </div>
            </div>
          ))}
        </div>
      )}
      {!addingPassenger ? (
        <button title="add" className="btn btn-primary mt-5" onClick={() => setAddingPassenger(true)}>
          Add another passenger
        </button>
      ) : (
        <BookingForm
          setAddingPassenger={setAddingPassenger}
          setPassengers={setPassengers}
          passengers={passengers}
        />
      )}
      {passengers.length > 0 && (
        <div className="text-center">
          <br/>
          <button title="payment"  id="payment" className="btn btn-success btn-block"  disabled={loading} 
         onClick= { () => opensweetalert(proceedNext)}>
          {loading && (
                  <span className="spinner-border spinner-border-sm"></span>
                )}
                <span>Make Payment</span>
          </button>
        </div>
      )}
    </div>
  );
};

export default withRouter(BookingPage);
