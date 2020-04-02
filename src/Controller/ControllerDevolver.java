package Controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Get.Locacao;

@WebServlet("/DevolverCad")
public class ControllerDevolver extends HttpServlet{

	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		handleRequest(req, resp);
	}

	
	private void handleRequest(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		
		List <Locacao> locacao;
		if (req.getSession().getAttribute("locacao")== null){
			locacao = new ArrayList<Locacao>();
			req.getSession().setAttribute("locacao", locacao);
		}else
			locacao = (ArrayList)req.getSession().getAttribute("locacao");

		Locacao loc;
		
		if (req.getParameter("updateLocacao") != null) {
			int locId = Integer.parseInt(req.getParameter("updateLocacao"));
			loc = locacao.get(locId);
		}else {
			loc = new Locacao();
			locacao.add(loc);
		}

		
		//Datas para ver as multas
		Calendar datainicial = new GregorianCalendar();
		datainicial.setTime(loc.getDtEst());
		Calendar datafinal = new GregorianCalendar();
		datafinal.setTime(new Date());
		long dias = ((datafinal.getTimeInMillis() - datainicial.getTimeInMillis()) / (24*60*60*1000));
		
		
		//Data caso devolva antes
		Calendar dataestimativa = new GregorianCalendar();
		dataestimativa.setTime(loc.getDtLoc());
		long diasloc = ((dataestimativa.getTimeInMillis() - datafinal.getTimeInMillis()) / (24*60*60*1000));
		
		if(dias > 0) {
			loc.setDtDev(new Date());
			loc.setVlMul((loc.getVllocuni() * 25/100) * dias);
			loc.setVlPag((dias * (((loc.getVllocuni() * 25)/100) + loc.getVllocuni())) + loc.getVlloc());
			loc.setFlDev(1);
		}else
			loc.setDtDev(new Date());
			loc.setVlMul(0);
			loc.setVlPag(loc.getVlloc());
			loc.setFlDev(1);
		
		 if (diasloc > 0){
				loc.setDtDev(new Date());
				loc.setVlMul(0);
				loc.setVlPag(diasloc * loc.getVllocuni());
				loc.setFlDev(1);
		 }
		
		req.getRequestDispatcher("Locacao.jsp").forward(req, resp);
		
	}
}
