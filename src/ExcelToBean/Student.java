package ExcelToBean;

/**
 * Created by gaopeng on 2017/9/12.
 */
public class Student {
    private String name;
    private String sex;
    private String birth;
    private String schoolName;
    private String grade;
    private String parentName;
    private String phone;
    private String adress;
    private Double payAmount;
    private String curschool;
    private Integer classId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Double getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Double payAmount) {
        this.payAmount = payAmount;
    }

    public String getCurschool() {
        return curschool;
    }

    public void setCurschool(String curschool) {
        this.curschool = curschool;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    private Integer score;

    public Student() {
    }

    public Student(String name, String sex, String birth, String schoolName, String grade, String parentName, String phone, String adress, Double payAmount, String curschool, Integer classId, Integer score) {
        this.name = name;
        this.sex = sex;
        this.birth = birth;
        this.schoolName = schoolName;
        this.grade = grade;
        this.parentName = parentName;
        this.phone = phone;
        this.adress = adress;
        this.payAmount = payAmount;
        this.curschool = curschool;
        this.classId = classId;
        this.score = score;
    }
}
