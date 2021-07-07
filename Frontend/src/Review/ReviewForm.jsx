import React, { Component } from "react";
import SimpleReactValidator from "simple-react-validator";
import flightservice from "../flightsservices/flightservice";
import swal from 'sweetalert';
export default class ReviewForm extends Component {
  constructor(props) {
    super(props);
    this.validator = new SimpleReactValidator();
    this.state = {
      username: " ",
      experience: " ",
      feedback: " ",
      loading: false,
    };
  }

  changeHandler = (e) => {
    this.setState({ [e.target.name]: e.target.value });
  };


  submitHandler = (e) => {
    e.preventDefault();
    console.log(this.state);
    if (this.validator.allValid()) {
      this.setState({
        loading: true,
      });
      // alert("You submitted the review, Thank you");
      flightservice.reviews(this.state).then((res) => {
        this.props.history.push("/reviewsubmission");
        // window.location.reload();
        swal({
          title: "Review Submitted",
          icon: "success",
        });
      }
      );
    } else {
      this.validator.showMessages();
      this.setState({
        loading: false,
      });
      this.forceUpdate();
    }
  };
  render() {
    const { username,experience, feedback  } = this.state;
    return (
      <div className="card " style={{ backgroundColor:"lightblue"}}>
        <form onSubmit={this.submitHandler}>
          <br />
          <div className="card bg-dark p-3 mt-1" style={{"width":"15%"}}>
        <h2 className="text-center" style={{"color":"white","fontSize":"20px"}}>REVIEW</h2>
        </div>

          <div className="card">
            <label><h6>How was your Experience:</h6></label>
            <table>
              <tbody>
                <tr>
                  <td>
                    <label htmlFor="excellent" className="mr-3">
                      <input
                        type="radio"
                        id="excellent"
                        name="experience"
                        value="excellent"
                        onChange={this.changeHandler}
                        style={{marginLeft:"15px",marginRight:"5px"}}
                        
                      />Excellent
                        <div style={{ color: 'red' }}>
                          {this.validator.message("experience", experience, "required")}
                          </div>
                      
                    </label>
                  </td>
                  <td>
                    <label htmlFor="Good" className="mr-3">
                      <input
                        type="radio"
                        id="Good"
                        name="experience"
                        value="Good"
                        onChange={this.changeHandler}
                        style={{marginLeft:"15px",marginRight:"5px"}}
                        
                      /> Good
                      <div style={{ color: 'red' }}>
                      {this.validator.message("experience", experience, "required")}
                      </div>
                    </label>
                  </td>
                  <td>
                    <label htmlFor="Average">
                      <input
                        type="radio"
                        id="Average"
                        title="Average"
                        name="experience"
                        value="Average"
                        onChange={this.changeHandler}
                        style={{marginLeft:"15px",marginRight:"5px"}}
                        
                      />
                      Average{" "}
                      <div style={{ color: 'red' }}>
                          {this.validator.message("experience", experience, "required")}
                          </div>
                    </label>
                  </td>
                </tr>
              </tbody>
            </table>
          </div>
          <br />
          <div>
            <label>Username:</label>
            <input
              type="text"
              name="username"
              title="username"
              className="form-control"
              value={username}
              onChange={this.changeHandler}
            /><div style={{ color: 'red' }}>
            {this.validator.message('username', this.state.username, 'required|string|min:5|max:20')}
            </div>
          </div>
          <br />
          <div>
            <label>Feedback:</label>
            <textarea
              type="text"
              title="feedback"
              name="feedback"
              placeholder="Feedback"
              className="form-control"
              value={feedback}
              onChange={this.changeHandler}
              cols="50"
              rows="4"
            /><div style={{ color: 'red' }}>
            {this.validator.message('feedback', this.state.feedback, 'required|string|min:4|max:150')}
            </div>
          </div>
          <br />
          <div className="form-group">
            <button
             data-testid="submit"
              className="btn btn-primary btn-block"
              placeholder="submit"
              disabled={this.state.loading}
            >
              {this.state.loading && (
                <span className="spinner-border spinner-border-sm"></span>
              )}
              <span>Submit</span>
            </button>
          </div>
        </form>
      </div>
    );
  }
}

// export default ReviewForm;
