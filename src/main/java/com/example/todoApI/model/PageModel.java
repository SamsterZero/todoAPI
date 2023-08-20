package com.example.todoApI.model;

import java.util.List;
import java.util.Objects;

import com.example.todoApI.entity.TodoList;

import lombok.Builder;

@Builder
public class PageModel {

	private List<TodoList> taskList;

	private int currentPageNo;

	private int totalPageNo;

	public List<TodoList> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<TodoList> taskList) {
		this.taskList = taskList;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getTotalPageNo() {
		return totalPageNo;
	}

	public void setTotalPageNo(int totalPageNo) {
		this.totalPageNo = totalPageNo;
	}

	public PageModel(List<TodoList> taskList, int currentPageNo, int totalPageNo) {
		super();
		this.taskList = taskList;
		this.currentPageNo = currentPageNo;
		this.totalPageNo = totalPageNo;
	}

	public PageModel() {
		super();
	}

	@Override
	public String toString() {
		return "PageModel [taskList=" + taskList + ", currentPageNo=" + currentPageNo + ", totalPageNo=" + totalPageNo
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(currentPageNo, taskList, totalPageNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageModel other = (PageModel) obj;
		return currentPageNo == other.currentPageNo && Objects.equals(taskList, other.taskList)
				&& totalPageNo == other.totalPageNo;
	}

}
