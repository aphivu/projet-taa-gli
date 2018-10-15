import { combineReducers } from 'redux';
import { sports } from './sports';
import { user } from './user';

const rootReducer = combineReducers({sports,user});

export default rootReducer;