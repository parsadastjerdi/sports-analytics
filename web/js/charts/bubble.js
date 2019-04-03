/*
    Description:
        Creates a bubble chart using json input
    Args:
        json: json object of all the data (with labels) to be plotted
            dim1: the first dimension
            dim2: the second dimension
            aggie: the dimension that was aggregrated using the aggregration function.
                   this is usually plotted on the third axis.
    Returns:
    Raises:
    Notes:
*/
function plotBubble(json){
	//Window.chart is global variable used to destroy previous chart to eliminate flicker
    if (window.chart != undefined){
        window.chart.destroy();
        console.log("window destroy bubble");
    
    }
    var ctx = document.getElementById("mainChart").getContext('2d');

    // Convert all 20XX/20YY to 20XX (assumes the first dimension is always seasons)
    var dim1 = new Array();
    for (var i = 0; i < json.dim1.length; i++){
        if(json.dim1[i] != null){
            dim1.push(parseInt(json.dim1[i].substr(0,4)));
        } else{
            dim1.push(null);
        }
        
    }
    
    // Pushes all of dim2 into xLabels and skips over duplicates
    var xLabels = new Array();
    for (var i = 0; i < json.dim2.length; i++) {
        if (xLabels.includes(json.dim2[i])) {
            break;
        }
        else {
            xLabels.push(json.dim2[i]);
        }
    }

    var datasets = new Array();
    var teamset = new Array();

    for (var i = 0; i < json.dim2.length; ++i) {
        if (teamset.includes(json.dim2[i]) /*|| dim2[i] == null*/) {
            break;
        }
        else {
            teamset.push(json.dim2[i]);
        }

        var seasonData = new Array();
        for (var j = 0; j < dim1.length; ++j) {
            if (json.dim2[j] == json.dim2[i] && dim1[j] != null) {
                seasonData.push({
                		x: i,
                        y: dim1[j],
                        r: json.aggie[j].toFixed(2)
                    });
            }
        }
        
        // getRandomColor() is now defined in utils.js 
        // and needs to be included in the html file in order to work
		var col = getRandomColor();
        var teamData ={
                label: json.dim2[i],
                data: seasonData,
                showLine: true,
                fill: false,
       			borderColor: col,
        		pointBorderColor: col,
        		backgroundColor: col,
        		hidden: false   
            };
            console.log(json.dim2[i]);

        datasets.push(teamData);
    }
    
    

    var config = {
        type: 'bubble',
        data: {datasets: datasets},
        options: {
        	title: {
        		display: true,
      			text: 'Average Number of Goals Scored By Each Team In Bundesliga By Season'
      		},
            scales: {
                xAxes: [{
                	scaleLabel: {
                	display: true,
        			labelString: 'Teams'
        			},
                    type: 'linear',
                    position: 'bottom',
                    ticks: {
                		display: true,
                		stepSize: 1,
                        callback: function(value, index, values) {
                            return xLabels[value];
                	    },
                	    min: 0,
                	    max: i,
                	    autoSkip: false
              		}
                }],
                yAxes: [{
                	scaleLabel: {
                	display: true,
        			labelString: 'Seasons',
        			ticks: {
                					callback: function (value) { if (Number.isInteger(value)) { return value; } }
            					},
            		min: 0
        			}
                }]
            }
        }
    }

    window.chart = new Chart(ctx, config);
    
}