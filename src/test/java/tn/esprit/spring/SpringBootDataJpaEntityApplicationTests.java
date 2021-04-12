package tn.esprit.spring;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.sun.el.parser.ParseException;
import tn.esprit.spring.entity.Role;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootDataJpaEntityApplicationTests {
	@Autowired
	UserService us;
	@Test
	public void contextLoads() throws ParseException, java.text.ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    Date d = dateFormat.parse("2021-04-11");
	    Role r = new Role(1,"admin","admin");
	    User u = new User(3,"Dhaker", "Karous","test",12,"test","test",4, r, d);
	    us.addUser(u);
	}

}
