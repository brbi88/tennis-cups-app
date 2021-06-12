import React from 'react';
import ReactDOM from 'react-dom';
import {Route, Link, HashRouter as Router, Switch} from 'react-router-dom';
import {Container, Button, Navbar, Nav} from "react-bootstrap"
import Login from "./components/login/Login"
import Home from './components/Home';
import Takmicenja from './components/takmicenja/Takmicenja.js';
import DodajTakmicenje from './components/takmicenja/DodajTakmicenje.js';
import Prijave from './components/takmicenja/Prijave.js';
import NotFound from './components/NotFound';
import {logout} from './services/auth'



class App extends React.Component {

    
    render() {
        return (
            <div style={{
                backgroundImage: `url(${process.env.PUBLIC_URL + '/tennis.jpg'})`,
                backgroundPosition: 'center',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        width: '100vw',
        height: '100vh'
            }}>
                <div>
                <Router>
                    <Navbar expand bg="dark" variant="dark">
                        <Navbar.Brand as={Link} to="/">TENISKI KUPOVI</Navbar.Brand>
                        <Nav className="mr-auto">
                            <Nav.Link as={Link} to="/takmicenja">Takmicenja</Nav.Link>
                            <Nav.Link as={Link} to="/takmicenja/add">Dodaj takmicenje</Nav.Link>
                        </Nav>
                            {window.localStorage['jwt'] ?
                            <Button onClick= {() =>logout()}>Logout</Button> :
                            <Nav.Link as={Link} to="/login">Log in</Nav.Link>
                            }
                    </Navbar>
                    
                    <Container style={{marginTop: 25}}>
                    <Switch>
                        <Route exact path="/" component={Home}/>
                        <Route exact path="/takmicenja" component={Takmicenja}/>
                        <Route exact path="/takmicenja/add" component={DodajTakmicenje}/>
                        <Route exact path="/takmicenja/prijava/:id" component={Prijave}/>
                        <Route exact path="/login" component={Login}/>
                        <Route component={NotFound}/>
                    </Switch>
                    </Container>
                </Router>
            </div>
            </div>
        );
    }
};

ReactDOM.render(
    <App/>,
    document.querySelector('#root')
);