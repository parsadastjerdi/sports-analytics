import React from 'react';
import CoachService from '../services/CoachService';

class CoachComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            coaches: []
        }
    }

    componentDidMount() {
        CoachService.getAllCoaches().then((response) => {
            this.setState({coaches: response.data})
        })
    }

    render() {
        return <div>
            <h1>Coaches List</h1>
            <table className= "table table-striped">
                    <thead>
                        <tr>
                            <td>Coach Name</td>
                            <td>Coach Age</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.coaches.map (
                                coach =>
                                <tr key = {coach.coachId}>
                                    <td>{coach.name}</td>
                                    <td>{coach.age}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
        </div>
    }
}

export default CoachComponent;