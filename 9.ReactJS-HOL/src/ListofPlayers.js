import React from 'react';

const players = [
    { name: 'Rohit Sharma', score: 85 },
    { name: 'Virat Kohli', score: 92 },
    { name: 'KL Rahul', score: 45 },
    { name: 'Shreyas Iyer', score: 60 },
    { name: 'Rishabh Pant', score: 78 },
    { name: 'Hardik Pandya', score: 55 },
    { name: 'Ravindra Jadeja', score: 40 },
    { name: 'Jasprit Bumrah', score: 15 },
    { name: 'Mohammed Shami', score: 10 },
    { name: 'Kuldeep Yadav', score: 20 },
    { name: 'Shubman Gill', score: 88 }
];

function ListofPlayers() {
    // Display names and scores using the map() feature of ES6
    const playerList = players.map((player, index) => (
        <li key={index}>{player.name} - {player.score}</li>
    ));

    // Filter players with scores below 70 using an ES6 arrow function
    const lowScorePlayers = players.filter((player) => player.score < 70);

    return (
        <div>
            <h2>List of Players</h2>
            <ul>{playerList}</ul>

            <h3>Players with score below 70</h3>
            <ul>
                {lowScorePlayers.map((player, index) => (
                    <li key={index}>{player.name} - {player.score}</li>
                ))}
            </ul>
        </div>
    );
}

export default ListofPlayers;
