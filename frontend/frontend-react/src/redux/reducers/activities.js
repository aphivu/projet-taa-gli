const initialState = { 
    activities: [],
    isFetchingActivities: false,
    isPostingActivity: false  ,
    isDeletingActivity: false  
}

export function activities(state=initialState,action){

    switch(action.type){

        case 'ACTIVITIES_REQUEST':{
            console.log("activites request")
            return Object.assign({}, state, { 
                isFetchingActivities: true
            })
        }

        case 'ACTIVITIES_SUCCESS':{
            console.log("activities success")
            return Object.assign({}, state, { 
                activities: action.activities,
                isFetchingActivities: false
            })
        }

        case 'ACTIVITIES_FAILURE':{
            return Object.assign({}, state, {
                isFetchingActivities: false
            })
        }

        case 'POST_ACTIVITY_REQUEST': {
            console.log("post activity")
            return Object.assign({}, state, {
                isPostingActivity:true
            })

        }

        case 'POST_ACTIVITY_SUCCESS': {
            return Object.assign({}, state, {
                isPostingActivity:false
            })
        }

        case 'POST_ACTIVITY_FAILURE': {
            return Object.assign({}, state, {
                isPostingActivity:false
            })
        }

        case 'DELETE_ACTIVITY_REQUEST':{
            return Object.assign({}, state, {
                isDeletingActivity:true
            })
        }

        case 'DELETE_ACTIVITY_SUCCESS':{
            return Object.assign({}, state, {
                isDeletingActivity:false
            })
        }

        case 'DELETE_ACTIVITY_FAILURE':{
            return Object.assign({}, state, {
                isDeletingActivity:false
            })
        }

        default: 
            return state
    }
}