package scheduler;

import java.util.LinkedList;
import java.util.Queue;

public class Scheduler {

	Queue<ITask> tasks = new LinkedList<ITask>();

	void push(ITask task) {
		this.tasks.offer(task);
	}

	public static void main(String[] args) {
		Scheduler scheduler = new Scheduler();
		
		scheduler.push(() -> System.out.println("Task 1: clean the room"));
		scheduler.push(() -> System.out.println("Task 2: make a pizza"));
		scheduler.push(() -> System.out.println("Task 3: eat the pizza"));
		scheduler.push(() -> System.out.println("Task 4: go to walk"));
		scheduler.push(() -> System.out.println("Task 5: sleep"));
		
		while(true){
			if(scheduler.tasks.isEmpty()){
				break;
			}
			scheduler.tasks.poll().doWork();
		}
	}

}
