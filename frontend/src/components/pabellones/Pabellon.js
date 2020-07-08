import React, { Component } from 'react';
import { Card, Container, Col, Row, Table, ButtonGroup, Button } from 'react-bootstrap';
import { Link, Route } from 'react-router-dom';
import PabellonForm from './PabellonForm';
import axios from 'axios';


const ruta = "http://localhost:9000/api/pabellones/";
export default class Pabellon extends Component {

    constructor(props) {
        super(props);
        this.state = {
            pabellon: []
        };
    }

    componentDidMount() {
        axios.get(ruta)
            .then(response => response.data)
            .then((data) => {
                this.setState({ pabellon: data })
            });
    }

    deletePabellon = (pabellonId) => {
        axios.delete(ruta + pabellonId)
            .then(response => {
                if (response.data != null) {
                    alert("Pabellon Borrado");
                }
                this.setState({
                    pabellon: this.state.pabellon.filter(persona => persona.id !== pabellonId)
                });
            });
    }

    render() {
        return (
            <Container>
                <Row>
                    <Col lg={12} style={{ marginTop: "20px" }}>
                        <Card>
                            <Card.Header>Pabellon<Link to="/pabellon/agregar" className="nav-link disabled">Agregar</Link></Card.Header>
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
                                        this.state.pabellon.map((persona) => (
                                            <tr key={persona.id}>
                                                <td>{persona.id}</td>
                                                <td>{persona.rut}</td>
                                                <td>{persona.nombre}</td>
                                                <td>{persona.ocupacion}</td>
                                                <td>{persona.area}</td>
                                                <td>{persona.rol}</td>
                                                <td>
                                                    <ButtonGroup>
                                                        <Link to={"pabellon/editar/" + persona.id} className="btn btn-sm btn-secondary">Editar</Link>
                                                        <Button style={{ marginLeft: "10px" }} onClick={this.deletePabellon.bind(this, persona.id)}>Borrar</Button>
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
