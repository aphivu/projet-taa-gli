const LOGIN = 'LOGIN';
export function login(username,password){
    return {
        type: LOGIN,
        username: username,
        password: password
    }
}