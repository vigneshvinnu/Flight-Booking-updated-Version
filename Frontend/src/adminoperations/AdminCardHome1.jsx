import React, { Component } from "react";
import AdminCard from "./AdminCardHome";
import card1 from "../images/card1.jpg";
// import card2 from "../images/card2.jpg";
import card3 from "../images/card3.jpg";
import { withRouter } from "react-router-dom";
class AdminCardHome1 extends Component {
  logout() {
    localStorage.removeItem("role");
  }
  render() {
    return (
      <div>
 <div className="card bg-dark p-0" style={{"width":"20%"}}>
        <h2 className="text-center" style={{"color":"white","fontSize":"30px","padding":"5px"}}>DASHBOARD</h2>
        </div>
        <div className="row">
          <div className="col-md-4">
            <AdminCard imgsrc={card1} title="To Check Flight details" para="Checking page for Admin to check all the flight details are correctly scheduled with source"
           href="/landing" a="Go to Check Flights "/>
          </div>
          <div className="col-md-4">
            <AdminCard imgsrc="https://media.cntraveler.com/photos/56d9e6977243f8953e3451c2/master/pass/two-passports.jpg" title="ADD FLIGHT" para="Adding a new Flight to avail the customers know about flight details,date,time"
            href="/add-flight" a="Go to Add Flights"/>
          </div>
          <div className="col-md-4">
            <AdminCard imgsrc={card3} title="UPDATE FLIGHT" para="Updating flight details,incase flight is rescheduled,update details or cancelled"
            href="/flights" a="Go to Update Flights"/>
          </div>
        </div>
        
      </div>
      
    );
  }
}

export default withRouter(AdminCardHome1);
