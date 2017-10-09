package ExcelToBean;

import DButil.ConnectionManager;
import DButil.DBAccessException;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test
{
	private Connection connection;

	private PreparedStatement titlesQuery;

	private ResultSet results;

	public static void main(String[] args) throws Exception
	{
		Map<String, String> header = new HashMap<String, String>();
		header.put("学生姓名","name");
		header.put("学生性别","sex");
		header.put("生日","birth");
		header.put("所在学校","schoolName");
		header.put("年级","grade");
		header.put("家长姓名","parentName");
		header.put("联系方式","phone");
		header.put("通讯地址","adress");
		header.put("缴费金额（元）","payAmount");
		header.put("所在分校","curschool");
		header.put("报名班级","classId");
		ExcelImport export = new ExcelImport(header);
		export.init(new FileInputStream(new File("src/副本回龙观秋季班 (12841).xls")),"xls");
		List<Student> students = export.bindToModels(Student.class, true);
		if (export.hasError())
		{
			System.out.println(export.getError().toString());
		}

	}

	@org.junit.Test
public void connTest() {
		try {
			try {
			 connection = ConnectionManager.getConnection();
			} catch (DBAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			titlesQuery = connection
					.prepareStatement("select * from user_info limit 10");
			ResultSet results = titlesQuery.executeQuery();

			// 读取行数据
			while (results.next()) {
				System.out.println(results.getString("user_id"));
			}
		}

		// 处理数据库异常
		catch (SQLException exception) {
			exception.printStackTrace();
		}

		// 释放资源
		finally {
			ConnectionManager.closeResultSet(results);
			ConnectionManager.closeStatement(titlesQuery);
			ConnectionManager.closeConnection(connection);
		}

	}


}



