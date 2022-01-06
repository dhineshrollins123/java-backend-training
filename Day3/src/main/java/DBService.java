import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.SQLException;

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

    public void find() {

    }
}
