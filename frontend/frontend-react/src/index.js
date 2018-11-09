import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {Provider} from 'react-redux';
import { BrowserRouter as Router, Route} from "react-router-dom";
import { PersistGate } from 'redux-persist/integration/react';

import { store, persistore } from './redux/store/configureStore'
import LoginPageContainer from './redux/containers/LoginPageContainer';

ReactDOM.render(
    <Provider store={store}>
        <PersistGate loading={null} persistor={persistore}>
            <Router>
                <div>
                    <Route 
                        exact path='/' 
                        render={(props) => 
                        <App />} 
                    /> 
                    <Route path='/login' component = {LoginPageContainer}/>
                </div>
            </Router>
        </PersistGate>
    </Provider>
    , document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
