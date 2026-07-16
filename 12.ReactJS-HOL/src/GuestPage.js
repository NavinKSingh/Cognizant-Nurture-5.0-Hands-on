import React from 'react';
import FlightDetails from './FlightDetails';

function GuestPage() {
    return (
        <div>
            <h3>Welcome, Guest</h3>
            <p>Please login to book tickets.</p>
            <FlightDetails showBooking={false} />
        </div>
    );
}

export default GuestPage;
