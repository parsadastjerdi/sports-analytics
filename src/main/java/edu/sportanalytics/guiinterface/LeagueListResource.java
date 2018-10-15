package edu.sportanalytics.guiinterface;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.logging.Logger;

@Path("LeagueListResource")
public class LeagueListResource
{
    private static final Logger log = Logger.getLogger(LeagueListResource.class.getName());


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getData(@QueryParam("sports")String sports)
    {
        log.info("League list for sport " + sports + " requested");
        //Here call query to receive all leagues for this particular sports
        //Wrap it in JSON String

        return "Not implemented";
    }
}