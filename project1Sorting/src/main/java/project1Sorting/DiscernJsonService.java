package project1Sorting;


// Import required java libraries
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


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
        
        // Create Json reader object and discern the class from the JSON message
        // String className = new JsonClassDiscerner().discern(jsonStr);

        // Create Json reader object and discern the content from the JSON message
        int[] inList = new JsonClassDiscerner().discern(jsonStr);

        // Create a sorter to sort the input list
        SortList sorter = new SortList();
        sorter.sort(inList);

        // Setup output list from sorted list
        int[] sortedList = inList;
        OutList outList = new OutList();
        outList.setOutList(sortedList);

        // Serialize output JSON String
        JsonSerializer serializer = new JsonSerializer();
        String outputJSON = serializer.serialize(outList);



        //Create outList and serialize java content to JSON message

        // Set response content type to be JSON
        response.setContentType("application/json");
        // Send back the name of the class as a JSON message
        PrintWriter out = response.getWriter();
        out.println(outputJSON);
    }
    
    
}

