package com.flipkart.buisnesslogic;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/jpeg");
		//System.out.println("image file = "+request.getRequestURL());
		String fileName = ""+request.getRequestURL();
		fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		//System.out.println("fileName = "+fileName);
		String pathToWeb = getServletContext().getRealPath(File.separator);
		String finalFileName = pathToWeb + "/images/"+fileName;
		//System.out.println("finalFileName = "+finalFileName);
		File f = new File(finalFileName);
		BufferedImage bi = ImageIO.read(f);
		OutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		out.close();
	}

}
