import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {
            Connectivity connectivity = new Connectivity();

            DBService service = new DBService(connectivity.getConnection());
            int cnt = service.create(
                    26,
                    "nim",
                    Date.valueOf(LocalDate.now()),
                    true
            );
            if(cnt > 0) {
                System.out.println("Employee Created Successfully");
               // service.find();
                service.findEmployeeByName("dog");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}