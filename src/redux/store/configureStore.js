import { createStore, applyMiddleware } from 'redux'
import { createLogger } from 'redux-logger' // This will log into our console information about redux actions & store
import thunk from 'redux-thunk'
import {user} from '../reducers/user'

const middlewares = applyMiddleware(thunk, createLogger())

export default function configureStore(preloadedState = {}) { 
    const store = createStore(user,middlewares);
    console.log("store config: ")
    console.log(store.getState());
    return store;
}

