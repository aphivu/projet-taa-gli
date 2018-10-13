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
        .then((response) => response.json())
        .then((responseJson) => {
          return responseJson;
        })
        .catch((error) => {
          console.error(error);
          return false;
        });
}