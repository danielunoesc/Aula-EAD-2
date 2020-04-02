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

@WebServlet("/locacaoCad")
public class ControllerLocacao extends HttpServlet{

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
		
		


		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Calendar datainicial = new GregorianCalendar();
		try {
			datainicial.setTime(format.parse(req.getParameter("dtLoc")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar datafinal = new GregorianCalendar();
		try {
			datafinal.setTime(format.parse(req.getParameter("dtEst")));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long dias = ((datafinal.getTimeInMillis() - datainicial.getTimeInMillis()) / (24*60*60*1000));
		
		
		
		try {
			loc.setDtLoc(format.parse(req.getParameter("dtLoc")));
			loc.setDtEst(format.parse(req.getParameter("dtEst")));
			loc.setDtDev(null);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		loc.setCarros(req.getParameter("carros"));
		loc.setPessoas(req.getParameter("pessoas"));
		loc.setVlloc(Float.parseFloat(req.getParameter("vlloc")) * dias);
		loc.setVllocuni(Float.parseFloat(req.getParameter("vlloc")));

		
		
		req.getRequestDispatcher("Locacao.jsp").forward(req, resp);
		
	}
}
