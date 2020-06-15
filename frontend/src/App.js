import React from 'react';
import './App.css';
import NavigationBar from './components/NavigationBar';
import Welcome from './components/Welcome';
import Footer from './components/Footer';
import Pabellones from './components/pabellones/Pabellones';
import Personal from './components/personal/Personal';
import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import PersonalForm from './components/personal/PersonalForm';

function App() {
  return (
    <Router>
      <NavigationBar/>
      <Switch>
        <Route path="/" exact component={Welcome}/>
        <Route path="/pabellones" exact component={Pabellones}/>
        <Route path="/personal" exact component={Personal}/>
        <Route path="/personal/agregar" exact component={PersonalForm}/>
      </Switch>
      <Footer/>
    </Router>
  );
}

export default App;
