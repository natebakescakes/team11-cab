package edu.iss.cats.repository.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import com.team11.cab.init.Initializer;
import com.team11.cab.init.WebAppConfig;
import com.team11.cab.model.Employee;
import com.team11.cab.repository.EmployeeRepository;

@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class })
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(classes = Initializer.class),
		@ContextConfiguration(classes = WebAppConfig.class) })
@DatabaseSetup(EmployeeRepositoryIT.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { EmployeeRepositoryIT.DATASET })
@DirtiesContext

public class EmployeeRepositoryIT {
	protected static final String DATASET = "classpath:datasets/it-employees.xml";
	
	private static final String FIRST_EMPID = "pointy";
	//private static final String FIRST_NAME = "Pointy";
	//private static final String NAME_FIELD = "name";
	
	@Autowired
	private EmployeeRepository repository;
	
	@Test
	public void findEmployeeByID() {
	  Employee e = repository.findEmployeeById(FIRST_EMPID);
	  System.out.println("*********************************************************");
	  System.out.println(e.toString());
	  
	}
	

}
