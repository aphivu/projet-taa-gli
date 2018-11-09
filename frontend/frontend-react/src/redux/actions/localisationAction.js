import {apiUrl} from '../../requests/utils'

const LOCALISATIONS_REQUEST = 'LOCALISATIONS_REQUEST';
const LOCALISATIONS_SUCCESS = 'LOCALISATIONS_SUCCESS';
const LOCALISATIONS_FAILURE = 'LOCALISATIONS_FAILURE';

export function localisationsRequest(){
    return {
        type: LOCALISATIONS_REQUEST
    }
}

export function localisationsSuccess(localisations){
    return {
        type: LOCALISATIONS_SUCCESS,
        localisations: localisations
    }
}

export function localisationsFailure(){
    return {
        type: LOCALISATIONS_FAILURE
    }
}

export function getLocalisations(username,password){
    console.log("Get Localisations");

    return function (dispatch){

        dispatch(localisationsRequest());

        const loginHeader = {
            method: 'GET',
            headers: {
                'Authorization': 'Basic '+ btoa( username + ':' + password)
              }
        }

        return fetch(apiUrl + '/user/localisations',loginHeader)
                .then((response) => {
                    console.log(response.status)
                    if (response.ok){
                        console.log('Response ok');
                        response.json()
                        .then((responseJson) => {
                            dispatch(localisationsSuccess(responseJson))
                        });
                    } else {
                        dispatch(localisationsFailure())
                    }        
                },
                    error => {
                        console.log('An error occurred.', error);
                        dispatch(localisationsFailure())
                    }
                )
    }
}