package com.advbuilder.jarbuild.servlet.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.advbuilder.jarbuild.worker.JarCreation;

/**
 * Servlet implementation class JarBuilderServlet
 */
@WebServlet(urlPatterns = {"/JarBuilderServlet","/"})
public class JarBuilderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JarBuilderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String buildPath=request.getParameter("buildPath");
		String jarLocation = request.getParameter("jarLocation");
		String manifestFileLocation = request.getParameter("manifestFileLocation");
		String classFilesLocation = request.getParameter("classFilesLocation");
		String outputFileName = request.getParameter("outputFileName");
		int jarCreationStatus=new JarCreation().main(buildPath,jarLocation,manifestFileLocation,classFilesLocation,outputFileName);
		if(jarCreationStatus==0)
			request.setAttribute("jarCreationStatus", "Success");
		else 
			request.setAttribute("jarCreationStatus", "Failure");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
