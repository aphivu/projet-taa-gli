const initialState = { 
    localisations: [],
    isFetchingLocalisation: false    
}

export function localisations(state=initialState,action){

    switch(action.type){

        case 'LOCALISATIONS_REQUEST':{
            console.log("localisation request")
            return Object.assign({}, state, { 
                isFetchingLocalisation: true
            })
        }

        case 'LOCALISATIONS_SUCCESS':{
            console.log("localisation success")
            return Object.assign({}, state, { 
                localisations: action.localisations,
                isFetchingLocalisation: false
            })
        }

        case 'LOCALISATIONS_FAILURE':{
            return Object.assign({}, state, {
                isFetchingLocalisation: false
            })
        }

        default: 
            return state
    }
}