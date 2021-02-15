package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

import home.util.JdbcUtil;

public class WeatherDao {
   public static final String USERNAME = "web";
   public static final String PASSWORD = "web";
   
   public void insert(WeatherDto weatherDto) throws Exception{
      Connection con = JdbcUtil.getConnection(USERNAME, PASSWORD);
      String sql = "insert into weather values(weather_seq.nextval,?,?,?,sysdate)";
      PreparedStatement ps = con.prepareStatement(sql);
      ps.setString(1, weatherDto.getIp());
      ps.setFloat(2, weatherDto.getTemperature());
      ps.setFloat(3, weatherDto.getHumidity());
      ps.execute();
      con.close();
   }
}