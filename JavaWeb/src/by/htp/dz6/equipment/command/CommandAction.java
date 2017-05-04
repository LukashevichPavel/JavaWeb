package by.htp.dz6.equipment.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CommandAction {

	public String execute(HttpServletRequest request, HttpServletResponse response);

}
