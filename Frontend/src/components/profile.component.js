import React, { Component } from "react";
import { Redirect } from 'react-router-dom';
import { connect } from "react-redux";

class Profile extends Component {

  render() {
    const { user: currentUser } = this.props;
    console.log(currentUser);
    if (!currentUser) {
      return <Redirect to="/login" />;
    }

    return (
      <div className="container">
        <header className="jumbotron">
          <h3 style={{"fontSize":"25px","fontWeight":"500","fontFamily":"cursive"}}>
            <strong>{currentUser.username}</strong>'s Profile
          </h3>
        </header>
        <div className="card" style={{"backgroundColor":"lightblue"}}>
        <p>
          <strong style={{"fontFamily":"cursive"}}>Token:</strong>&nbsp;&nbsp;{currentUser.accessToken.substring(0, 20)} ...{" "}
          {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
        </p>
        <p>
          <strong style={{"fontFamily":"cursive"}}>Id:</strong> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{currentUser.id}
        </p>
        <p>
          <strong style={{"fontFamily":"cursive"}}>Email:</strong>&nbsp;&nbsp;&nbsp;{currentUser.email}
        </p>
        <strong style={{"fontFamily":"cursive"}}>Authorities:</strong>
        <ul>
          {currentUser.roles &&
            currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
            </ul>
        </div>
      </div>
    );
  }
}

function mapStateToProps(state) {
  const { user } = state.auth;
  return {
    user,
  };
}

export default connect(mapStateToProps)(Profile);