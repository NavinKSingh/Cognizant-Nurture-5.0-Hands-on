import React from 'react';
import '../Stylesheets/mystyle.css';

function CalculateScore(props) {
    const average = props.Total / props.goal;

    return (
        <div className="score-container">
            <h2>Student Score Card</h2>
            <p><strong>Name:</strong> {props.Name}</p>
            <p><strong>School:</strong> {props.School}</p>
            <p><strong>Total Marks:</strong> {props.Total}</p>
            <p><strong>Goal (No. of Subjects):</strong> {props.goal}</p>
            <p className="average">Average Score: {average.toFixed(2)}</p>
        </div>
    );
}

export default CalculateScore;
