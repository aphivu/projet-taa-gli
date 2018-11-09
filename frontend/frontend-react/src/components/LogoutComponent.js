import React from 'react'

export default class LogoutComponent extends React.Component {

    render(){
        return (
            <div>
                <button onClick={this.handleOnClick}>Logout</button>
            </div>
        )
    }

    handleOnClick = () => {
        this.props.handleOnClick(this.props.user);
    }
}

