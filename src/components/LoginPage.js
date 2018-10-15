import React from 'react'
import { Redirect } from 'react-router-dom'


export default class LoginPage extends React.Component {
    constructor(props){
        super(props);
        this.state= { 
          username:'',
          password:''
      }
    }
    
    handleUsername = (e) => {
      this.setState({username:e.target.value})
    }
    handlePassword = (e) => {
      this.setState({password:e.target.value})
    }

    handleSubmit = (e) => {
      e.preventDefault();
      this.props.handleSubmit(this.state);
    }

      render() {
       const authenticated = this.props.user.authenticated;

        if (authenticated){
          console.log("authenticated")
            return (
              <Redirect to='/home' />
            )
        }
      
        return (
    
            <div>
              <h1>Login </h1>
              <form onSubmit={this.handleSubmit}>
                <p>Username: </p>
                <input type="text" onChange = {this.handleUsername} />
                <p>Password: </p>
                <input type="password" onChange = {this.handlePassword} />
                <br/>
                <br/>
                <input type="submit" value="Login"/>
              </form>
            </div>
        );
      }

}

