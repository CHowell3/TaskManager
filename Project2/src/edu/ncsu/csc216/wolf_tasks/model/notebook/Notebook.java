package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

public class Notebook {
	
	private String notebookName;
	
	private boolean isChanged;
	
	
	public Notebook(String name) {
		
	}
	
	public void saveNotebook(File file) {
		
	}
	
	public String getNotebookName() {
		return "";
	}

	private void setNotebookName(String name) {
		
	}
	
	public boolean isChanged() {
		return true;
	}
	
	public void setChanged(boolean b) {
		
	}
	
	public void addTaskList(TaskList t) {
		
	}
	
	public String[] getTaskListsNames() {
		return null;
	}
	
	private void getActiveTaskList() {
		
	}
	
	public void setCurrentTaskList(String list) {
		
	}
	
	public AbstractTaskList getCurrentTaskList() {
		return null;
	}
	
	public void editTaskList(String list) {
		
	}
	
	public void removeTaskList(String list) {
		
	}
	
	public void addTask(Task t) {
		
	}
	
	public void editTask(int x, String s, String y, boolean b, boolean p) {
		
	}
}

