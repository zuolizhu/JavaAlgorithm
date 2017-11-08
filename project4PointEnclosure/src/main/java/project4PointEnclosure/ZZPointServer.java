package project4PointEnclosure;

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
public class ZZPointServer extends HttpServlet {

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
        // We can always create JSON by hand just concating a string.
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
        String result = new JsonDiscerner().discern(jsonStr);

        // Set response content type to be JSON
        response.setContentType("application/json");
        // Send back the name of the class as a JSON message
        PrintWriter out = response.getWriter();
        out.println(result);
    }


}