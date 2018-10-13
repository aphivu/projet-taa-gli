import React from 'react'


export default class LoginPage extends React.Component {
    constructor(props){
        super(props);
        this.state= { 
          username:'',
          password:'',
          authenticated:false
      }
    }
    
    handleUsername = (e) => {
      this.setState({username:e.target.value})
    }
    handlePassword= (e) => {
      this.setState({password:e.target.value})
    }

    login = (e) => {
      console.log("Login is called");
      e.preventDefault();

      let obj = {
        method: 'POST',
        headers: {
          'Authorization': 'Basic '+ btoa(this.state.username+':'+this.state.password),
        }
      }

      fetch('http://localhost:8080/loginApp', obj)  
        .then((response) => response.json())
        .then((responseJson) => {
          console.log("rep: " + responseJson);
          this.setState({authenticated:responseJson});
          //return responseJson;
        })
        .catch((error) => {
          console.error(error);
        });
    }

    handleSubmit = (e) => {
      console.log("handleSubmitComponent");
      e.preventDefault();
      this.props.handleSubmit(this.state);
    }

      render() {
       // const authenticated = this.state.authenticated;
       const authenticated = this.props.user.authenticated;

        if (authenticated){
            return (
              <div>
                <p>Authenticated</p>
              </div>
            )
        }
      
        return (

          
          <div className="App">
            <header className="App-header">
              <h1 className="App-title">Welcome to React</h1>
            </header>
            <div>
              <h2>Sport List</h2>
              <form onSubmit={this.handleSubmit}>
                <input type="text" onChange = {this.handleUsername} />
                <input type="password" onChange = {this.handlePassword} />
                <input type="submit"/>
              </form>
            </div>
          </div>
        );
      }

}

