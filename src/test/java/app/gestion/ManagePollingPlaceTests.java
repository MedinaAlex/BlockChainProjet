package app.gestion;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import app.bean.VoteCast;
import app.configuration.ConfigBean;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
//ApplicationContext will be loaded from the OrderServiceConfig class
@ContextConfiguration(classes=ConfigBean.class, loader=AnnotationConfigContextLoader.class)
public class ManagePollingPlaceTests {
	
	@Autowired
	ManagePollingPlace gestionUser;
	
	private static Logger LOG = Logger.getLogger(ManagePollingPlaceTests.class);
	
//	@Test
//	public void test() {
//		User user1 = new User(null, "user1", "nom");
//		user1 = gestionUser.add(user1);
//		
//		LOG.info(user1);
//		gestionUser.delete(user1.getId());
//	}

}
