import axios from "axios";
const FLIGHTS_API_BASE_URL = "http://localhost:8061/admin/flights";
const FLIGHTS_API_BASE_URL_USER = "http://localhost:8061/user/flights/src";
const FLIGHTS_API_BOOKING_URL = "http://localhost:8061/book/addBooking";
const BOOKING_API_BASE_URL = "http://localhost:8061/book";
const Fare_API_BASE_URL = "http://localhost:8061/fare/fare";
const TICKET_API_BASE_URL = "http://localhost:8061/ticket/ticket";
const REVIEW_API_BASE_URL="http://localhost:8061/review/post";
const TICKET_API_BASE_URL1="http://localhost:8061/ticket/generate/pdf.htm";
const PAYMENT_API_BASE_URL = "http://localhost:8061/pay";
const FLIGHTS_BY_TAKEOFF="http://localhost:8061/user/flights/takeoff";
class FlightService {

getByTakeoff({flightTakeOffStation}) {
  const url= FLIGHTS_BY_TAKEOFF + "/" + flightTakeOffStation;
  return axios.get(url);
}


  getFlights() {
    return axios.get(FLIGHTS_API_BASE_URL);
  }
  InsertingFlight(flight) {
    return axios.post(FLIGHTS_API_BASE_URL, flight);
  }
  getFlightsById(flightId) {
    return axios.get(FLIGHTS_API_BASE_URL + "/" + flightId);
  }

  editFlights(flight, flightId) {
    return axios.put(FLIGHTS_API_BASE_URL + "/" + flightId, flight);
  }

  deleteFlights(flightId) {
    return axios.delete(FLIGHTS_API_BASE_URL + "/" + flightId);
  }

  getBysrcanddestanddate({
    flightTakeOffStation,
    flightLandingStation,
    departureDate,
  }) {
    const url =
      FLIGHTS_API_BASE_URL_USER +
      "/" +
      flightTakeOffStation +
      "/" +
      flightLandingStation +
      "/" +
      departureDate;
    console.log(url);
    return axios.get(url);
  }

  postpassengerslist(book) {
    return axios.post(FLIGHTS_API_BOOKING_URL, book);
  }

  createTicket(ticket) {
    return axios.get(TICKET_API_BASE_URL + `?farenum=${ticket.farenum}`);
  }

  createpdfticket(ticketId)
  {
    return axios.get(TICKET_API_BASE_URL1+"/" +ticketId ); 
  }

  createBooking(booking) {
    return axios.post(BOOKING_API_BASE_URL + "/addBooking", booking);
  }

  createFare(fare) {
    return axios.get(Fare_API_BASE_URL + `?bookingid=${fare.bookingid}`);
  }

  deleteBooking (bookingid)
  {
    return axios.delete(BOOKING_API_BASE_URL+"/deleteBooking/"+bookingid);
  }
  getBookings()
   {
     return axios.get(BOOKING_API_BASE_URL+"/allBookings");
    }

    payment(order)
    {
      return axios.post(PAYMENT_API_BASE_URL,order);
    }

    review(review)
    {
      return axios.post(REVIEW_API_BASE_URL,review);
    }
    reviews(review)
    {
      return axios.post(`http://localhost:8056/review/post`,review);
    }
}
export default new FlightService();
