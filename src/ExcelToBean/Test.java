package ExcelToBean;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test
{

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

}
