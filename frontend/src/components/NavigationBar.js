import React, {Component} from 'react';
import {Navbar} from 'react-bootstrap';
import {Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';
export default class NavigationBar extends Component {
    render(){
        return(
            <Navbar bg="dark" variant="dark">
                <Link to="/" className="navbar-brand">
                    SiGPS
                </Link>
                <Nav className="mr-auto">
                    <Link to="/personal" className="nav-link">Personal</Link>
                    <Link to="/pabellones" className="nav-link">Pabellones</Link>
                </Nav>
            </Navbar>
        );
    }

}

