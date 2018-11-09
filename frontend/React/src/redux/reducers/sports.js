const initialState = { 
    sports: [],
    isFetchingSport: false    
}

export function sports(state=initialState,action){

    switch(action.type){

        case 'SPORTS_REQUEST':{
            console.log("sports request")
            return Object.assign({}, state, { 
                isFetchingSport: true
            })
        }

        case 'SPORTS_SUCCESS':{
            console.log("sport success")
            return Object.assign({}, state, { 
                sports: action.sports,
                isFetchingSport: false
            })
        }

        case 'SPORTS_FAILURE':{
            return Object.assign({}, state, {
                isFetchingSport: false
            })
        }

        default: 
            return state
    }
}