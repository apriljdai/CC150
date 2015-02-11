/*
Design the data structures for an online book reader system.
*/

//a basic online reading system:
//	1.	user membership createion and extension
//	2.	searching the database of bookds
//	3.	reading a book
//	4.	only one active user at a time
//	5.	only one active book by this user

//class User, Book, and Library

//represents the body of the program, implement the class such that it stores informationabout all the books, deals with user management, and refreshes the display
public class OnlineReaderSystem{
	private Library library;
	private UserManager userManager;
	private Display display;
	private Book activeBook;
	private User activeUser;

	public OnlineReaderSystem(){
		userManager = new UserManager();
		library = new Library();
		display = new Display();
	}

	public Library getLibrary(){
		return library;
	}
	public UserManager getUserManager(){
		return userManager;
	}
	public Display getDisplay(){
		return display;
	}
	public Book getActiveBook(){
		return activeBook;
	}
	public User getActiveUser(){
		return activeUser;
	}

	public void setActiveBook(Book book){
		display.displayBook(book);
		activeBook = book;
	}
	public void setActiveUser(User user){
		display.displayUser(user);
		activeUser = user;
	}
}

//manage the book
public class Library{
	private HashTable<Integer, Book> books;

	public Book addBook(int id, String details){
		if (books.containsKey(id)){
			return null;
		}
		Book book = new Book(id, details);
		books.put(id, book);
		return book;
	}

	public boolean remove(Book b){
		return remove(b.getID());
	}

	public boolean remove(int id){
		if (!book.containsKey(id)){
			return false;
		}
		books.remove(id);
		return true;
	}

	public Book find(int id){
		return books.get(id);
	}
}

//hold data and provide little true functionality
public class Book{
	private int bookId;
	private String details;

	public Book(int id, String det){
		bookId = id;
		details = det;
	}

	public void update(){

	}

	public int getID(){
		return bookId;
	}

	public void setID(int id){
		bookId = id;
	}

	public String getDetails(){
		return details;
	}

	public void setDetails(String details){
		this.details = details;
	}
}

//manage the user
public class UserManager{
	private HashTable<Integer, User> users;

	public User addUser(int id, String details, int accountType){
		if (users.containsKey(id)){
			return null;
		}
		User user = new User(id, details, accountType);
		users.put(id, user);
		return user;
	}

	public boolean remove(User u){
		return remove(u.getID());
	}
	public boolean remove(int id){
		if (!users.containsKey(id))
			return false;
		users.remove(id);
		return true;
	}

	public User find(int id){
		return users.get(id);
	}
}


public class User{
	private int userId;
	private String details;
	private int accountType;

	public void renewMembership(){

	}

	public User(int id, String details, int accountType){
		userId = id;
		this.details = details;
		this.accountType = accountType;
	}

	public int getID(){
		return userId;
	}
	public void setID(int id){
		userId = id;
	}
	public String getDetails(){
		return details;
	}
	public void setDetails(String details){
		this.details = details;
	}
	public int getAccountType(){
		return accountType;
	}
	public void setAccountType(int accountType){
		this.accountType = accountType;
	}
}


public class Display{
	private Book activeBook;
	private User activeUser;
	private int pageNumber = 0;

	public void displayUser(User user){
		activeUser = user;
		refreshUsername();
	}
	public void displayBook(Book book){
		activeBook = book;
		pageNumber = 0;

		refreshTitle();
		refreshDetails();
		refreshPage();
	}

	public void refreshUsername(){

	}
	public void refreshTitle(){

	}
	public void refreshPage(){

	}
	public void refreshDetails(){

	}

	public void turnPageForward(){
		pageNumber++;
		refreshPage();
	}
	public void turnPageBackward(){
		pageNumber--;
		refreshPage();
	}
}


