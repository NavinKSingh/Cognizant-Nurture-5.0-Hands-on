import React from 'react';

const flights = [
    { id: 1, name: 'Air India AI101', from: 'Delhi', to: 'Mumbai', time: '08:00 AM' },
    { id: 2, name: 'IndiGo 6E202', from: 'Bengaluru', to: 'Chennai', time: '10:30 AM' },
    { id: 3, name: 'SpiceJet SG303', from: 'Mumbai', to: 'Kolkata', time: '01:15 PM' }
];

function FlightDetails(props) {
    return (
        <div>
            <h2>Available Flights</h2>
            <ul>
                {flights.map((flight) => (
                    <li key={flight.id}>
                        {flight.name} | {flight.from} to {flight.to} | {flight.time}
                        {/* Booking option is only rendered for logged-in users */}
                        {props.showBooking && (
                            <button style={{ marginLeft: '10px' }}>Book Ticket</button>
                        )}
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default FlightDetails;
