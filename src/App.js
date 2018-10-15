import React, { Component } from 'react';
import './App.css';
import { connect } from 'react-redux'
import { Link, Route } from 'react-router-dom' 
import HomePageContainer from './redux/containers/HomePageContainer';

class App extends Component {
  
  renderLogin = () => {
    return (!this.props.isAuthed) ? 
      <Link to="/login"><button>Login</button></Link> :
      <button>Logout</button>
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
    if (this.props.isAuthed){
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
