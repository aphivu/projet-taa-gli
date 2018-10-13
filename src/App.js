import React, { Component } from 'react';
import logo from './logo.svg';
import './App.css';
import LoginPage from './components/LoginPage';
import LoginPageContainer from './redux/containers/LoginPageContainer'

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src={logo} className="App-logo" alt="logo" />
        <LoginPageContainer />
        </header>
      </div>
    );
  }
}

export default App;
