class Solution {


    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    LinkedList<String> route = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // Step 1: Build the graph
        for(List<String> ticket: tickets){
            targets.computeIfAbsent(ticket.get(0), k -> new PriorityQueue<>()).add(ticket.get(1));
        }

        visit("JFK");

        return route;
    }

    private void visit(String airport){
        PriorityQueue<String> destinations = targets.get(airport);

        while(destinations!= null && !destinations.isEmpty()){
            visit(destinations.poll());
        }

        route.addFirst(airport);
    }
}
