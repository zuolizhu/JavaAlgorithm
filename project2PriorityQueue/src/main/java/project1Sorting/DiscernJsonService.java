package project1Sorting;


// Import required java libraries
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


// Extend HttpServlet class
public class DiscernJsonService extends HttpServlet {

  // Standard servlet method 
    public void init() throws ServletException { 
        // Do any required initialization here - likely none
    }
    
    // Standard servlet method - we will handle a POST operation
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        doService(request, response); 
    }

    // Standard Servlet method
    public void destroy() { 
        // Do any required tear-down here, likely nothing.
    }

    // Standard servlet method - we will not respond to GET
    public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        // Set response content type and return an error message
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        // We can always create JSON by hand just concatenate a string.
        out.println("{ 'message' : 'Use POST!'}");
    }
    
    // Our main worker method
    private void doService(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException { 
        // Get received JSON data from HTTP request
        BufferedReader br = new BufferedReader(new InputStreamReader(request.getInputStream()));
        String jsonStr = "";
        if(br != null){
            jsonStr = br.readLine();
        }

        // Create Json reader object and discern the content from the JSON message
        int[] inList = new JsonClassDiscerner().discern(jsonStr);

        // Initialize the output JSON String
        String outputJSON;
        JsonSerializer serializer = new JsonSerializer();

        if(inList.length == 0) {
            ErrorHandler error = new ErrorHandler();
            error.setMessage("Malformed JSON");
            outputJSON = serializer.serialize(error);
        } else {
            // Create a sorter to sort the input list
            SortList sorter = new SortList();

            // Setup output JSON from sorted list
            int[] sortedList = inList;

            OutJSONObject outJSONObject = new OutJSONObject();
            outJSONObject.setOutList(sortedList);
            outJSONObject.setAlgorithm("quicksort");

            // Serialize output JSON String

            outputJSON = serializer.serialize(outJSONObject);
        }

        // Set response content type to be JSON
        response.setContentType("application/json");
        // Send back the name of the class as a JSON message
        PrintWriter out = response.getWriter();
        out.println(outputJSON);
    }
}

