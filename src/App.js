import logo from './logo.svg';
import './App.css';
import { BrowserRouter, Switch, Route } from 'react-router-dom';
import Home from './components/WorkPlace/Home/Home';
import Navbar from './components/Navbar/Navbar'
import WorkPlace from './components/WorkPlace/WorkPlace';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar></Navbar>
        <Switch>
          <Route exact path='/' component={Home}></Route>
          <Route exact path='/WorkPlaces/:workPlaceId' component={WorkPlaces}></Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
