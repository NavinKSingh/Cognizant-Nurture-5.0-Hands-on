import React, { Component } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';
import LoginControl from './LoginControl';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = { isLoggedIn: false };

        this.handleLoginClick = this.handleLoginClick.bind(this);
        this.handleLogoutClick = this.handleLogoutClick.bind(this);
    }

    handleLoginClick() {
        this.setState({ isLoggedIn: true });
    }

    handleLogoutClick() {
        this.setState({ isLoggedIn: false });
    }

    render() {
        const isLoggedIn = this.state.isLoggedIn;

        // Element variable: decides which page component to render
        let content;
        if (isLoggedIn) {
            content = <UserPage />;
        } else {
            content = <GuestPage />;
        }

        return (
            <div>
                <h1>Ticket Booking App</h1>
                <LoginControl
                    isLoggedIn={isLoggedIn}
                    onLoginClick={this.handleLoginClick}
                    onLogoutClick={this.handleLogoutClick}
                />
                {content}
            </div>
        );
    }
}

export default App;
