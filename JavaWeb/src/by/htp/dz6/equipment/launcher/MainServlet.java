package by.htp.dz6.equipment.launcher;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.dz6.equipment.command.CommandAction;
import by.htp.dz6.equipment.command.CommandChooser;

public class MainServlet extends HttpServlet {
	 
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -2657755046972134814L;

	public MainServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		System.out.println("do get");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
		System.out.println("do post");
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	String action = request.getParameter("action");
	String page=null;
	if (action!=null){
		
		CommandAction currentAction = CommandChooser.chooseAction(action);
		page = currentAction.execute(request, response);
		RequestDispatcher disp = request.getRequestDispatcher(page);
		disp.forward(request, response);
		
	}
	}
}

