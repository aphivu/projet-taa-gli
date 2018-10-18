import React from 'react'
import { connect } from 'react-redux'
import HomePage from '../../components/HomePage'
import { getSports } from '../actions/sportsActions'
import { getActivities, postActivity } from '../actions/activitiesAction'
import { getLocalisations } from '../actions/localisationAction'

const HomePageContainer = (props) => (
    <HomePage activities={props.activities.activities} 
        sports = {props.sports.sports}
        localisations = {props.localisations.localisations}
        user = {props.user}
        getActivities = {props.getActivities}
        getSports = {props.getSports}
        getLocalisations = {props.getLocalisations}
        postActivity = {props.postActivity} 
    />
)

const mapStateToProps = state => ({
    activities: state.activities,
    sports: state.sports,
    localisations: state.localisations,
    user: state.user
})

const mapDispatchToProps = dispatch => {
    return {
        getSports: (user) => {
            dispatch(getSports(user.username,user.password));
        },
        getActivities: (user) => {
            dispatch(getActivities(user.username, user.password))
        },
        getLocalisations: (user) => {
            dispatch(getLocalisations(user.username,user.password))
        },
        postActivity: (user, sport, localisation) => {
            dispatch(postActivity(user.username,user.password,sport,localisation))
        }
    }
}


export default connect(
    mapStateToProps,
    mapDispatchToProps
)(HomePageContainer)