import React, {Component} from 'react';
import {Card, Container, Col, Row, Table, ButtonGroup, Button} from 'react-bootstrap';
import { Link } from 'react-router-dom';
import PersonalForm from './PersonalForm';
import axios from 'axios';


export default class Personal extends Component {

    constructor(props){
        super(props);
        this.state = {
            personal: []
        };
    }

    componentDidMount(){
        axios.get("http://localhost:9090/api/personal")
            .then(response => response.data)
            .then((data) => {
                this.setState({personal: data})
            });
    }

    deletePersonal = (personalId) => {
        axios.delete("http://localhost:9090/api/personal/"+personalId)
            .then(response => {
                if(response.data != null){
                    alert("Personal Borrado");
                }
                this.setState({
                    personal: this.state.personal.filter(persona => persona.id !== personalId)
                });
            });
    }

    render(){
        return(
            <Container>
                <Row>
                    <Col lg={12} style={{marginTop:"20px"}}>
                        <Card>
                            <Card.Header>Personal<Link to="/personal/agregar" className="nav-link">Agregar</Link></Card.Header>
                            <Table striped bordered hover>
                                <thead>
                                    <tr>
                                    <th>Id</th>
                                    <th>Nombre</th>
                                    <th>Apellido</th>
                                    <th>Ocupación</th>
                                    <th>Área</th>
                                    <th>Rol</th>
                                    <th>Acciones</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    {
                                        this.state.personal.map((persona) => (
                                            <tr key={persona.id}>
                                                <td>{persona.id}</td>
                                                <td>{persona.rut}</td>
                                                <td>{persona.nombre}</td>
                                                <td>{persona.ocupacion}</td>
                                                <td>{persona.area}</td>
                                                <td>{persona.rol}</td>
                                                <td>
                                                    <ButtonGroup>
                                                        <Link to={"personal/editar/"+persona.id} className="btn btn-sm btn-secondary">Editar</Link>
                                                        <Button style={{marginLeft:"10px"}} onClick={this.deletePersonal.bind(this, persona.id)}>Borrar</Button>
                                                    </ButtonGroup>
                                                </td>
                                            </tr>
                                        ))
                                    }
                                </tbody>
                            </Table>
                        </Card>
                    </Col>
                </Row>
            </Container>
        );
    }

}
