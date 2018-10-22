import React from 'react'
import { connect } from 'react-redux'
import LogoutComponent from '../../components/LogoutComponent'
import {logout} from '../actions/userAction'

const LogoutComponentContainer = (props) => {
    return (
    <LogoutComponent user={props.user} handleOnClick={props.handleOnClick} />
    )
}

const mapStateToProps = state => ({
    user: state.user
})

const mapDispatchToProps = dispatch => {
    return {
        handleOnClick: (user) => {
            dispatch(logout(user.username,user.password));
        }
    }
}

export default connect(
    mapStateToProps,
    mapDispatchToProps
)(LogoutComponentContainer)