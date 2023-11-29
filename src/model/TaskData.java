package model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTask;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks,Set<Task> unassignedTask) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTask = unassignedTask;
    }

    public Set<Task> getAnnsTasks() {
        return annsTasks;
    }

    public void setAnnsTasks(Set<Task> annsTasks) {
        this.annsTasks = annsTasks;
    }

    public Set<Task> getBobsTasks() {
        return bobsTasks;
    }

    public void setBobsTasks(Set<Task> bobsTasks) {
        this.bobsTasks = bobsTasks;
    }

    public Set<Task> getCarolsTasks() {
        return carolsTasks;
    }

    public void setCarolsTasks(Set<Task> carolsTasks) {
        this.carolsTasks = carolsTasks;
    }

    public Set<Task> getTasks(String owner){
        if(owner.equalsIgnoreCase("ann")){
            return this.annsTasks;
        }
        if(owner.equalsIgnoreCase("bob")){
            return this.bobsTasks;
        }
        if(owner.equalsIgnoreCase("carol")){
            return this.carolsTasks;
        }
        if(owner.equalsIgnoreCase("all")){
            return getUnion(bobsTasks,annsTasks,carolsTasks);
        }
        return new HashSet<>();
    }
    public Set<Task> getUnion(Set<Task>...sets){
        HashSet<Task> total = new LinkedHashSet<>();
        for(Set<Task> taskSet:sets){
            total.addAll(taskSet);
        }
        return total;
    }
    public Set<Task> getIntersect(Set<Task> first, Set<Task> second){
        Set<Task> intersect = new HashSet<>(first);
        intersect.retainAll(second);
        return intersect;
    }
    public Set<Task> getDifference(Set<Task> first, Set<Task> second){
        Set<Task> difference = new HashSet<>(first);
        difference.removeAll(second);
        return difference;

    }
}
