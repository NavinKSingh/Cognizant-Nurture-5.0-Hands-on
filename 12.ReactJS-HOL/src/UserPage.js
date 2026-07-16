import React from 'react';
import FlightDetails from './FlightDetails';

function UserPage() {
    return (
        <div>
            <h3>Welcome back!</h3>
            <p>You can now book your flight tickets.</p>
            <FlightDetails showBooking={true} />
        </div>
    );
}

export default UserPage;
