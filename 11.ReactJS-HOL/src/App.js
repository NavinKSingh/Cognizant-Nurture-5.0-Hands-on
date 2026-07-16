import React from 'react';
import Counter from './Counter';
import SayWelcome from './SayWelcome';
import OnPressButton from './OnPressButton';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
    return (
        <div>
            <h1>Event Examples App</h1>
            <Counter />
            <hr />
            <SayWelcome />
            <hr />
            <OnPressButton />
            <hr />
            <CurrencyConvertor />
        </div>
    );
}

export default App;
