/* eslint-disable react-hooks/exhaustive-deps */
import { useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import flightservice from "../flightsservices/flightservice";

const Ticket = () => {
  const [ticketData, setTicketData] = useState(null);
  const { farenum } = useParams();
  const getTicketDetails = async () => {
    const resp = await flightservice.createTicket({ farenum });
    setTicketData(resp.data);
  };
 
 
 
  useEffect(() => {
    getTicketDetails();
  }, []);

  return (
    <>
          <div className="card-header">
            <br/>
            <div>
              <div>
            <h3 className="text-center alert alert-success w-50 mx-auto b" style={{backgroundColor:"green",color:"white",fontSize:"30px",fontWeight:"500"}}>
                Ticked Booked !
              </h3>
              </div>
              {ticketData ? (
                
                <table
                  className="alert alert-primary w-50 mx-auto"
                  style={{ color: "black", fontWeight: "bold" }}
                >
          
                  <tr>
                    <td className="text-center">Ticket Id </td>
                    <td>{ticketData.ticketId}</td>
                  </tr>{" "}
                  <br />
                  <tr>
                    <td className="text-center">Fare Number </td>
                    <td>{ticketData.farenum}</td>
                  </tr>{" "}
                  <br />
                  {ticketData.passengerList.map((passenger, index) => (
                    <tr rowSpan={3}>
                      <td className="text-center">Passenger {index + 1} </td>
                      <td>
                        <span> First Name: {passenger.firstName} </span>
                        <br /> <span>Last Name: {passenger.lastName} </span>
                        <br /> <span>Age: {passenger.age}</span>
                        <br /> <span>
                          Gender: {passenger.gender}
                        </span> <br /> <br />
                      </td>
                    </tr>
                  ))}
                  <tr>
                    <td className="text-center">Source </td>
                    <td>{ticketData.flightTakeOffStation}</td>
                  </tr>
                  <br />
                  <tr>
                    <td className="text-center">Destination</td>
                    <td>{ticketData.flightLandingStation}</td>
                  </tr>
                  <br />
                  <tr>
                    <td className="text-center">Departure Date </td>
                    <td>{ticketData.departureDate}</td>
                  </tr>
                  <br />
                  <tr>
                    <td className="text-center">Departure Time </td>
                    <td>{ticketData.departureTime}</td>
                  </tr>
                  <br />
                  <tr>
                    <td className="text-center">Arrival Date </td>
                    <td>{ticketData.arrivalDate}</td>
                  </tr>
                  <br />
                  <tr>
                    <td className="text-center">Arrival Time </td>
                    <td>{ticketData.arrivalTime}</td>
                  </tr>
                  <br />
                  <tr>
                    <td className="text-center">Booking Price</td>
                    <td>{ticketData.price}</td>
                  </tr>
                  <br />
                  <tr>
                    <td className="text-center">Amount </td>
                    <td>{ticketData.ticketAmount}</td>
                  </tr>
                </table>
              ) : null}
            </div>

            <div className="text-center mt-3">
              {ticketData && ticketData.ticketId ? <a href={`http://localhost:8091/ticket/generate/pdf.htm/${ticketData.ticketId}`} target="_blank" rel="noreferrer">
             <button className="mr-3 w-25 btn btn-primary"> <i class="fas fa-file-pdf"> Pdf Generator</i></button>
              </a>:null}
              <a href="/review">
                <button className="w-25 btn btn-primary">Review</button>
              </a>
            </div>
          </div>
    </>
  );
};

export default Ticket;
