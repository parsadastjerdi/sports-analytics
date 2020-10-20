import React from 'react';
import './App.css';
import CoachComponent from './components/CoachComponent';
import GameComponent from './components/GameComponent';
import PlayerComponent from './components/PlayerComponent';
import SeasonComponent from './components/SeasonComponent';
import TeamComponent from './components/TeamComponent';

function App() {
  return (
    <div className="App">
      <PlayerComponent />
      <TeamComponent />
      <CoachComponent />
      <SeasonComponent />
      <GameComponent />
    </div>
  );
}

export default App;
