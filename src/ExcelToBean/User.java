package ExcelToBean;

import java.util.Date;

/**
 * 用户基本信息测试
 * 
 * @author 陈孟琳
 * 
 */
public class User
{
	private String username;
	private int id;
	private String name;
	private Date birthday;
	private long height;
	private double salary;
	private User user;
	
	

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Date getBirthday()
	{
		return birthday;
	}

	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public long getHeight()
	{
		return height;
	}

	public void setHeight(long height)
	{
		this.height = height;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}

	public User(String username, int id, String name, Date birthday,
			long height, double salary)
	{
		super();
		this.username = username;
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.height = height;
		this.salary = salary;
	}

	@Override
	public String toString()
	{
		return "User [username=" + username + ", id=" + id + ", name=" + name
				+ ", birthday=" + birthday + ", height=" + height + ", salary="
				+ salary + ", user=" + user + "]";
	}

	public User()
	{
	}
}
