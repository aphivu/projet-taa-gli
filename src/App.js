import React, { Component } from 'react';
import './App.css';
import { connect } from 'react-redux'
import { Link } from 'react-router-dom' 
import HomePageContainer from './redux/containers/HomePageContainer';
import LogoutComponentContainer from './redux/containers/LogoutComponentContainer';

class App extends Component {
  
  renderLogin = () => {
    return (!this.props.authenticated) ? 
      <Link to="/login"><button>Login</button></Link> :
      <LogoutComponentContainer />
  }

  
  render() {

    console.log("App render")
    
    return (
      <div className="App">
        <header>
          {this.renderLogin()}
        </header>

        <hr />
        
        {this.content()}
        
      </div>
    );
  }

  content() {
    if (this.props.authenticated){
      return (
        <HomePageContainer />
      )
    }
    return (
      <h1>
          Welcome to TAA Week-end
        </h1>
    )
  }
}


const mapStateToProps = state => ({
  authenticated: state.user.authenticated
})

export default connect(
  mapStateToProps
)(App)
