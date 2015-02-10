/*
Given a directed graph, design an algorithm to find out whether there is a route between two nodes
*/

public enum State{
	Unvisited, Visit, Visiting;
}

public boolean search(Graph g, Node start, Node end){
	//operates as queue
	LinkedList<Node> q = new LinkedList<Node>();

	for (Node u : g.getNodes()){
		u.state = State.Unvisited;
	}

	start.state = State.Visiting;
	q.add(start);
	Node u;
	while (!q.isEmpty()){
		//dequeue
		if (u != null){
			u = q.removeFirst();
			for (Node v : getAdjacent()){
				if (v.state = State.Unvisited){	
					if (v == end){
						return true;
					}
					v.state = State.Visiting;
					q.add(v);
				}
			}
			u.state = State.Visited;
		}
	}
	return false;
}
//BFS is useful to find the shortest path