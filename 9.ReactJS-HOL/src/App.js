import React from 'react';
import ListofPlayers from './ListofPlayers';
import IndianPlayers from './IndianPlayers';

function App() {
    // Change this to true / false to switch which component is shown
    const flag = true;

    let content;
    if (flag) {
        content = <ListofPlayers />;
    } else {
        content = <IndianPlayers />;
    }

    return (
        <div>
            <h1>Cricket App</h1>
            {content}
        </div>
    );
}

export default App;
