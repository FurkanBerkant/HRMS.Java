import './App.css';
import "semantic-ui-css/semantic.min.css";
import { Container } from 'semantic-ui-react';
import Dashboard from './layouts/Dashboard';
import Navi from '../src/layouts/Navi'
import Footer from './layouts/Footer';
import { Route, Switch } from 'react-router-dom';
import { routes } from './Routing';

function App() {
  return (
    <div className="App">

      <Navi />
      <Container>
        <Switch>
          {routes.map((route) => (

            <Route exact={route.exact} path={route.path} key={route.title}> <Dashboard> {route.component} </Dashboard> </Route>
          ))}
        </Switch>
      </Container>
      <Footer />


    </div>
  );
}

export default App;
