import { combineReducers } from 'redux';
import { sports } from './sports';
import { user } from './user';
import { activities } from './activities';
import { localisations } from './localisations';
import storage from 'redux-persist/lib/storage'

const appreducer = combineReducers({sports,user,activities,localisations});

const rootReducer = (state, action) => {
    
    if (action.type === "LOGOUT_SUCCESS"){
        Object.keys(state).forEach(key => {
            storage.removeItem(`persist:${key}`);
        });
        state = undefined
    }

    return appreducer(state,action)
}

//const rootReducer = combineReducers({sports,user,activities,localisations});

export default rootReducer;