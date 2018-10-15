import React from 'react'
import { connect } from 'react-redux'
import HomePage from '../../components/HomePage'
import {getSports} from '../actions/sportsActions'

const HomePageContainer = (props) => (
    <HomePage sports={props.sports}/>
)

const mapStateToProps = state => ({
    sports: state.sports,
    authenticated: state.user.authenticated
})

const mapDispatchToProps = dispatch => {
    return {
        getSports: () => {
            dispatch(getSports());
        }
    }
}


export default connect(
    mapStateToProps,
    mapDispatchToProps
)(HomePageContainer)