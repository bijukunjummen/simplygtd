package org.bk.simplygtd.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.List;
import java.util.Map;

import org.bk.simplygtd.domain.GtdContext;
import org.bk.simplygtd.domain.GtdProject;
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
@ContextConfiguration(locations = { "projecttest.xml" })
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class GtdProjectDaoIntegrationTest {

	@Autowired
	Map<String, GtdProject> gtdProjectsMap;

	@Autowired
	Map<String, GtdUser> gtdUsersMap;

	@Autowired
	GtdProjectDao gtdProjectDao;

	@Autowired
	GtdUserDao gtdUserDao;

	@Before
	public void setUp() {
		this.gtdUserDao.persist(gtdUsersMap.get("user1"));
		for (String key : gtdProjectsMap.keySet()) {
			GtdProject gtdProject = gtdProjectsMap.get(key);
			gtdProject.setGtdUser(gtdUsersMap.get("user1"));
			this.gtdProjectDao.persist(gtdProject);
		}
	}

	@Test
	public void testProjectIntegration() {
		GtdProject gtdProject = this.gtdProjectDao.findById(1L);
		assertThat(gtdProject, is(equalTo(gtdProjectsMap.get("project1"))));
		
		GtdUser user1 = this.gtdUserDao.findUserByUserName("user1");
		List<GtdProject> user1Projects = this.gtdProjectDao.findGTDProjectsByGtdUser(user1);
		assertThat(user1Projects, hasItems(gtdProjectsMap.values().toArray(new GtdProject[0])));
		
		this.gtdProjectDao.remove(gtdProject);
		assertThat( this.gtdProjectDao.findById(1L), is(nullValue()));
		
		List<GtdProject> project2ForUser1 = this.gtdProjectDao.findGTDProjectsByGtdUserAndName(user1, "project2");
		assertThat(project2ForUser1.size(), is(1));
		
	}

}
