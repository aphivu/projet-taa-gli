import React from 'react'
import { connect } from 'react-redux'
import LoginPage from '../../components/LoginPage'
import {login} from '../actions/userAction'

const LoginPageContainer = (props) => (
    <LoginPage user = {props.user} handleSubmit={props.handleSubmit}/>
)

const mapStateToProps = state => ({
    user: state.user
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