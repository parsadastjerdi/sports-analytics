import React from 'react';

class QueriesComponent extends React.Component {
    constructor(props) {
      super(props);
      this.state = {value: 'coachConf'};
      this.handleChange = this.handleChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
    }
  
    handleChange(event) {    
      this.setState({value: event.target.value});  
    }

    handleSubmit(event) {
      switch(this.state.value) {
        case "coachConf":
          alert('http://localhost:8080/api/v1/team/{conference} ex: east/west');
          break;
        case "playersTeam":
          alert('http://localhost:8080/api/v1/player/{teamId} ex:469b8f6f-8199-4ef8-8183-b3a06a561f77');
          break;
        case "pointDiff":
          alert('http://localhost:8080/api/v1/game/{pointDifference} ex: 5');
          break;
        case "gamesInSeason":
          alert('http://localhost:8080/api/v1/season/{seasonId} ex: a3ba58d7-137a-47ae-8540-8a2e4dd717bb');
          break;
        case "teamsForCoach":
          alert('http://localhost:8080/api/v1/coach/{coachId} ex: 2f4e7556-1662-41eb-956f-969fe092434f');
          break;
      }
    }
  
    render() {
      return (
        <form onSubmit={this.handleSubmit}>
          <label>
            Choose a query: 
            <select value={this.state.value} onChange={this.handleChange}>            
              <option value="coachConf">Get All Coaches for a given Conference</option>
              <option value="playersTeam">All Players Who Played on X Team</option>
              <option value="pointDiff">Games Whose Difference Is less than X</option>
              <option value="gamesInSeason">All Games in Season X</option>
              <option value="teamsForCoach">All Teams for a Given Coach</option>
            </select>
          </label>
          <input type="submit" value="Submit" />
          <div>
            Once you choose a query type, copy and paste the url into your browser to get
            the result.
          </div>
          <div>
            ID values can be found on corresponding tabs.
          </div>
        </form>
      );
    }
  }

export default QueriesComponent;