import React, {Component} from 'react';
import {Card, Container, Col, Row, Table} from 'react-bootstrap';
import { Link } from 'react-router-dom';
import PersonalForm from './PersonalForm';
export default class Personal extends Component {

    render(){
        return(
            <Container>
                <Row>
                    <Col lg={12} style={{marginTop:"20px"}}>
                        <Card>
                            <Card.Header>Personal <Link to={"personal/agregar"}>Agregar</Link></Card.Header>
                            <Table striped bordered hover>
                                <thead>
                                    <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Ocupación</th>
                                    <th>Área</th>
                                    <th>Rol</th>
                                    </tr>
                                </thead>
                                <tbody>
                                </tbody>
                            </Table>
                        </Card>
                    </Col>
                </Row>
            </Container>
        );
    }

}
