import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetail from './TrainerDetails';
import TrainersData from './TrainersMock';

function App() {
    return (
        <BrowserRouter>
            <nav>
                <Link to="/">Home</Link> | <Link to="/trainers">Trainers</Link>
            </nav>
            <hr />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/trainers" element={<TrainersList trainers={TrainersData} />} />
                <Route path="/trainers/:id" element={<TrainerDetail />} />
            </Routes>
        </BrowserRouter>
    );
}

export default App;
