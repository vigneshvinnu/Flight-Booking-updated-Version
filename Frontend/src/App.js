import { Route, Switch, Link } from "react-router-dom";
import { BrowserRouter as Router } from "react-router-dom";
import * as React from "react";
import { Component, Suspense } from "react";
import { connect } from "react-redux";
import { Nav, NavLink, NavBtn, NavBtnLink } from "./useroperations/navbar";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import { history } from "./helpers/history";
import SearchFLights from "./useroperations/SearchFLights";
import AdminCard from "./adminoperations/AdminCardHome1";
import AdminHome from "./adminoperations/AdminHome";
import Listregistration from "./adminoperations/Listregistration";
import CreateFlightsComponent from "./adminoperations/CreateFlightsComponent";
import UpdateFlightsComponent from "./adminoperations/UpdateFlightsComponent";
import ReviewForm from "./Review/ReviewForm";
import PassengerAdd from "./useroperations/PassengerAdd";
import Ticket from "./useroperations/Ticket";
import ListBookingsComponent from "./adminoperations/ListBookingsComponent";
import Paymentservice from "./payment/Paymentservice";
import Payment from "./payment/Payment";
import Login from "./components/login.component";
import Register from "./components/register.component";
import homeforall from "./protectedroute/homeforall";
import Reviewsubmission from "./Review/Reviewsubmission";
import Profile from "./components/profile.component";
import BoardUser from "./components/board-user.component";
import BoardAdmin from "./components/board-admin.component";
import { logout } from "./actions/auth";
import { clearMessage } from "./actions/message";
import AdminRoute from "./protectedroute/AdminRoute";
import UserRoute from "./protectedroute/UserRoute";
import SearchFLights1 from './adminoperations/SearchFLights1';
class App extends Component {
  constructor(props) {
    super(props);
    this.logout = this.logout.bind(this);

    this.state = {
      showAdminBoard: false,
      currentUser: undefined,
    };

    history.listen((location) => {
      props.dispatch(clearMessage()); // clear message when changing location
    });
  }

  componentDidMount() {
    const user = this.props.user;

    if (user) {
      this.setState({
        currentUser: user,
        showAdminBoard: user.roles.includes("ROLE_ADMIN"),
      });
    }
  }

  logout() {
    this.props.dispatch(logout());
  }

