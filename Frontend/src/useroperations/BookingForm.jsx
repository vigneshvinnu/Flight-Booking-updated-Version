import { useState } from "react";
import { withRouter } from "react-router-dom";
import useValidator from "./useValidator";
const BookingForm = (props) => {
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [age, setAge] = useState("5");
  const [gender, setGender] = useState("");
  const [validator, showValidationMessage] = useValidator();
  const handleSubmit = (event) => {
    event.preventDefault();
    if (validator.allValid()) {
      const userObj = { firstName, lastName, age, gender };
      props.setPassengers([...props.passengers, userObj]);
      props.setAddingPassenger(false);
      console.log("form submitted");
    } else {
      // validator.showMessages();
      // rerender to show messages for the first time
      showValidationMessage(true);
    }
  };

  return (
    <div
      className="w-100 card"
      style={{ width: "100px", backgroundColor: "lightblue" }}
    >
      <form onSubmit={handleSubmit}>
        <div className="flight-table mt-3 p-3">
          <div className="pl-10">
            <div className="row mb-2 form-group">
              <div className="col-sm-6">
                <div>First Name</div>
                <input
                  type="text"
                  title="First Name"
                  placeholder="First Name"
                  value={firstName}
                  onChange={(event) => setFirstName(event.target.value)}
                />
                <div style={{ color: "red" }}>
                  {validator.message(
                    "firstName",
                    firstName,
                    "required|min:5|max:15"
                  )}
                </div>
              </div>

              <div className="col-sm-6">
                <div>Last Name</div>
                <input
                  type="text"
                  title="Last Name"
                  placeholder="Last Name"
                  value={lastName}
                  onChange={(event) => setLastName(event.target.value)}
                />
                <div style={{ color: "red" }}>
                  {validator.message(
                    "Last Name",
                    lastName,
                    "required|min:5|max:15"
                  )}
                </div>
              </div>
            </div>

            <div className="row mb-2">
              <div className="col-sm-6">
                <div>Age</div>
                <input
                  type="number"
                  title="Age"
                  placeholder="age"
                  value={age}
                  onChange={(event) => setAge(event.target.value)}
                />
                <div style={{ color: "red" }}>
                  {validator.message(
                    "age",
                    age,
                    "required|numeric|min:5,num|numeric|max:100,num"
                  )}
                </div>
              </div>

              <div className="col-sm-6">
                <div>Gender</div>
                <label>
                  {" "}
                  Male:
                  <input
                    type="radio"
                    name="gender"
                    value="male"
                    className="ml-1 mr-2"
                    onChange={(event) => {
                      setGender(event.target.value);
                    }}
                  />
                  <div style={{ color: "red" }}>
                    {validator.message("gender", gender, "required")}
                  </div>
                </label>
                <label>
                  {" "}
                  Female:
                  <input
                    type="radio"
                    name="gender"
                    value="female"
                    className="ml-1"
                    onChange={(event) => {
                      setGender(event.target.value);
                    }}
                  />
                  <div style={{ color: "red" }}>
                    {validator.message("gender", gender, "required")}
                  </div>
                </label>
              </div>
            </div>
          </div>
        </div>
        <div className="mx-auto text-center mt-3 mb-0">
        <button
        data-testid="save"
          title="save"
          placeholder="save"
          type="submit"
          className="btn btn-success"
          style={{ fontSize: "20px" }}
        >
          Save
        </button>
        <button
          title="bookingform"
          placeholder="cancel"
          id="cancel"
          onClick={() => props.setAddingPassenger(false)}
          className="btn btn-danger"
          style={{ marginLeft: "20px", fontSize: "20px" }}
        >
          Cancel
        </button>
      </div>
      </form>
      
    </div>
  );
};

export default withRouter(BookingForm);
