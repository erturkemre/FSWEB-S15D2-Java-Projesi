import model.Priority;
import model.Status;
import model.Task;
import model.TaskData;
import utils.SetUtils;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Task taskDummy = new Task("s15d2","dummy desc","bob", Priority.HIGH, Status.ASSIGNED);
        Task taskForBob2 = new Task("s15d2","dummy desc 2","bob", Priority.HIGH, Status.IN_PROGRESS);

        Task taskForAnn = new Task("s15d2","dummy desc","ann", Priority.HIGH, Status.ASSIGNED);
        Task taskForAnn2 = new Task("s15d2","dummy desc 2","ann", Priority.MED, Status.IN_PROGRESS);

        Task taskForCarol = new Task("s15d2","dummy desc","carol", Priority.HIGH, Status.ASSIGNED);
        Task taskForCarol2 = new Task("s15d2","dummy desc 2","carol", Priority.LOW, Status.IN_PROGRESS);



        Task taskunAssigned = new Task("s15d2","dummy desc",null, Priority.HIGH, Status.ASSIGNED);
        Task taskunAssigned2= new Task("s15d2","dummy desc 2",null, Priority.LOW, Status.IN_PROGRESS);

        Set<Task> annsTasks = new LinkedHashSet<>();
        annsTasks.add(taskForAnn);
        annsTasks.add(taskForAnn2);
        annsTasks.add(taskDummy);

        Set<Task> bobsTasks = new LinkedHashSet<>();
        bobsTasks.add(taskDummy);
        bobsTasks.add(taskForBob2);


        Set<Task> carolsTasks = new LinkedHashSet<>();
        carolsTasks.add(taskForCarol);
        carolsTasks.add(taskForCarol2);

        Set<Task> unassignedTasks = new LinkedHashSet<>();
        unassignedTasks.add(taskunAssigned2);
        unassignedTasks.add(taskunAssigned);

        Set<Task> allTasks = new LinkedHashSet<>();
        allTasks.add(taskForBob2);
        allTasks.add(taskDummy);
        allTasks.add(taskForAnn2);
        allTasks.add(taskForAnn);
        allTasks.add(taskForCarol);
        allTasks.add(taskForCarol2);
        allTasks.add(taskunAssigned2);
        allTasks.add(taskunAssigned);

        TaskData taskData = new TaskData(annsTasks,bobsTasks,carolsTasks,unassignedTasks);

        System.out.println("---------**1**---------");
        Set<Task> all = taskData.getTasks("all");
        SetUtils.printAllSet(all);
        System.out.println("---------**2**---------");
        SetUtils.printAllSet(taskData.getTasks("bob"));
        SetUtils.printAllSet(taskData.getTasks("ann"));
        SetUtils.printAllSet(taskData.getTasks("carol"));
        System.out.println("---------**3**---------");
        Set<Task> unAssignedTasks = taskData.getDifference(allTasks, taskData.getTasks("all"));
        SetUtils.printAllSet(unAssignedTasks);

        System.out.println("---------**4**---------");
        System.out.println("---------**-BOB-ANN**---------");
        Set<Task> intersectionBobAnn = taskData.getIntersect(bobsTasks, annsTasks);
        SetUtils.printAllSet(intersectionBobAnn);
        System.out.println("---------**-BOB-CAROL**---------");
        Set<Task> intersectionBobCarol = taskData.getIntersect(bobsTasks, carolsTasks);
        SetUtils.printAllSet(intersectionBobCarol);
        System.out.println("---------**-ANN-CAROL**---------");
        Set<Task> intersectionAnnCarol = taskData.getIntersect(annsTasks, carolsTasks);
        SetUtils.printAllSet(intersectionAnnCarol);

    }
}