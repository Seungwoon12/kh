package nexacro.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.tx.HttpPlatformResponse;
import com.nexacro17.xapi.tx.PlatformType;

@WebServlet("/list.do")
public class NexacroListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			DataSet ds = new DataSet("emp");
			ds.addColumn("emp_no", DataTypes.STRING, 256);
			ds.addColumn("emp_name", DataTypes.STRING, 256);
			ds.addColumn("position", DataTypes.STRING, 256);
			ds.addColumn("department", DataTypes.STRING, 256);
			ds.addColumn("hire_date", DataTypes.DATE_TIME, 256);
			ds.addColumn("emp_phone", DataTypes.STRING, 256);
			ds.addColumn("emp_email", DataTypes.STRING, 256);
			
			int row = ds.newRow();
			ds.set(row, "emp_no", "10001");
			ds.set(row, "emp_name", "홍길동");
			ds.set(row, "position", "사장");
			ds.set(row, "department", "");
			ds.set(row, "hire_date", "2010-01-01");
			ds.set(row, "emp_phone", "010-1234-5678");
			ds.set(row, "emp_email", "ceo@naver.com");
			
			row = ds.newRow();
			ds.set(row, "emp_no", "10002");
			ds.set(row, "emp_name", "이소룡");
			ds.set(row, "position", "인턴");
			ds.set(row, "department", "홍보");
			ds.set(row, "hire_date", "2020-01-01");
			ds.set(row, "emp_phone", "010-1235-3213");
			ds.set(row, "emp_email", "intern@naver.com");
			
			PlatformData pd = new PlatformData();
			pd.addDataSet(ds);
			
			HttpPlatformResponse nxcrResp = new HttpPlatformResponse(resp, PlatformType.CONTENT_TYPE_XML, "UTF-8");
			nxcrResp.setData(pd);
			nxcrResp.sendData();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			resp.sendError(500);
		}
	}
}
