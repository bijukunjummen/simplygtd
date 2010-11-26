package org.bk.simplygtd.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.List;
import java.util.Map;

import org.bk.simplygtd.domain.GtdContext;
import org.bk.simplygtd.domain.GtdUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "contexttest.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class GtdContextDaoIntegrationTest {
	@Autowired
	Map<String, GtdContext> gtdContextsMap;
	@Autowired
	Map<String, GtdUser> gtdUsersMap;
	@Autowired
	GtdContextDao gtdContextDao;
	@Autowired
	GtdUserDao gtdUserDao;

	@Before
	public void setUp() {
		this.gtdUserDao.persist(gtdUsersMap.get("user1"));
		for (String key : gtdContextsMap.keySet()) {
			GtdContext gtdContext = gtdContextsMap.get(key);
			gtdContext.setGtdUser(gtdUsersMap.get("user1"));
			this.gtdContextDao.persist(gtdContext);
		}
	}

	@Test
	public void testGetContext() {
		GtdContext aContext = this.gtdContextDao.findById(1L);
		assertThat(aContext.getName(), is("context1"));

		aContext.setName("updated-context1");
		aContext = this.gtdContextDao.update(aContext);
		assertThat(aContext.getName(), is("updated-context1"));

		List<GtdContext> contextsByUser = this.gtdContextDao.findContextsByGtdUser(gtdUsersMap.get("user1"));
		assertThat(contextsByUser, hasItems(gtdContextsMap.get("context1"), gtdContextsMap.get("context2"), gtdContextsMap.get("context3")));

		List<GtdContext> contextsByName = this.gtdContextDao.findContextsByName("context5");
		
		assertThat(contextsByName, hasItem(gtdContextsMap.get("context5")));

		this.gtdContextDao.remove(aContext);
		assertThat(this.gtdContextDao.findById(1L), is(nullValue()));

	}

}
