package home.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import home.beans.WeatherDao;
import home.beans.WeatherDto;

@WebServlet("/arduino.do")
public class ArduinoServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			System.out.println("접속 성공!");
			
//			아두이노가 보내는 정보(온도, 습도)를 받는다
			float temperature = Float.parseFloat(req.getParameter("temperature"));
			float humidity = Float.parseFloat(req.getParameter("humidity"));
			
//			기기의 IP 정보를 받는다(구분하기 위해)
			String ip = req.getRemoteAddr();
			
			//System.out.println("ip = "+ip);
			//System.out.println("temperature = "+temperature);
			//System.out.println("humidity = "+humidity);
			
			WeatherDto weatherDto = new WeatherDto();
			weatherDto.setIp(ip);
			weatherDto.setTemperature(temperature);
			weatherDto.setHumidity(humidity);
			
			WeatherDao weatherDao = new WeatherDao();
			weatherDao.insert(weatherDto);
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}