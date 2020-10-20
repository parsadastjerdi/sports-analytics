import React from 'react';
import './App.css';
import CoachComponent from './components/CoachComponent';
import GameComponent from './components/GameComponent';
import PlayerComponent from './components/PlayerComponent';
import SeasonComponent from './components/SeasonComponent';
import Tabs from './components/TabsComponent';
import TeamComponent from './components/TeamComponent';

function App() {
  return (
    <div className="App">
      <h1 className = "text-center">SportsBook</h1>
      <Tabs>
        <div label="player">
          <PlayerComponent />
        </div>

        <div label="team">
          <TeamComponent />
        </div>

        <div label="coach">
          <CoachComponent />
        </div>

        <div label="game">
          <GameComponent />
        </div>

        <div label="season">
          <SeasonComponent />
        </div>

        <div label="queries">
          
        </div>

      </Tabs>
    </div>
  );
}

export default App;
