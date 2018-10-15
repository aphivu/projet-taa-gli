import React from 'react'

export default class HomePage extends React.Component{

    componentWillMount(){
        console.log("Will Mount")
        console.log(this.props)
        this.props.getSports(this.props.user);
    }

    render(){
        console.log("Home render")
        console.log(this.props.sports);
        const sports = this.props.sports;
        return (
            <div>
                <h1>
                    Home
                </h1>
                <ul>
                    <h2>Sport list</h2>
                    {sports.map(sport =>
                    <li>{sport.name}</li>
                    )}
                </ul>
            </div>
        )
    }
}