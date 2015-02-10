/*
Imagine you have a call center with three levels of employees: respondent, manager, and director. 
An incoming telephone call must be first allocated to a respondent who is free. 
If the respondent can't handle the call, he or she must escalate the call to a manager.
If the manager is not free or not able to handle it, then the call should be escalated to a director.
Design the classes and data structures for this problem.
Implement a method dispatchCall() which assigns a call to the first available employee.
*/

//route the calls to the correct person
public class CallHandler{
	private static CallHandler instance;

	//3 levels of employees
	private final int LEVELS = 3;

	//initialize number of each level
	private final int NUM_RESPONDENTS = 10;
	private final int NUM_MANAGERS = 4; 
	private final int NUM_DIRECTORS = 2;

	//list of emplyees by level
	ArrayList<ArrayList<Employee>> employeeLevels = new ArrayList<ArrayList<Employee>>();

	//queues for each call's rank
	ArrayList<ArrayList<Call>> callQueues;

}

//represents a call from a user. it has a minimum rank and is assigned to the first emplyee who can handle it
public class Call{
	//minimal rank of employee who can handle the call
	private Rank rank;

	//person who is calling
	private Caller caller;

	//employee who is handling call
	private Employee handler;

	public Call(Caller c){
		rank = Rank.Responder;
		caller = c;
	}

	public void setHandler(Employee e){
		handler = e;
	}

	public void reply(String message){

	}

	public Rank getRank(){
		return rank;
	}

}

abstract class Employee{
	private Call currentCall = null;
	protected Rank rank;

	public Employee(){

	}
	
}