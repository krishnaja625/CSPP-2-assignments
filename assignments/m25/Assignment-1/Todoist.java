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
        finalObject();
        int total = 0;

        for (int i =0; i <taskObjects.length; i++) { 
            String z = taskObjects[i].status();
            if (z.equals("todo")) {
            total += taskObjects[i].timeToComplete();
        }
        }
        return total;
      }
}