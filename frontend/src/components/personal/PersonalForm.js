import React, { Component } from 'react';
import {Container, Row, Col, Form, Button, Card} from 'react-bootstrap';
import axios from 'axios';

const ruta = "http://localhost:9000/api/personal/";
export default class PersonalForm extends Component{

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.personalChange = this.personalChange.bind(this);
        this.submitPersonal = this.submitPersonal.bind(this);
    }

    initialState = {id:'' ,rut:'', nombre:'', ocupacion:'', area:'', rol:''}

    componentDidMount(){
        const personalId = +this.props.match.params.id;
        if(personalId){
            axios.get(ruta+personalId)
                .then(response => {
                    if(response.data != null){
                        this.setState({
                            id: response.data.id,
                            rut: response.data.rut,
                            nombre: response.data.nombre,
                            ocupacion: response.data.ocupacion,
                            area: response.data.area,
                            rol: response.data.rol                            
                        });
                    }
                }).catch((error) => {
                    console.error("Error " + error);
                });
        }
    }

    submitPersonal = event => {
        alert('Rut: ' + this.state.rut + '\nNombre: ' + this.state.nombre + '\nOcupacion: ' + this.state.ocupacion + '\nArea: ' + this.state.area + '\nRol: '+ this.state.rol);
        event.preventDefault();

        const personal = {
            rut: this.state.rut,
            nombre: this.state.nombre,
            ocupacion: this.state.ocupacion,
            area: this.state.area,
            rol: this.state.rol
        };

        axios.post(ruta, personal)
            .then(response => {
                if(response.data != null){
                    this.setState(this.initialState);
                    alert("Personal Agregado");
                }
            });
    }

    personalChange = event =>{
        this.setState({
            [event.target.name]:event.target.value
        });
    }

    resetPersonal = () => {
        this.setState(() => this.initialState);
    }

    updatePersonal = event => {
        event.preventDefault();

        const personal = {
            id: this.state.id,
            rut: this.state.rut,
            nombre: this.state.nombre,
            ocupacion: this.state.ocupacion,
            area: this.state.area,
            rol: this.state.rol
        };

        axios.put(ruta+this.state.id, personal)
            .then(response => {
                if(response.data != null){
                    this.setState(this.initialState);
                    alert("Personal Editado");
                }
            });
    }

    render(){
        return(
            <Container>
                <Row>
                    <Col lg={12} style={{marginTop:"20px"}}>
                        <Card>
                            <Card.Header>{this.state.id ? "Editar Personal" : "Agregar Nuevo Personal"}</Card.Header>
                            <Form onReset={this.resetPersonal} onSubmit={this.state.id ? this.updatePersonal : this.submitPersonal} id="personalForm">
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
                                    <Button variant="success" type="submit">
                                        {this.state.id ? "Update" : "Submit"}
                                    </Button>{' '}
                                    <Button variant="info" type="reset">
                                        Reset
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