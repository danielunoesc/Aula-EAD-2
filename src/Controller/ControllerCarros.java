package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;

import Get.Carros;

@WebServlet("/CarroCad")
public class ControllerCarros extends HttpServlet{
	
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		handleRequest(req, resp);
	}

	protected void doPost(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {

		handleRequest(req, resp);
	}

	
	private void handleRequest(final HttpServletRequest req, final HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<Carros> carros;
		if (req.getSession().getAttribute("carros") == null) {
			carros = new ArrayList<Carros>();
			carros.clear();
			req.getSession().setAttribute("carros", carros);
		} else {
			carros = (ArrayList<Carros>) req.getSession().getAttribute("carros");
		}
		Carros car;
		
		if (req.getParameter("hdcarId") != null) {
			int carId = Integer.parseInt(req.getParameter("hdcarId"));
			car = carros.get(carId);
		}else {
			car = new Carros();
			carros.add(car);
		}
		
		car.setCodcar(Integer.parseInt(req.getParameter("Codcar")));
		car.setNameCar(req.getParameter("NameCar"));
		car.setVlCar(Float.parseFloat(req.getParameter("VlCar")));
		car.setLocCar(Float.parseFloat(req.getParameter("LocCar")));
		car.setMarCar(req.getParameter("MarCar"));
		car.setModCar(req.getParameter("ModCar"));
		
		req.getRequestDispatcher("Carros.jsp").forward(req, resp);
		
	}
}
