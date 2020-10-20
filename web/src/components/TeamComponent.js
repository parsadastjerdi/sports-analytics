import React from 'react';
import TeamService from '../services/TeamService';

class TeamComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            teams: []
        }
    }

    componentDidMount() {
        TeamService.getAllTeams().then((response) => {
            this.setState({teams: response.data})
        })
    }

    render() {
        return <div>
            <h1>Teams List</h1>
            <table className= "table table-striped">
                    <thead>
                        <tr>
                            <td>Team Name</td>
                            <td>Team City</td>
                            <td>Team Conference</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.teams.map (
                                team =>
                                <tr key = {team.teamId}>
                                    <td>{team.name}</td>
                                    <td>{team.city}</td>
                                    <td>{team.conference}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
        </div>
    }
}

export default TeamComponent;