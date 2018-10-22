import React from 'react';
import '../App.css';
import '../HomePage.css';

export default class HomePage extends React.Component{
    
    constructor(props){
        super (props);
        this.state = {
            sport:'',
            localisation:''
        }
    }

    componentWillMount(){
        console.log("Will Mount")
        console.log(this.props)
        this.props.getSports(this.props.user);
        this.props.getActivities(this.props.user);
        this.props.getLocalisations(this.props.user);
    }

    handleSubmit = (e) => {
        e.preventDefault();
        this.props.postActivity(this.props.user,this.state.sport,this.state.localisation)
    }

    handleSport = (e) => {
        this.setState({sport:e.target.value})
    }

    handleLocalisation = (e) => {
        this.setState({localisation:e.target.value})
    }

    render(){
        console.log("Home render")
        console.log(this.props.user)
        console.log(this.props.sports);
        const sports = this.props.sports;
        console.log(this.props.activities);
        const activities = this.props.activities;
        const localisations = this.props.localisations;
        console.log(localisations);
        return (
            <div className="App">
                <h1>
                    Home
                </h1>
                <h2>
                    My activities
                </h2>
                <table align="center">
                    <tr>
                        <th>
                            <strong>Sport</strong>
                        </th>
                        <th>
                            <strong>Localisation</strong>
                        </th>                
                    </tr>
                        {activities.map(activity =>
                    <tr>
                        <td>
                            {activity.sport.name}
                        </td>
                        <td>
                            {activity.localisation.ville}
                        </td>
                    </tr>
                    )}
                   
                </table>
                <form onSubmit={this.handleSubmit}>
                    <div className="AddActivity">
                        <span>
                            <select className="selectActivity" onChange={this.handleSport}>
                                {sports.map(sport =>
                                    <option value={sport.name}>{sport.name}</option>
                                )}
                            </select>
                            &nbsp;
                            <select className="selectActivity" onChange={this.handleLocalisation}>
                                {localisations.map(localisation =>
                                    <option value={localisation.ville}>{localisation.ville}</option>
                                )}
                            </select>
                            &nbsp;
                            <input type="submit" value="Add" className="submitActivity"></input>
                        </span>
                    </div>
                </form>
            </div>
        )
    }
}