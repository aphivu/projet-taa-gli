import React from 'react'
import { connect } from 'react-redux'
import HomePage from '../../components/HomePage'
import {getSports} from '../actions/sportsActions'

const HomePageContainer = (props) => (
    <HomePage sports={props.sports.sports} getSports={props.getSports} user={props.user}/>
)

const mapStateToProps = state => ({
    sports: state.sports,
    user: state.user
})

const mapDispatchToProps = dispatch => {
    return {
        getSports: (user) => {
            dispatch(getSports(user.username,user.password));
        }
    }
}


export default connect(
    mapStateToProps,
    mapDispatchToProps
)(HomePageContainer)