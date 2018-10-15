import { createStore, applyMiddleware } from 'redux'
import { createLogger } from 'redux-logger' // This will log into our console information about redux actions & store
import thunk from 'redux-thunk'
import rootReducer from '../reducers/rootReducer'

const middlewares = applyMiddleware(thunk, createLogger())

export default function configureStore(preloadedState = {}) { 
    const store = createStore(rootReducer,middlewares);
    /*console.log("store config: ")
    console.log(store.getState());*/
    return store;
}

