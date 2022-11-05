package travellingSalesmanProblem;


public class TSP {

	public static void main(String[] args) {
		int cities = 4;
		int[][] graph = {{  0,  5, 45, 40},
				         { 10,  0, 15, 50},
		                 { 55, 20, 0, 25},
				         { 35, 60, 30, 0}};
		
	   boolean[] visitCity = new boolean[cities];
	   visitCity[0] = true;
	   int hamiltonianCycle = Integer.MAX_VALUE;
	   hamiltonianCycle = findHamiltonianCycle(graph,visitCity,0,cities,1,0,hamiltonianCycle);
	   
         System.out.println(hamiltonianCycle);

	}

	private static int findHamiltonianCycle(int[][] graph, boolean[] visitCity, int currentPosition
			, int cities, int count, int cost, int hamiltonianCycle) {
		
		if(count==cities && graph[currentPosition][0]>0) {
			hamiltonianCycle  = Math.min(hamiltonianCycle, cost + graph[currentPosition][0]);
			return hamiltonianCycle;
		}
		
		for(int i=0;i<cities;i++) {
			
			if(visitCity[i] == false  && graph[currentPosition][i]>0) {
				visitCity[i] = true;
				hamiltonianCycle = findHamiltonianCycle(graph,visitCity,i,cities,count+1,cost+graph[currentPosition][i],hamiltonianCycle); 
				visitCity[i] = false;
			}
		}  
		return hamiltonianCycle;
	}

}
