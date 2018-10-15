import React, { Component } from 'react';
import './App.css';
import { connect } from 'react-redux'
import { Link } from 'react-router-dom' 

class App extends Component {

  constructor(props){
    super(props);
    this.state = { authenticated: this.props.authenticated}
  }
  
  renderLogin = () => {
    if (!this.state.authenticated) {
      return <Link to="/login"><button>Login</button></Link>
    }
  }
  
  render() {

    return (
      <div className="App">
        <header>
          {this.renderLogin()}
        </header>

        <hr />
        
      </div>
    );
  }
}


const mapStateToProps = state => ({
  authenticated: state.user.authenticated
})

export default connect(
  mapStateToProps
)(App)
