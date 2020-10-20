import React from 'react';
import GameService from '../services/GameService';

class GameComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            games: []
        }
    }

    componentDidMount() {
        GameService.getAllGames().then((response) => {
            this.setState({games: response.data})
        })
    }

    render() {
        return <div>
            <h1>Games List</h1>
            <table className= "table table-striped">
                    <thead>
                        <tr>
                            <td>Venue</td>
                            <td>Game Date</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.games.map (
                                game =>
                                <tr key = {game.gameId}>
                                    <td>{game.venue}</td>
                                    <td>{game.gameDate}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
        </div>
    }
}

export default GameComponent;