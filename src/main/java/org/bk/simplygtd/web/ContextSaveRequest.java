package org.bk.simplygtd.web;

import java.util.List;

import org.bk.simplygtd.domain.GtdContext;

public class ContextSaveRequest {
	private List<Long> deleteIds;
	private List<GtdContext> updatedata;
	private List<GtdContext> newdata;
	public List<Long> getDeleteIds() {
		return deleteIds;
	}
	public void setDeleteIds(List<Long> deleteIds) {
		this.deleteIds = deleteIds;
	}
	public List<GtdContext> getUpdatedata() {
		return updatedata;
	}
	public void setUpdatedata(List<GtdContext> updatedata) {
		this.updatedata = updatedata;
	}
	public List<GtdContext> getNewdata() {
		return newdata;
	}
	public void setNewdata(List<GtdContext> newdata) {
		this.newdata = newdata;
	}
	
	
}
