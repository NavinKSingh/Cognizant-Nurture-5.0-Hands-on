import React from 'react';

function IndianPlayers() {
    const allPlayers = [
        'Rohit Sharma', 'Virat Kohli', 'KL Rahul', 'Shreyas Iyer',
        'Rishabh Pant', 'Hardik Pandya', 'Ravindra Jadeja', 'Jasprit Bumrah',
        'Mohammed Shami', 'Kuldeep Yadav', 'Shubman Gill'
    ];

    // Destructuring feature of ES6 to pick out individual players
    const [p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11] = allPlayers;

    const oddTeamPlayers = [p1, p3, p5, p7, p9, p11];
    const evenTeamPlayers = [p2, p4, p6, p8, p10];

    // Two separate arrays merged using the ES6 spread (merge) feature
    const T20players = ['Rohit Sharma', 'Virat Kohli', 'Hardik Pandya'];
    const RanjiTrophyPlayers = ['Shreyas Iyer', 'Ravindra Jadeja', 'Kuldeep Yadav'];
    const mergedPlayers = [...T20players, ...RanjiTrophyPlayers];

    return (
        <div>
            <h2>Indian Players</h2>

            <h3>Odd Team Players</h3>
            <ul>
                {oddTeamPlayers.map((name, index) => (
                    <li key={index}>{name}</li>
                ))}
            </ul>

            <h3>Even Team Players</h3>
            <ul>
                {evenTeamPlayers.map((name, index) => (
                    <li key={index}>{name}</li>
                ))}
            </ul>

            <h3>T20 + Ranji Trophy Players (Merged)</h3>
            <ul>
                {mergedPlayers.map((name, index) => (
                    <li key={index}>{name}</li>
                ))}
            </ul>
        </div>
    );
}

export default IndianPlayers;
