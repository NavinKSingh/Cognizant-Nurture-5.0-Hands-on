import React from 'react';

function OnPressButton() {
    // "event" here is React's SyntheticEvent, a cross-browser wrapper
    // around the browser's native event
    function OnPress(event) {
        alert('I was clicked');
    }

    return (
        <div>
            <h2>Synthetic Event Example</h2>
            <button onClick={OnPress}>Click Me</button>
        </div>
    );
}

export default OnPressButton;
