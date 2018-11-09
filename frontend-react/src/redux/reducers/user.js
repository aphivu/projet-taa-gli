
const initialState = { 
    username:'',
    password:'',
    authenticated:false, 
    isLogging: false
}

export function user(state = initialState,action){

    switch (action.type){

        case "LOGIN_REQUEST":
            return Object.assign({}, state, { 
                isLogging: true
            })

        case "LOGIN_SUCCESS":
        console.log("login success")
            return Object.assign({}, state, {
                username:action.username,
                password:action.password,
                authenticated:true,
                isLogging: false
            })
        case "LOGIN_FAILURE":
            return Object.assign({}, state, {
                username:initialState.username,
                password:initialState.password,
                authenticated:false,
                isLogging:false
            })

        default:
            return state;
    }
}