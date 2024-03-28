package edu.ncsu.csc216.wolf_tasks.model.notebook;

import java.io.File;

import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

public class Notebook {
	
	private String notebookName;
	
	private boolean isChanged;
	
	
	public Notebook(String name) {
		setNotebookName(name);
	}
	
	public void saveNotebook(File file) {
		//TODO: implement method
	}
	
	public String getNotebookName() {
		return notebookName;
	}

	private void setNotebookName(String name) {
		//TODO: implement method
	}
	
	public boolean isChanged() {
		return isChanged;
	}
	
	public void setChanged(boolean b) {
		//TODO: implement method
	}
	
	public void addTaskList(TaskList t) {
		//TODO: implement method
	}
	
	public String[] getTaskListsNames() {
		return null;
	}
	
	private void getActiveTaskList() {
		//TODO: implement method
	}
	
	public void setCurrentTaskList(String list) {
		//TODO: implement method
	}
	
	public AbstractTaskList getCurrentTaskList() {
		getActiveTaskList();
		return null;
	}
	
	public void editTaskList(String list) {
		//TODO: implement method
	}
	
	public void removeTaskList() {
		//TODO: implement method
	}
	
	public void addTask(Task t) {
		//TODO: implement method
	}
	
	public void editTask(int x, String s, String y, boolean b, boolean p) {
		//TODO: implement method
	}
}

