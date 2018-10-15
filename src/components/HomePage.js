import React from 'react'

export default class HomePage extends React.Component{

    componentDidMount(){
        console.log("Componentdidmount")
        //this.props.getSports();
    }

    render(){

        const sports = this.props.sports;
        return (
            <div>
                <h1>
                    Home
                </h1>
                <ul>
                </ul>
            </div>
        )
    }
}