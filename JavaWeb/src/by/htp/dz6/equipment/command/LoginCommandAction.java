package by.htp.dz6.equipment.command;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.htp.dz6.equipment.entity.*;

public class LoginCommandAction implements CommandAction{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("pass");
		String page = "";
		if ("user".equals(login)&& "user".equals(password)){
			page="/User.jsp";
			List<User> users = new ArrayList<User>();
			users.add(new User("user1","user1",true));
			users.add(new User("user2","user2",true));
			users.add(new User("user3","user3",true));
			request.setAttribute("list",users);
		}
		else{ 
			if ("admin".equals(login)&& "admin".equals(password)){
		
			page="/Admin.jsp";
			List<User> users = new ArrayList<User>();
			users.add(new User("admin1","admin1",true));
			users.add(new User("admin2","admin2",true));
			users.add(new User("admin3","admin3",true));
			request.setAttribute("list",users);
		}
			else{
				page="/Error.jsp";
			}
		}
		
		return page;
	}

	

}
