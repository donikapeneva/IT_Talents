package employeePart2Abstr;

public class AllWork {

	private Task[] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;

	AllWork() {
		this.freePlacesForTasks = 10;
		this.currentUnassignedTask = 0;
		this.tasks = new Task[this.freePlacesForTasks];
	}
	
	void addTask(Task task) {
		if(task != null && this.freePlacesForTasks != 0){
			this.tasks[this.tasks.length - this.freePlacesForTasks--] = task;
		}
	}

	Task getNextTask() {
		if(this.currentUnassignedTask != this.tasks.length){
			return this.tasks[this.currentUnassignedTask++];
		} else {
			return null;
		}
	}

	boolean isAllWorkDone() {
		for(int i = 0; i < tasks.length; i++){
			if(this.tasks[i] == null){
				continue;
			} 
			
			if (this.tasks[i].getWorkingHours() != 0){
				return false;
			}
		}
		return true;
	}

}
