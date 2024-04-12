package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.ActiveTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;

/**
 * Class that reads a notebook from a file.
 * Since this is a static class, the constructor should not be used.
 * @author Rachel Cantrell and Johnathan Howell 
 */
public class NotebookReader {
	
	/**
	 * Constructor for NotebookReader. Since all methods are static, this should not usually be used.
	 */
	public NotebookReader() {
		// Constructor intentionally left empty
	}
	
	/**
	 * Loads a Notebook object from the file provided.
	 * @param file the file to load from
	 * @return the Notebook loaded from the file
	 */
	public static Notebook readNotebookFile(File file) {
		try {
			Scanner scanner = new Scanner(file);
			scanner.useDelimiter("\\r?\\n?[#]");
			if(scanner.hasNext()) {
				String next = scanner.next().trim();
				if(!next.substring(0, 2).equals("! ")) {
					scanner.close();
					throw new IllegalArgumentException();
				}
				Notebook notebook = new Notebook(next.substring(2));
				while(scanner.hasNext()) {
					try {
						notebook.addTaskList(processTaskList(scanner.next()));
					} catch (NullPointerException e) {
						// Do nothing
					}
				}
				scanner.close();
				notebook.setCurrentTaskList(ActiveTaskList.ACTIVE_TASKS_NAME);
				return notebook;
			}
			scanner.close();
			return null;
		} catch (Exception e) {
			throw new IllegalArgumentException("Unable to load file.");
		}
	}
	
	/**
	 * Private helper method for processing a taskList.
	 * @param taskListString the string to be processed
	 * @return the TaskList
	 */
	private static TaskList processTaskList(String taskListString){
		try {
			Scanner scanner = new Scanner(taskListString);
			scanner.useDelimiter("\\r?\\n?[*]");
			if(scanner.hasNext()) {
				Scanner lineScanner = new Scanner(scanner.nextLine());
				lineScanner.useDelimiter(",");
				String listName = lineScanner.next().substring(1);
				int completedInt = Integer.parseInt(lineScanner.next());
				
				TaskList taskList = new TaskList(listName, completedInt);
				while(scanner.hasNext()) {
					Task t = processTask(taskList, scanner.next());
					taskList.addTask(t);
				}
				scanner.close();
				return taskList;
			}
			scanner.close();
			return null;
	} catch (Exception e) {
		return null;
	}
		
	}
	
	/**
	 * Private helper method for processing a task.
	 * @param taskList the taskList of the task being processed
	 * @param taskString the string to be processed
	 * @return the Task
	 */
	private static Task processTask(AbstractTaskList taskList, String taskString) {
		Scanner scanner = new Scanner(taskString);
		scanner.useDelimiter("\\r?\\n?");
		if(scanner.hasNext()) {
			Scanner lineScanner = new Scanner(scanner.nextLine());
			lineScanner.useDelimiter("[,]");
			String name = lineScanner.next().substring(1);
			boolean recurring = false;
			boolean active = false;
			String description = "";
			while(lineScanner.hasNext()) {
				String next = lineScanner.next();
				if("recurring".equals(next)) {
					recurring = true;
				}
				if("active".equals(next)) {
					active = true;
				}
			}
			while(scanner.hasNext()) {
				description += scanner.nextLine() + "\n";
			}
			if (description.length() == 0) {
				return new Task (name, description, recurring, active);
			}
			String descriptionTrimed = description.substring(0, description.length() - 1);
			scanner.close();
			return new Task (name, descriptionTrimed, recurring, active);
		}
		scanner.close();
		return null;
	}
}
