import React from 'react'
import { connect } from 'react-redux'
import LoginPage from '../../components/LoginPage'
import {login} from '../actions/userAction'

const LoginPageContainer = (props) => (
    <LoginPage authenticated = {props.authenticated} handleSubmit={props.handleSubmit}/>
)

const mapStateToProps = state => ({
    authenticated: state.user.authenticated
})

const mapDispatchToProps = dispatch => {
    return {
        handleSubmit: (user) => {
            dispatch(login(user.username,user.password));
        }
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(LoginPageContainer)