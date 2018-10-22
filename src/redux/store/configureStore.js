import { createStore, applyMiddleware } from 'redux'
import { createLogger } from 'redux-logger' // This will log into our console information about redux actions & store
import thunk from 'redux-thunk'
import { persistStore, persistReducer } from 'redux-persist'
import storage from 'redux-persist/lib/storage' // defaults to localStorage for web and AsyncStorage for react-native
import rootReducer from '../reducers/rootReducer'

const persistConfig = {
    key: 'root',
    storage,
    blacklist: ['sports','localisations','activities']
}

const persistedReducer = persistReducer(persistConfig, rootReducer)

const middlewares = applyMiddleware(thunk, createLogger())

export const store = createStore(persistedReducer,middlewares);
export const persistore = persistStore(store);

