import javax.swing.*;
import java.sql.*;

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

    public int update() {
        return 0;
    }

    public int delete() {
        return 0;
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
}
