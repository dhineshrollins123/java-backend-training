import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;

public class DBService {

    private final Connection connection;

    public DBService(Connection connection) {
        this.connection = connection;
    }


    public int create(int empId, String empNm, Date dob, boolean isManager) throws SQLException {
        String sql = "insert into emp_info values(?, ? ,? ,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, empId);
        ps.setString(2, empNm);
        ps.setDate(3, dob);
        ps.setBoolean(4, isManager );
        int affected = ps.executeUpdate();
        return affected;
    }

    public int update(int empId) throws SQLException {
        var sql="update emp_info set empNm='dhinesh Rollins',isManager=false where empId=?";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setInt(1,empId);
        System.out.println("row affected");
        int affected = ps.executeUpdate();
        return affected;
    }

    public int delete(int empId) throws SQLException {
        var sql="delete from emp_info where empId=?";
        PreparedStatement ps1= connection.prepareStatement(sql);
        ps1.setInt(1,empId);
        int affect= ps1.executeUpdate();
        return affect;
    }

    public void find() throws SQLException {
String sql="select * from emp_info";
PreparedStatement ps= connection.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            int id=rs.getInt("empId");
            String name= rs.getString("empNm");
            Date dob=rs.getDate("date");
            boolean isManager=rs.getBoolean("isManager");
            System.out.println("ID : "+id+" Name : "+name+" DOB : "+dob+" isManager : "+isManager);
        }
        rs.close();
    }
    public void findEmployeeByName(String name) throws SQLException {
        String sql="select * from emp_info where empNm=?";
        PreparedStatement ps=connection.prepareStatement(sql);
        ps.setString(1,name);
        ResultSet rs=ps.executeQuery();

        while(rs.next()){
            int id=rs.getInt("empId");
            String nm= rs.getString("empNm");
            Date dob=rs.getDate("date");
            boolean isManager=rs.getBoolean("isManager");
            System.out.println("ID : "+id+" Name : "+nm+" DOB : "+dob+" isManager : "+isManager);
        }
        rs.close();

    }

    public void txnDemo(int empId,String name,Date dob,boolean isManager,int upId) throws SQLException {
        var sql1="insert into emp_info values(?,?,?,?)";
        var ps1=connection.prepareStatement(sql1);
        ps1.setInt(1, empId);
        ps1.setString(2, name);
        ps1.setDate(3, dob);
        ps1.setBoolean(4, isManager);
        var aff1 = ps1.executeUpdate();
//        connection.commit();
        var sql2="update emp_info set empNm='none' where empId=?";
    var ps2=connection.prepareStatement(sql2);
        ps2.setInt(1, upId);
        var aff2 = ps2.executeUpdate();
        if(aff2 == 0) connection.rollback();

       // connection.commit();
    }
    public void findEmployeeWithAgeGreaterThanTen(int ageCal) throws SQLException {
        var sql="select * from emp where age > ?";
        PreparedStatement ps2= connection.prepareStatement(sql);
        ps2.setInt(1,ageCal);
        ResultSet rs=ps2.executeQuery();
        while(rs.next()){
            int empId=rs.getInt("empId");
            String empName= rs.getString("empName");
            int age=rs.getInt("age");
            System.out.println("EMP-ID : "+empId+" | "+"EMP-NAME : "+empName+" | "+"EMP-AGE : "+age);
        }

    }
}
