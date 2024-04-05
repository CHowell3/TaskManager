package edu.ncsu.csc216.wolf_tasks.model.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.wolf_tasks.model.notebook.Notebook;
import edu.ncsu.csc216.wolf_tasks.model.tasks.AbstractTaskList;
import edu.ncsu.csc216.wolf_tasks.model.tasks.Task;
import edu.ncsu.csc216.wolf_tasks.model.tasks.TaskList;
import edu.ncsu.csc216.wolf_tasks.model.util.SortedList;

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
			scanner.useDelimiter("\\r?\\n?[# ]");
			if(scanner.hasNext()) {
				String notebookName = scanner.next().trim();
				Notebook notebook = new Notebook(notebookName);
				while(scanner.hasNext()) {
					try {
						notebook.addTaskList(processTaskList(scanner.next()));
					} catch (NullPointerException e) {
						// Do nothing
					}
				}
				scanner.close();
				return notebook;
			}
			scanner.close();
			return null;
		} catch (FileNotFoundException e) {
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
			scanner.useDelimiter("\\r?\\n?[* ]");
			if(scanner.hasNext()) {
				Scanner lineScanner = new Scanner(scanner.nextLine());
				lineScanner.useDelimiter(",");
				String listName = lineScanner.next();
				int completedInt = Integer.parseInt(lineScanner.next());
				
				TaskList taskList = new TaskList(listName, completedInt);
				while(scanner.hasNext()) {
					taskList.addTask(processTask(taskList, scanner.next()));
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
			Scanner lineScanner = new Scanner(scanner.next());
			lineScanner.useDelimiter(",");
			String name = lineScanner.next();
			boolean recurring = false;
			boolean active = false;
			String description = "";
			if(lineScanner.hasNext()) {
				String next = lineScanner.next();
				if(next == "recurring") {
					recurring = true;
					if(lineScanner.hasNext() && lineScanner.next() == "active") {
						active = true;
					}
				}
				if(next == "active") {
					active = true;
				}
			}
			while(scanner.hasNext()) {
				description += scanner.next() + "\n";
			}
			return new Task (name, description, recurring, active);
		}
		return null;
	}
}
