import login from '../../requests/loginRequest'

const initialState = { 
    user: {
        username:'',
        password:'',
        authenticated:false
    },
    isLogging: false
}

export function user(state = initialState,action){
    //console.log(state);

    switch (action.type){

        case "LOGIN_REQUEST":
            return Object.assign({}, state, { 
                isLogging: true
            })

        case "LOGIN_SUCCESS":
            return Object.assign({}, state, {
                user:{
                    username:action.username,
                    password:action.password,
                    authenticated:true
                },
                isLogging: false
            })
        case "LOGIN_FAILURE":
            return Object.assign({}, state, {
                user: initialState.user,
                isLogging: false
            })

        default:
            return state;
    }
}