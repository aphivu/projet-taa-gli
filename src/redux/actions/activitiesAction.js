import {apiUrl} from '../../requests/utils'

const ACTIVITIES_REQUEST = 'ACTIVITIES_REQUEST';
const ACTIVITIES_SUCCESS = 'ACTIVITIES_SUCCESS';
const ACTIVITIES_FAILURE = 'ACTIVITIES_FAILURE';

const POST_ACTIVITY_REQUEST = 'POST_ACTIVITY_REQUEST';
const POST_ACTIVITY_SUCCESS = 'POST_ACTIVITY_SUCCESS';
const POST_ACTIVITY_FAILURE = 'POST_ACTIVITY_FAILURE';


export function activitiesRequest(){
    return {
        type: ACTIVITIES_REQUEST
    }
}

export function activitiesSuccess(activities){
    return {
        type: ACTIVITIES_SUCCESS,
        activities: activities
    }
}

export function activitiesFailure(){
    return {
        type: ACTIVITIES_FAILURE
    }
}

export function getActivities(username,password){
    console.log("Get Activities");

    return function (dispatch){

        dispatch(activitiesRequest());

        const loginHeader = {
            method: 'GET',
            headers: {
                'Authorization': 'Basic '+ btoa( username + ':' + password)
              }
        }

        return fetch(apiUrl + '/user/activities',loginHeader)
                .then((response) => {
                    console.log(response.status)
                    if (response.ok){
                        console.log('Response ok');
                        response.json()
                        .then((responseJson) => {
                            dispatch(activitiesSuccess(responseJson))
                        });
                    } else {
                        dispatch(activitiesFailure())
                    }        
                },
                    error => {
                        console.log('An error occurred.', error);
                        dispatch(activitiesFailure())
                    }
                )
    }
}

export function postActivityRequest(){
    return {
        type: POST_ACTIVITY_REQUEST
    }
}

export function postActivitySuccess(){
    return {
        type: POST_ACTIVITY_SUCCESS,
    }
}

export function postActivityFailure(){
    return {
        type: POST_ACTIVITY_FAILURE
    }
}

export function postActivity(username,password,sport,localisation){
    console.log("Post");

    return function (dispatch){

        dispatch(postActivityRequest());

        const loginHeader = {
            method: 'POST',
            headers: {
                'Authorization': 'Basic '+ btoa( username + ':' + password),
                'Content-Type': 'application/json'
              },
            body: JSON.stringify({
                sport: sport,
                localisation: localisation,
            })
        }

        console.log(loginHeader.body)

        return fetch(apiUrl + '/user/activities/add',loginHeader)
                .then((response) => {
                    console.log(response.status)
                    if (response.ok){
                        dispatch(postActivitySuccess())
                        dispatch(getActivities(username,password))
                    } else {
                        dispatch(postActivityFailure())
                    }        
                },
                    error => {
                        console.log('An error occurred.', error);
                        dispatch(postActivityFailure())
                    }
                )
    }
}