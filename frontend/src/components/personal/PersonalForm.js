import React, { Component } from 'react';
import {Container, Row, Col, Form, Button, Card} from 'react-bootstrap';

export default class PersonalForm extends Component{

    constructor(props) {
        super(props);
        this.state = {rut:'', nombre:'', ocupacion:'', area:'', rol:''};
        this.personalChange = this.personalChange.bind(this);
        this.submitPersonal = this.submitPersonal.bind(this);
    }

    submitPersonal(event){
        alert('Rut: ' + this.state.rut + '\nNombre: ' + this.state.nombre + '\nOcupacion: ' + this.state.ocupacion + '\nArea: ' + this.state.area + '\nRol: '+ this.state.rol);
        event.preventDefault();
    }

    personalChange(event){
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    render(){
        return(
            <Container>
                <Row>
                    <Col lg={12} style={{marginTop:"20px"}}>
                        <Card>
                            <Card.Header>Agregar Nuevo Personal</Card.Header>
                            <Form onSubmit={this.submitPersonal} id="personalForm">
                                <Card.Body>
                                    <Form.Row>
                                        <Form.Group controlId="formGridRut">
                                            <Form.Label>Rut</Form.Label>
                                            <Form.Control required type="text" name="rut" value={this.state.rut} onChange={this.personalChange} placeholder="11111111-0" />
                                        </Form.Group>

                                        <Form.Group controlId="formGridNombre" style={{marginLeft:"10px"}}>
                                            <Form.Label>Nombre</Form.Label>
                                            <Form.Control required type="text" name="nombre" value={this.state.nombre} onChange={this.personalChange} placeholder="Nombre" />
                                        </Form.Group>
                                    </Form.Row>
                                    <Form.Row>
                                        <Form.Group controlId="formGridOcupacion">
                                            <Form.Label>Ocupación</Form.Label>
                                            <Form.Control required type="text" name="ocupacion" value={this.state.ocupacion} onChange={this.personalChange} placeholder="Ocupacion" />
                                        </Form.Group>

                                        <Form.Group controlId="formGridArea" style={{marginLeft:"10px"}}>
                                            <Form.Label>Área</Form.Label>
                                            <Form.Control required type="text" name="area" value={this.state.area} onChange={this.personalChange} placeholder="Area" />
                                        </Form.Group>

                                        <Form.Group  controlId="formGridRol" style={{marginLeft:"10px"}}>
                                            <Form.Label>Rol</Form.Label>
                                            <Form.Control required type="text" name="rol" value={this.state.rol} onChange={this.personalChange} placeholder="Rol" />
                                        </Form.Group>
                                    </Form.Row>
                                </Card.Body>
                                <Card.Footer>
                                    <Button variant="primary" type="submit">
                                        Submit
                                    </Button>
                                </Card.Footer>
                            </Form>
                        </Card>
                    </Col>
                </Row>
            </Container>
        );
    }

}