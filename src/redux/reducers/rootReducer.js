import { combineReducers } from 'redux';
import { sports } from './sports';
import { user } from './user';
import { activities } from './activities';
import { localisations } from './localisations';

const rootReducer = combineReducers({sports,user,activities,localisations});

export default rootReducer;