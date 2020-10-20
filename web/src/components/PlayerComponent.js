import React from 'react';
import PlayerService from '../services/PlayerService';

class PlayerComponent extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            players: []
        }
    }

    // lifecycle method we can use to call rest api
    componentDidMount() {
        PlayerService.getAllPlayers().then((response) => {
            this.setState({players: response.data})
        })
    }

    render () {
        return (
            <div>
                <h1 className = "text-center">Players List</h1>
                <table className= "table table-striped">
                    <thead>
                        <tr>
                            <td>First Name</td>
                            <td>Last Name</td>
                            <td>Position</td>
                            <td>Height</td>
                            <td>Weight</td>
                            <td>Age</td>
                            <td>Player ID</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.players.map (
                                player =>
                                <tr key = {player.playerId}>
                                    <td>{player.firstName}</td>
                                    <td>{player.lastName}</td>
                                    <td>{player.position}</td>
                                    <td>{player.height}</td>
                                    <td>{player.weight}</td>
                                    <td>{player.age}</td>
                                    <td>{player.playerId}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
            </div>
        )
    }
}

export default PlayerComponent;