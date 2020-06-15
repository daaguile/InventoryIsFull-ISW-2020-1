import React, {Component} from 'react';

import {Jumbotron, Container, Row, Col} from 'react-bootstrap';

export default class Welcome extends Component {
    render(){

        return(
            <Container>
                <Row>
                    <Col lg={12} style={{marginTop:"20px"}}>
                        <Jumbotron>
                            <div>
                                <h1>SiGPS</h1>
                                <p>
                                Sistema de Gestión de Pabellones y Sillones de Quimioterapia
                                </p>
                            </div>
                        </Jumbotron>
                    </Col>
                </Row>
            </Container>
        );

    }

}

