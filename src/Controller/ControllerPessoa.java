package Controller;


import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Get.Pessoas;

@WebServlet("/PessoaCad")
public class ControllerPessoa extends HttpServlet{

	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		handleRequest(req, resp);
	}

	
	private void handleRequest(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		
		List <Pessoas> pessoas;
		if (req.getSession().getAttribute("pessoas")== null){
			pessoas = new ArrayList<Pessoas>();
			req.getSession().setAttribute("pessoas", pessoas);
		}else
			pessoas = (ArrayList)req.getSession().getAttribute("pessoas");

		Pessoas pes;
		
		if (req.getParameter("updatePessoa") != null) {
			int pesId = Integer.parseInt(req.getParameter("updatePessoa"));
			pes = pessoas.get(pesId);
		}else {
			pes = new Pessoas();
			pessoas.add(pes);
		}
		
		pes.setNamePes(req.getParameter("NamePes"));
		pes.setSobrePes(req.getParameter("SobrePes"));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			pes.setNascPes(format.parse(req.getParameter("NascPes")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pes.setCnhPes(req.getParameter("CnhPes"));
		pes.setDDDPes(Integer.parseInt(req.getParameter("DDDPes")));
		pes.setNumPes(req.getParameter("NumPes"));
		pes.setEmailPes(req.getParameter("EmailPes"));
		pes.setEndPes(req.getParameter("EndPes"));
		pes.setCidPes(req.getParameter("CidPes"));
		pes.setUfPes(req.getParameter("UfPes"));		
		
		req.getRequestDispatcher("Cliente.jsp").forward(req, resp);
		
	}
}
