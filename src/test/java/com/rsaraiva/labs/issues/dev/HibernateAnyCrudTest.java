package com.rsaraiva.labs.issues.dev;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.rsaraiva.labs.issues.core.HibernateFactoryProducer;
import com.rsaraiva.labs.issues.model.User;

public class HibernateAnyCrudTest {

	private static SessionFactory factory;
	private Session session;
	
	private static final String DEFAULT_LOGIN = "rsaraiva";
	private static final LocalDateTime DEFAULT_CREATE_ON = LocalDateTime.of(2014, Month.DECEMBER, 25, 22, 0);

	@BeforeClass
	public static void beforeClass() {
		factory = HibernateFactoryProducer.produces();
	}

	@AfterClass
	public static void afterClass() {
		factory.close();
	}

	@Before
	public void setup() {
		session = factory.openSession();
	}

	@After
	public void after() {
		session.close();
		session = null;
	}

	@Test
	public void shouldCreateUser() {
		try {
			createUser();
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void shouldListAllUsers() {
		try {
			createUser();
			
			@SuppressWarnings("unchecked")
			List<User> users = session.createQuery("from User").list();
			
			Assert.assertTrue(users.size() > 0);
			Assert.assertTrue(users.get(0).getLogin().equals(DEFAULT_LOGIN));
			Assert.assertTrue(users.get(0).getCreatedOn().equals(DEFAULT_CREATE_ON));
			Assert.assertNull(users.get(0).getUpdatedOn());
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}

	private void createUser() {
		User user = new User(DEFAULT_LOGIN);
		user.setCreatedOn(DEFAULT_CREATE_ON);
		session.getTransaction().begin();
		session.save(user);
		session.getTransaction().commit();
	}
}
