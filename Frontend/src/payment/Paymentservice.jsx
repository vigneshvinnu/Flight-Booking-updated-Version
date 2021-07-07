import React, { useRef, useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import { useHistory } from "react-router-dom";
import flightservice from "../flightsservices/flightservice";
import axios from "axios";
export default function Paypal() {
  const paypal = useRef();
  const history = useHistory();

  const [ticketData, setTicketData] = useState(null);
  const { farenum } = useParams();
  const paypalRendered = useRef(false);
  const getTicketDetails = async () => {
    const resp = await flightservice.createTicket({ farenum });
    setTicketData(resp.data);
  };
  const paypalComponent = () => {
    window.paypal
      .Buttons({
        createOrder: (data, actions, err) => {
          return actions.order.create({
            intent: "CAPTURE",
            purchase_units: [
              {
                description: "For flight ticket booking",
                amount: {
                  currency_code: "USD",
                  value: parseFloat(ticketData.ticketAmount),
                },
              },
            ],
          });
        },
        onApprove: async (data, actions) => {
          const order = await actions.order.capture();
          if(order.status==="COMPLETED")
          {

            axios.post("http://localhost:8061/pay/paypal",order)
            .then((response) => {
              // console.log(response);
            }).catch((error) => {
               console.log(error);
            });
          history.push(`/ticket/${ticketData.farenum}`);
          window.location.reload();
          }
        },
        onError: (err) => {
          console.log(err);
        },
      })
      .render(paypal.current);
  };

  useEffect(() => {
    console.log(ticketData);
    if (!ticketData) {
      getTicketDetails();
    }
    if (ticketData && !paypalRendered.current) {
      paypalComponent();
      paypalRendered.current = true;
    }
  // eslint-disable-next-line react-hooks/exhaustive-deps
  }, [ticketData]);

  return (
    <div>
      <div ref={paypal} style={{textAlign:"center"}} >
     
        <br/> 
        <br/>
        
        <br/>
         <br/>
        <br/>
        {/* <div style={{textAlign:"center"}}>
      <p style={{textAlign:"left",fontSize:"30px",color:"darkorange"}}>Pay via:</p>
      </div> */}
      </div>
    </div>
  );
}