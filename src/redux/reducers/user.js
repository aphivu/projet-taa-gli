import login from '../../requests/loginRequest'

const initialState = { 
    user: {
        username:'',
        password:'',
        authenticated:false
    }
}

export function user(state = initialState,action){
    console.log(state);

    switch (action.type){

        case "LOGIN":
        console.log("ReducerUser")
            if (!login(action.username,action.password)) {
                console.log("login no ok");
                return initialState;
            }
            console.log("login ok!")
            return { ...state, user :{
                username:action.username,
                password:action.password,
                authenticated:true
            }}

        default:
            return state;
    }
}