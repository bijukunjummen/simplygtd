package org.bk.simplygtd.service;

import java.util.List;

import javax.annotation.Resource;

import org.bk.simplygtd.dao.GtdProjectDao;
import org.bk.simplygtd.dao.GtdUserDao;
import org.bk.simplygtd.domain.GtdProject;
import org.bk.simplygtd.domain.GtdUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GtdProjectServiceImpl implements GtdProjectService {
    
    @Resource private GtdProjectDao gtdProjectDao;
    @Resource private GtdUserDao gtdUserDao;

    @Transactional
    @Override
    public GtdProject persistForUser(GtdProject gtdProject, String userName) {
        GtdUser gtdUser = this.gtdUserDao.findUserByUserName(userName);
        gtdProject.setGtdUser(gtdUser);
        return gtdProjectDao.persist(gtdProject);
    }

    @Override
    public GtdProject findById(Long id) {
        return this.gtdProjectDao.findById(id);
    }

    @Override
    public List<GtdProject> findGTDProjectsByGtdUser(String userName, int firstResult, int maxResults) {
        return this.gtdProjectDao.findGTDProjectsByGtdUser(userName, firstResult, maxResults);
    }

    @Override
    public Long countProjectsByUserName(String userName) {
        return this.gtdProjectDao.countProjectsByUserName(userName);
    }

    @Transactional
    @Override
    public GtdProject updateForUser(GtdProject gtdProject, String userName) {
        GtdUser gtdUser = this.gtdUserDao.findUserByUserName(userName);
        gtdProject.setGtdUser(gtdUser);
        return this.gtdProjectDao.update(gtdProject);
    }

    @Transactional
    @Override
    public void remove(GtdProject gtdProject) {
        this.gtdProjectDao.remove(gtdProject);
    }

    public void setGtdProjectDao(GtdProjectDao gtdProjectDao) {
        this.gtdProjectDao = gtdProjectDao;
    }

    public void setGtdUserDao(GtdUserDao gtdUserDao) {
        this.gtdUserDao = gtdUserDao;
    }

    
}
