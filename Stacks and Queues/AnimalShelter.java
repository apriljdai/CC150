/*
An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis.
People must adopt ither the oldest of all animals at the shelter, or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that kind).
They cannot select which specific animal they would like. Create the data structures to maintain this system and implement operations such as enqueue, dequeueAny, deQueueDog and dequeueCat.
You may use the built-in LinkedList data structure.
*/

public abstract class Animal {
	private int order;
	protected String name;

	public Animal(String n){
		name = n;
	}

	public void setOrder(int ord){
		order = ord;
	}

	public int getOrder(){
		return order;
	}

	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder;
	}
}

public class Dog extends Animal{
	public Dog(String n){
		super(n);//calls the parent constructor
	}
}

public class Cat extends Animal{
	public Cat(String n){
		super(n);
	}
}

public class AnimalQueue{
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;

	public void enqueue(Animal a){
		a.setOrder(order);
		order++;

		//a instanceof b: used to test if an object is of a specified type
		if (a instanceof dog)
			dogs.addLast((Dog) a);
		else if (a instanceof cat)
			cats.addLast((Cat) a);
	}

	public Animal dequeueAny(){
		if (dogs.size() == 0)
			return dequeueCat();
		if (cats.size() == 0)
			return dequeueDog();

		Dog dog = dogs.peek();
		Cat cat = dats.peek();
		if (dog.isOlderThan(cat))
			return dequeueDog();
		else
			return dequeueCat();
	}

	public Dog dequeueDog(){
		return dogs.poll();
	}

	public Cat dequeueCat(){
		return cats.poll();
	}
}
