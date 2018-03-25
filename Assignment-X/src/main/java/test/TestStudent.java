package test;
import com.soa12.assignment10.controller.UserManageController;
import com.soa12.assignment10.schemaModel.IdNotFoundException;
import com.soa12.assignment10.schemaModel.UserIdType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserManageController.class)
public class TestStudent {
    @Autowired
    UserManageController userManageController;
    @Test
    public void testStudent(){
        UserIdType userIdType = new UserIdType();
        userIdType.setStudentId("151250089");
        try {
            userManageController.searchInfo(userIdType);
        } catch (IdNotFoundException e) {
            e.printStackTrace();
        }
    }
}
