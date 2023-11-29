package utils;

import model.Task;

import java.util.Iterator;
import java.util.Set;

public class SetUtils {
    public static void printAllSet(Set<Task> set){
        Iterator<Task> iterator = set.iterator();
        while (iterator.hasNext()){
            Task task = iterator.next();
            System.out.println("task detail: Project:"+task.getProject()
                    +" Description: "+task.getDescription()
                    +" Assignee: "+task.getAssignee()+" Priority: "
                    +task.getPriority()+" Status: "+task.getStatus());
        }
    }
}
