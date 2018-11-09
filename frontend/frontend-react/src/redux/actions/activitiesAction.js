import {apiUrl} from '../../requests/utils'

const ACTIVITIES_REQUEST = 'ACTIVITIES_REQUEST';
const ACTIVITIES_SUCCESS = 'ACTIVITIES_SUCCESS';
const ACTIVITIES_FAILURE = 'ACTIVITIES_FAILURE';

const POST_ACTIVITY_REQUEST = 'POST_ACTIVITY_REQUEST';
const POST_ACTIVITY_SUCCESS = 'POST_ACTIVITY_SUCCESS';
const POST_ACTIVITY_FAILURE = 'POST_ACTIVITY_FAILURE';

const DELETE_ACTIVITY_REQUEST = 'DELETE_ACTIVITY_REQUEST';
const DELETE_ACTIVITY_SUCCESS = 'DELETE_ACTIVITY_SUCCESS';
const DELETE_ACTIVITY_FAILURE = 'DELETE_ACTIVITY_FAILURE';


function activitiesRequest(){
    return {
        type: ACTIVITIES_REQUEST
    }
}

function activitiesSuccess(activities){
    return {
        type: ACTIVITIES_SUCCESS,
        activities: activities
    }
}

function activitiesFailure(){
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

function postActivityRequest(){
    return {
        type: POST_ACTIVITY_REQUEST
    }
}

function postActivitySuccess(){
    return {
        type: POST_ACTIVITY_SUCCESS,
    }
}

function postActivityFailure(){
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


function deleteActivityRequest(){
    return {
        type: DELETE_ACTIVITY_REQUEST
    }
}

function deleteActivitySuccess(){
    return {
        type: DELETE_ACTIVITY_SUCCESS,
    }
}

function deleteActivityFailure(){
    return {
        type: DELETE_ACTIVITY_FAILURE
    }
}

export function deleteActivity(username,password,activity){
    console.log("Delete activity");

    return function (dispatch){

        dispatch(deleteActivityRequest());

        const loginHeader = {
            method: 'DELETE',
            headers: {
                'Authorization': 'Basic '+ btoa( username + ':' + password)
              }
        }

        console.log(apiUrl + '/user/activities/delete/' + activity);
        return fetch(apiUrl + '/user/activities/delete/' + activity,loginHeader)
                .then((response) => {
                    console.log(response.status)
                    if (response.ok){
                        dispatch(deleteActivitySuccess())
                        dispatch(getActivities(username,password))
                    } else {
                        dispatch(deleteActivityFailure())
                    }        
                },
                    error => {
                        console.log('An error occurred.', error);
                        dispatch(deleteActivityFailure())
                    }
                )
    }
}