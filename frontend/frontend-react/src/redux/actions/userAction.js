import fetch from 'cross-fetch'
import {apiUrl} from '../../requests/utils'

const LOGIN_REQUEST = 'LOGIN_REQUEST';
const LOGIN_SUCCESS = 'LOGIN_SUCCESS';
const LOGIN_FAILURE = 'LOGIN_FAILURE';

const LOGOUT_SUCCESS = 'LOGOUT_SUCCESS';



function loginRequest(username,password){
    return {
        type: LOGIN_REQUEST,
        username: username,
        password: password
    }
}

function loginSucess(username, password){
    return {
        type: LOGIN_SUCCESS,
        username:username,
        password:password
    }
}

function loginFailure(){
    return {
        type: LOGIN_FAILURE 
    }
}



export function login(username,password){
    console.log("Login");

    return function (dispatch){

        dispatch(loginRequest(username,password));

        const loginHeader = {
            method: 'POST',
            headers: {
              'Authorization': 'Basic '+ btoa(username + ':' + password)
            }
        }

        console.log(apiUrl)
        return fetch(apiUrl + '/loginApp',loginHeader)
                .then((response) => {
                    if (response.ok){
                        response.json()
                        .then((responseJson) => {
                            if (responseJson){
                                console.log("response ok")
                                dispatch(loginSucess(username,password))
                            }
                            else {
                                dispatch(loginFailure())
                            }
                        });
                    } else {
                        dispatch(loginFailure())
                    }        
                },
                    error => {
                        console.log('An error occurred.', error);
                        dispatch(loginFailure())
                    }
                )
    }
}

function logoutSucess(){
    return { 
        type : LOGOUT_SUCCESS
    }
}


export function logout(){
    console.log("Logout");

    return function (dispatch){

        dispatch(logoutSucess())

    }


}