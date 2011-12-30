package org.bk.simplygtd.service;

import java.util.List;

import org.bk.simplygtd.domain.GtdProject;

public interface GtdProjectService {
    GtdProject persistForUser(GtdProject gtdProject, String userName);
    GtdProject findById(Long id);
    List<GtdProject> findGTDProjectsByGtdUser(String userName, int firstResult, int maxResults);
    Long countProjectsByUserName(String userName);
    GtdProject updateForUser(GtdProject gtdProject, String userName);
    void remove(GtdProject gtdProject);
}
