import {apiUrl} from '../../requests/utils'

const SPORTS_REQUEST = 'SPORTS_REQUEST';
const SPORTS_SUCCESS = 'SPORTS_SUCCESS';
const SPORTS_FAILURE = 'SPORTS_FAILURE';

export function sportsRequest(){
    return {
        type: SPORTS_REQUEST
    }
}

export function sportsSuccess(sports){
    return {
        type: SPORTS_SUCCESS,
        sports: sports
    }
}

export function sportsFailure(){
    return {
        type: SPORTS_FAILURE
    }
}

export function getSports(){
    console.log("Get Sports");

    return function (dispatch){

        dispatch(sportsRequest());

        const loginHeader = {
            method: 'GET'
        }

        return fetch(apiUrl + '/user/sports',loginHeader)
                .then((response) => {
                    console.log(response.status)
                    if (response.ok){
                        response.json()
                        console.log('Response ok')
                        .then((responseJson) => {
                            dispatch(sportsSuccess(responseJson))
                        });
                    } else {
                        dispatch(sportsFailure())
                    }        
                },
                    error => {
                        console.log('An error occurred.', error);
                        dispatch(sportsFailure())
                    }
                )
    }
}