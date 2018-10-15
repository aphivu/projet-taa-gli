import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import {Provider} from 'react-redux';
import { BrowserRouter as Router, Route} from "react-router-dom";

import configureStore from './redux/store/configureStore'
import HomePageContainer from './redux/containers/HomePageContainer';
import LoginPageContainer from './redux/containers/LoginPageContainer';

const store = configureStore();

/*const SecretRoute = ({ component: Component, ...rest }, isAuth) => (
    <Route {...rest} render={(props) => (
      isAuth
        ? <Component {...props} />
        : <Redirect to='/login' />
    )} />
  );*/

ReactDOM.render(
    <Provider store={store}>
         <Router>
            <div>
                <Route exact path='/' component = {App} />
                <Route path='/login' component = {LoginPageContainer}/>
                <Route path='/home' component = {HomePageContainer} />
            </div>
            
        </Router>
    </Provider>
    , document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