  render() {
    const { currentUser, showAdminBoard } = this.state;
    return (
      <Suspense fallback={<div>Loading...</div>}>
        <Router history={history}>
          <div>
            <Nav
              className="navbar navbar-expand navbar-dark bg-dark"
              style={{ height: "100%" }}
            >
              <Link to={"/"} className="navbar-brand">
              
          FLIGHT SPACE
              </Link>
              <div className="navbar-nav ml-auto">
                <li className="nav-item">
                  <NavLink to={"/home"} className="nav-link1 mr-3">
                    <i class="fas fa-home"> Home</i>
                  </NavLink>
                </li>

                {showAdminBoard && (
                  <ul className="navbar-nav  mr-3 p-1">
                    <li>
                      <NavLink to={"/admin"} className="nav-link1 mr-3">
                        <i class="fas fa-user-cog"> Admin Board</i>
                      </NavLink>
                    </li>

                    <li>
                      <NavLink className="nav-link1 mr-3" to={"/admincardhome"}>
                      <i class="fas fa-helicopter"> Flights Dashboard</i>
                      </NavLink>
                    </li>

                    <li>
                      <NavLink className="nav-link1 mr-3" to={"/userlistinadmin"}>
                      <i class="fas fa-ticket-alt"> Tickets</i>
                      </NavLink>
                    </li>
                    </ul>
                )}

                </div>

              {currentUser ? (
                <div className="navbar-nav ml-auto">
                  <li>
                    <NavLink className="nav-link1" to={"/search-flightsuser"}>
                      <i
                        className="fas fa-search mr-2"
                        style={{ color: "bg-grey-700" }}
                      >
                        {" "}
                        Search Flights
                      </i>
                    </NavLink>
                  </li>

                  <div
                    className="collapse navbar-collapse"
                    id="navbarNavDarkDropdown"
                  >
                    <ul className="navbar-nav">
                      <li className="nav-item dropdown">
                        <a
                          className="nav-link dropdown-toggle"
                          href="/user"
                          id="navbarDarkDropdownMenuLink"
                          role="button"
                          data-bs-toggle="dropdown"
                          aria-expanded="false"
                        >
                          <i
                            className="fas fa-user"
                            style={{ color: "bg-grey-700" }}
                          >
                            {" "}
                            {currentUser.username}'s Profile
                          </i>
                        </a>
                        <ul
                          className="dropdown-menu dropdown-menu-dark"
                          aria-labelledby="navbarDarkDropdownMenuLink"
                        >
                          <li>
                            <a className="dropdown-item" href="/profile">
                              <b>Profile</b>
                            </a>
                          </li>

                        
                        {currentUser && (
                  <li>
                    <a className="dropdown-item" href={"/user"}>
                    <i class="far fa-user">
                     <b> User</b></i>
                    </a>
                  </li>
                )}

                          <li>
                            <a
                              href="/login"
                              className="dropdown-item"
                              onClick={this.logout}
                            >
                              <i class="fas fa-sign-out-alt"> Logout</i>
                            </a>
                          </li>
                        </ul>
                      </li>
                    </ul>
                  </div>
                </div>
              ) : (
                <div className="navbar-nav ml-auto">
                  <li className="nav-item">
                    <NavBtn>
                      <NavBtnLink to={"/login"}>Login</NavBtnLink>
                    </NavBtn>
                  </li>

                  <li className="nav-item">
                    <NavBtn>
                      <NavBtnLink to={"/register"}>Signup</NavBtnLink>
                    </NavBtn>
                  </li>
                </div>
              )}
            </Nav>

            <div className="container">
              <Switch>
                {/*admin*/}
                <Route path="/" exact component={SearchFLights} />
                <AdminRoute path="/admincardhome" exact component={AdminCard} />
                <AdminRoute path="/admin" exact component={AdminHome} />
                <AdminRoute
                  path="/flights"
                  exact
                  component={Listregistration}
                />
                <AdminRoute
                  path="/add-flight"
                  exact
                  component={CreateFlightsComponent}
                />
                <AdminRoute
                  path="/userlistinadmin"
                  component={ListBookingsComponent}
                />
                <Route
                  path="/update-flights/:flightId"
                  exact
                  component={UpdateFlightsComponent}
                />

                {/*user*/}
                <UserRoute
                  path="/search-flightsuser"
                  exact
                  component={SearchFLights}
                />

                <AdminRoute path="/landing" exact component={SearchFLights1}/>
                <Route path="/review" exact component={ReviewForm} />
                <UserRoute
                  path="/reviewsubmission"
                  exact
                  component={Reviewsubmission}
                />
                <UserRoute
                  path="/bookings/:flightId"
                  exact
                  component={PassengerAdd}
                />
                <UserRoute path="/ticket/:farenum" component={Ticket} />
                <Route
                  path="/payment/:farenum"
                  exact
                  component={Paymentservice}
                />
                <UserRoute path="/pay" component={Payment} />
                <Route exact path="/login" component={Login} />
                <Route exact path="/register" component={Register} />
                <Route exact path="/profile" component={Profile} />
                <Route path="/user" component={BoardUser} />
                <Route path="/admin1" component={BoardAdmin} />
                <Route path="/home" component={homeforall} />
                <Listregistration />
              </Switch>
            </div>

            
          </div>
          {/* <FooterComponent/> */}
          {/* <div>
            <br/>
        <footer className="footer">
          <span className="text-muted text-center">All Rights Reserved 2021 @Vignesh</span>
        </footer>
      </div> */}
        </Router>
      </Suspense>
    );
  }
}

function mapStateToProps(state) {
  const { user } = state.auth;
  return {
    user,
  };
}

export default connect(mapStateToProps)(App);
