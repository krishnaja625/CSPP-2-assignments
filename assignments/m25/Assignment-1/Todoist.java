import java.util.Scanner;
import java.util.Arrays;
class Todoist {
	private Task[] taskObjects;
	private int size;
	Todoist() {
		taskObjects = new Task[10];
		size = 0;

	}
	public void addTask(Task t) {
		if (size == taskObjects.length) {
            resize();
            addTask(t);
        } else {

		    taskObjects[size++] = t;
	    }
	}
    
    private void resize() {
        Task[] newset = new Task[2 * taskObjects.length];
        System.arraycopy(taskObjects, 0, newset, 0, taskObjects.length);
        taskObjects = newset;
    }
    public String toString() {
    	String str = "";
    	for (int i =0; i <taskObjects.length; i++) {
    		str = taskObjects[i] + "\n";
    	}
    	return str;
    }
}