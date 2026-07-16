import React from 'react';

function sayWelcomeMessage(message) {
    alert(message);
}

function SayWelcome() {
    return (
        <div>
            <h2>Say Welcome</h2>
            <button onClick={() => sayWelcomeMessage('welcome')}>
                Say Welcome
            </button>
        </div>
    );
}

export default SayWelcome;
