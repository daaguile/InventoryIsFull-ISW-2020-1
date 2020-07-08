import React from 'react';
import './App.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap/dist/js/bootstrap.bundle.min';
import NavigationBar from './components/NavigationBar';
import Welcome from './components/Welcome';
import Footer from './components/Footer';
import Pabellones from './components/pabellones/Pabellon';
import Personal from './components/personal/Personal';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import PersonalForm from './components/personal/PersonalForm';

function App() {
  return (
    <Router>
      <NavigationBar/>
      <Switch>
        <Route exact path="/"  component={Welcome}/>
        <Route exact path="/pabellones"  component={Pabellones}/>
        <Route exact path="/personal"  component={Personal}/>
        <Route exact path="/personal/agregar" component={PersonalForm}/>
        <Route exact path="/personal/editar/:id" component={PersonalForm}/>
      </Switch>
      <Footer/>
    </Router>
  );
}

export default App;
