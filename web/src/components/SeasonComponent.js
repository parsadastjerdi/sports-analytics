import React from 'react';
import SeasonService from '../services/SeasonService';

class SeasonComponent extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            seasons: []
        }
    }

    componentDidMount() {
        SeasonService.getAllSeasons().then((response) => {
            this.setState({seasons: response.data})
        })
    }

    render() {
        return <div>
            <h1>Seasons List</h1>
            <table className= "table table-striped">
                    <thead>
                        <tr>
                            <td>Start Date</td>
                            <td>End Date</td>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            this.state.seasons.map (
                                season =>
                                <tr key = {season.seasonId}>
                                    <td>{season.startDate}</td>
                                    <td>{season.endDate}</td>
                                </tr>
                            )
                        }
                    </tbody>
                </table>
        </div>
    }
}

export default SeasonComponent;