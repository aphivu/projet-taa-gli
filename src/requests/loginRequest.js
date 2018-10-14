import {apiUrl} from './utils'

export default function login(username,password){
    console.log("Login");
    const obj = {
        method: 'POST',
        headers: {
          'Authorization': 'Basic '+ btoa(username+':'+password),
        }
    }

    return fetch(apiUrl + '/loginApp',obj)
        .then((response) => {
            console.log(response.status)
            if (response.status === 401) { 
                console.log("unhautorized");
                return false;}
            response.json()
        })
        .then((responseJson) => {
            console.log("Value")
            console.log(responseJson);
          return false;
        })
        .catch((error) => {
          console.error("error");
          return false;
        });
}