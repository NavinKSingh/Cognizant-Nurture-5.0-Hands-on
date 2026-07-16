import React from 'react';

function LoginButton(props) {
    return <button onClick={props.onClick}>Login</button>;
}

function LogoutButton(props) {
    return <button onClick={props.onClick}>Logout</button>;
}

function LoginControl(props) {
    if (props.isLoggedIn) {
        return <LogoutButton onClick={props.onLogoutClick} />;
    }
    return <LoginButton onClick={props.onLoginClick} />;
}

export default LoginControl;
