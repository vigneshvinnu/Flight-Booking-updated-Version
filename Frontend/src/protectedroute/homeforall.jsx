import React, { Component } from 'react'
import './home.css';
import pic1 from "../images/pic1.png";
import pic3 from "../images/pic3.png";
import pic4 from "../images/pic4.png";
import pic5 from "../images/pic5.png";
import pic6 from "../images/pic6.png";
import pic7 from "../images/pic7.png";
import pic8 from "../images/pic8.png";
import pic9 from "../images/pic9.png";
export default class homeforall extends Component {
    render() {
        return (
            <div className="container">
                 <div class="wrapper" style={{minHeight:"90vh",paddingTop:"50px"}}>
                    <div class="card23 shadow-lg p-3 mb-5 bg-white rounded bg-image1">
                     <div class="card-body" style={{fontWeight:"450"}}>
                   <h3 class="card-title23" style={{fontWeight:"500"}}>
                     Welcome to Flight Booking Interface</h3>
                         Booking your Flight in our site is always welcome and this is the best one for simple and effortless flight booking PlatForm
                    We promise that you have great support for Booking flight tickets. We are proud to say that we
                    are the number one solution for the all flight bookings. we hope you will have 
                  a great Booking and your travel as well.
                  <br />
                  <br/>
                  <br/>
               <button type="button" class="btn btn-primary signUpBtn">
                  <a href="#section-a">Know More</a>
                </button>
               </div>
             </div>
             <div class="card23 offer-card5 shadow-lg p-3 mb-5 rounded" style={{backgroundColor:"ActiveCaption"}} >
             <main id="main">
             <section id="section-b" class="grid">
            <div class="wrapper mb-5  rounded">
                <h2 class="card-title23 ">About Booking</h2>
                <div class="card-text">
                    <p>Don't have to rush to anywhere for booking flight tickets. Booking tickets is in your right now
                         With this application you can do payment and take your ticket as a soft copy and you can give review
                         to improve our website.
                    </p>
                </div>
            </div>
            
        </section></main></div>

              <div class="card23 offer-card5 shadow-lg p-3 mb-5 bg-white rounded" style={{backgroundColor:"chartreuse"}} >
                <section id="section-a" class="grid">
            <div class="card-body" >
                      <h3 class="card-title23" style={{fontWeight:"500"}}>Have a Look at our facilities</h3>
                 <div class="row">
                   <div class="col-md-3" style={{"padding": "5px"}}>
                    <img src={pic1} style={{height:"200px",width:"250px"}} alt="pic" />
                    <span class="info">
            We have Good airstation.
            <hr />
            
          </span>
                   </div>
                   
                      <div class="col-md-3" style={{"padding": "5px"}}>
                     <img src={pic3} style={{height:"200px",width:"250px"}} alt="pic" />
                     <span class="info">
           Maintaining is our respaonsibility in this pandemic
            <hr />
            
          </span>
                      </div>
                  <div class="col-md-3" style={{"padding": "5px"}}>
                    <img src={pic4} style={{height:"200px",width:"250px"}} alt="pic"/>
                    <span class="info">
           We are encouraging social distancing 
            <hr />
            
          </span>
                     </div>
                   <div class="col-md-3" style={{"padding": "5px"}}>
                    <img src={pic5} style={{height:"200px",width:"250px"}} alt="pic"/>
                    <span class="info">
            Can check flights if there is any delay are not
            <hr />
            
          </span>
              </div>
            </div>
           </div>
           </section>
        </div>
  <div class="card23 offer-card5 shadow-lg p-3 mb-5 bg-white rounded">
    <div class="card-body">
      <h3 class="card-title23" style={{fontWeight:"500"}}>About Us</h3>
      <div class="row">
        <div class="devCard col-md-3" style={{"padding": "5px",fontWeight:"450"}}>
          <img class="photo" src={pic6} style={{height:"200px",width:"250px"}} alt="pic"/><br /><br />
          
          <hr />
          <span class="info">
            We have Great supporting staff.
            <hr />
            
          </span>
        </div>
        <div class="devCard col-md-3" style={{"padding": "5px",fontWeight:"450"}}>
          <img class="photo" src={pic7} style={{height:"200px",width:"250px"}} alt="pic"/><br /><br />
          
          <hr />
          <span class="info">
            Huge Terminals with all facilities in  pandemic also
            <hr />
            
          </span>
        </div>
        <div class="devCard col-md-3" style={{"padding": "5px",fontWeight:"450"}} >
          <img class="photo" src={pic8} style={{height:"200px",width:"250px"}} alt="pic"/><br /><br />
          
          <hr/>
          <span>
            Have a safe and comfortable journy.
            <hr />
            
          </span>
        </div>
        <div class="col-md-3" style={{"padding":"5px",fontWeight:"450"}}>
          <img class="photo" src={pic9} style={{height:"200px",width:"250px"}} alt="pic" /><br /><br />
          
          <hr />
          <span>
            <p>Info</p>
            <p>contactNumber: 6283946663</p>
            <p>Mail:vigneshvinnu03@gmail.com</p>
            <hr />
            
          </span>
        </div>
      </div>
    </div>
  </div>

            </div>
            </div>
        )
    }
}
