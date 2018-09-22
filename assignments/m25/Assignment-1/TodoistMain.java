import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    TodoistMain() {

    }
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
/*                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;*/
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }
    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}

class Task {
    private String title;
    private String assignedTo;
    private int timeToComplete;
    private boolean important;
    private boolean urgent;
    private String status;
    Task() {

    }
    Task(String title, String assignedTo, int timeToComplete, boolean important, boolean urgent, String status) throws Exception {
/*      try {*/
            if (title.equals("")) {
                throw  new Exception("Title not provided");

/*      }
    }  catch(Exception e) {
            System.out.println("Title not provided");*/
            /*System.exit();*/
        } else {
                    this.title = title;
        }
        this.assignedTo = assignedTo;
/*      try {*/
            if (timeToComplete >= 0) {
        this.timeToComplete = timeToComplete;
        }
        else {
            throw new Exception("Invalid timeToComplete " + timeToComplete);
        }
/*  } catch(Exception e) {
        System.out.println("Invalid timeToComplete " + timeToComplete);
    }*/
        this.important = important;
        this.urgent = urgent;
            if (status.equals("done") || status.equals("todo")) {
            this.status = status;   
        
        } else 
        {
            throw new Exception("Invalid status " + status);
        }
/*  } catch(Exception e) {
        System.out.println("Invalid status " + status);
    }*/
    }
    public String title () {
        return title;
    }
    public String assignedTo() {
        return assignedTo;
    }
    public int timeToComplete() {
        return timeToComplete;
    } 
    public String important() {
        String b = "";
        if (important) {
            b = "Important";
        } else {
            b = "Not Important";
        }
        return b;
    }
    public String urgent() {
        String a = "";
        if (urgent) {
            a = "Urgent";
        } else {
            a = "Not Urgent";
        }
        return a;
    }
    public String status() {
        return status;
    }
    public String toString() {
        String a = "";
        String b = "";
        if (urgent) {
            a = "Urgent";
        } else {
            a = "Not Urgent";
        }
        if (important) {
            b = "Important";
        } else {
            b = "Not Important";
        }
        String s = title + ", " + assignedTo + ", " + timeToComplete + ", " + b + ", " + a + ", " + status;
        return s;
    }
}
class Todoist {
    private Task[] taskObjects;
    private int size;
    Todoist() {
        taskObjects = new Task[1];
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
    public void finalObject() {
        Task[] newset = new Task[size];
        for(int i = 0; i < size; i++) {
            newset[i] = taskObjects[i];
        }
        taskObjects = newset;
    }
    public String toString() {
        String str = "";
        finalObject();
        for (int i =0; i <taskObjects.length; i++) {
            System.out.println(taskObjects[i]);
        }
        return "";
  } 
      public int totalTime4Completion() {
        int total = 0;
        for (int i =0; i <taskObjects.length; i++) {
            total += taskObjects[i].timeToComplete();
        }
        return total;
      }
}