package com.durgasoft.servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.util.List;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload sfu=new ServletFileUpload(factory);
		List<FileItem> items = sfu.parseRequest(request);
		FileItem item=items.get(0);
		String file_path=item.getName();
		File f=new File(file_path);
		String file_Name=f.getName();
		File f1=new File("C:\\Users\\DUSHYANT SIROHI\\eclipse-workspace\\upload\\" + file_Name);
		item.write(f1);
		RequestDispatcher rd=request.getRequestDispatcher("/success.html");
		rd.forward(request,response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		

}
