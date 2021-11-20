package Q2;

import java.util.*;
import java.lang.Math;

//-----------------------------------------
// NAME: Future Hu
// STUDENT NUMBER: 7859844
// COURSE: COMP3190, SECTION: A01
// INSTRUCTOR: Dylan Fries
// ASSIGNMENT: 1, QUESTION: 2
//-----------------------------------------
public class A1Q2 {

    private static char[][] map;    // The map, from stdin
    private static int length, width;   // Size of map

    // This is "Decision Making Queue".
    // For ALL the bombs,
    // it finds the optimal sequence to disarm bombs.
    // i.e. Go to A first, and then C, and then F.
    private static Queue<Decision> decisionMakingQueue;

    public static void main(String[] args) {
        // Read from stdin and construct map
        Scanner keyboard = new Scanner(System.in);

        String[] size = keyboard.nextLine().split(",");
        width = Integer.parseInt(size[0]);
        length = Integer.parseInt(size[1]);

        map = new char[width][length];

        for (int line = 0; line < width; line++)
            map[line] = keyboard.nextLine().toCharArray();

        // Start searching
        decisionMakingQueue = new LinkedList<>();
        solve();
    }

    /**
     * This method solve the entire question
     */
    public static void solve() {
        int bombNum = 0;
        Tile initial = null;
        ArrayList<Bomb> bombList = new ArrayList<>();   // All the bombs
        Decision best = null;

        // Locate initial position and bombs
        for (int row = 0; row < width; row++) {
            for (int col = 0; col < length; col++) {
                if (map[row][col] == '@')
                    initial = new Tile(row, col);

                if (Character.isLetter(map[row][col])) {
                    char content = map[row][col];
                    int time = (content - 64) * 10;

                    bombList.add(new Bomb(new Tile(row, col), time));
                    bombNum ++;
                }
            }
        }

        // Initialize searching queue
        // Put the first few Decisions into queue
        decisionMakingQueue.clear();
        for (Bomb target: bombList) {

            // Make a copy of bomb list for each new Decision
            ArrayList<Bomb> bombListCopy = new ArrayList<>();
            for (Bomb item: bombList)
                bombListCopy.add(item.clone());

            Decision next = new Decision(null, initial, bombListCopy, bombList.indexOf(target));
            decisionMakingQueue.offer(next);
        }

        // Do the search... until we examine the entire space
        while (!decisionMakingQueue.isEmpty()) {
            Decision now = decisionMakingQueue.poll();

            // Update the best Decision so far
            if (best == null || now.getScore() > best.getScore())
                best = now;

            for (Decision next: now.getNext())
                decisionMakingQueue.offer(next);
        }

        if (best != null) { // We found the optimal solution
            int[] infoPackage = best.backTrack();

            assert (infoPackage.length == 3);

            System.out.println("bombs disarmed: " + infoPackage[0]);
            System.out.println("bombs exploded: " + (bombNum - infoPackage[0]));
            System.out.println("cost of plan: " + infoPackage[1]);
            System.out.println("states examined: " + infoPackage[2]);
        }
        else    // We didn't find any solution
            System.out.println("Searching failed for unknown reason...\nOr there is no bomb at all");
    }

    /**
     * Accessor
     */
    public static char[][] getMap() { return map.clone(); }
}

/**
 * Compare and sort State in priority queue
 */
class StateComparator implements Comparator<State>{
    public int compare(State s1, State s2) {
        double heuristicDiff = s1.getHeuristic() - s2.getHeuristic();
        double totalDiff = s1.getCost() - s2.getCost() + heuristicDiff;

        // Scale up the difference, so it won't round to 0
        return (int)Math.round(totalDiff * 10);
    }
}

/**
 * This is State,
 * it represents a single move (or position) in a path finding process
 * The path finding process has only ONE goal, NOT multiple bombs
 *
 * By combining States, we will have a space that describes
 * all of the possible ways to reach the goal position from initial position
 */
class State {
    private static char[][] map = A1Q2.getMap();
    private static ArrayList<Tile> visited = new ArrayList<>(); // The Tiles that already visited

    private State prev; // Previous move
    private Tile position;  // Position of current tile
    private Tile target;    // Position of the bomb
    private int cost;   // Cost of current state

    /**
     * Reset the visited tile list
     */
    public static void refresh() { visited = new ArrayList<>(); }

    /**
     * Constructor
     * @param prev Previous state
     * @param position Current position
     * @param target Target (bomb) position
     * @param cost Cost of current state
     */
    public State(State prev, Tile position, Tile target, int cost) {
        this.prev = prev;
        this.position = position;
        this.target = target;
        this.cost = cost;
    }

    /**
     * Accessor
     */
    public State getPrev() { return prev; }

    /**
     * Get the next possible moves of current position
     *
     * @return A list of next possible moves
     */
    public ArrayList<State> getNext() {
        // Get coordinate of current position
        int x = position.getPosition()[0];
        int y = position.getPosition()[1];

        ArrayList<State> next = new ArrayList<>();

        // Search through 8 surrounding tiles
        // Skip walls and current position
        // Then generate next move
        for (int xRange = -1; xRange <= 1; xRange++) {
            for (int yRange = -1; yRange <= 1; yRange++) {

                boolean good = true;
                char tile = map[x + xRange][y + yRange];
                Tile newTile = new Tile(x + xRange, y + yRange);

                // This ensures tiles already visited will not be generated again
                for (Tile item: visited) {

                    if (Tile.compare(item, newTile)) {
                        good = false;
                        break;
                    }
                }

                // Find cost if tile is valid
                if (good && tile != '#' && (xRange != 0 || yRange != 0)) {
                    int newCost;

                    if (tile == '.')
                        newCost = 2;
                    else if (tile == ':')
                        newCost = 3;
                    else if (tile == '!')
                        newCost = 4;
                    else if (tile == '$')
                        newCost = 5;
                    else
                        newCost = 1;

                    next.add(new State(this, newTile, target, this.cost + newCost));
                    visited.add(newTile);
                }
            }
        }

        return next;
    }

    /**
     * If we are at the bomb's location, then we made it
     * @return  Whether we reach the bomb or not
     */
    public boolean checkSolution() { return Tile.compare(position, target); }

    /**
     * Accessor
     */
    public int[] getCoordinate() { return position.getPosition(); }

    /**
     * Accessor
     */
    public int getCost() { return cost; }

    /**
     * Calculate the heuristic,
     * by using Euclidean distance.
     *
     * @return Heuristic of this position
     */
    public double getHeuristic() {
        int xDistance = Math.abs(position.getPosition()[0] - target.getPosition()[0]);
        int yDistance = Math.abs(position.getPosition()[1] - target.getPosition()[1]);
        return Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
    }
}

/**
 * This is Decision,
 * it represents a single move in the entire game,
 * the "move" is considered: which bomb should I go for next
 *
 * By combining Decisions, we will have a space that describes
 * all of the possible sequences about disarming bombs
 * i.e. we can go for A, then C. OR we can go for C, then A.
 */
class Decision {
    private static char[][] map = A1Q2.getMap();
    private static int stateExamined = 0;

    private Decision prev;  // The previous Decision
    private int score;  // The total score so far. Score is used to sort Decisions in queue.
    private Tile initial;   // The initial tile (starting point)
    private Bomb target;    // The bomb (target)
    private ArrayList<Bomb> bombList;   // The list of remaining bombs
    private ArrayList<Tile> route;   // The optimal route of this Decision
    private int cost;   // The cost of this path
    private boolean doable; // Can this decision disarm the bomb in time?

    // This is "Path Finding Queue".
    // For ONE specific initial position and ONE specific bomb,
    // it finds the optimal path if possible.
    private static PriorityQueue<State> pathFindingQueue = new PriorityQueue<>(new StateComparator());

    /**
     * Constructor
     * @param prev Previous Decision
     * @param initial Initial tile (starting point) of this Decision
     * @param bombList A list of remaining bombs
     * @param bombIndex The position of our target in that list of bombs
     */
    public Decision(Decision prev, Tile initial, ArrayList<Bomb> bombList, int bombIndex) {
        this.initial = initial;
        target = bombList.get(bombIndex);
        this.bombList = bombList;
        this.prev = prev;

        if (prev != null)   // This is the first Decision
            this.score = prev.score;
        else    // This is not the first
            this.score = 0;

        // Find the optimal path of this Decision, etc.
        evaluateDecision();
    }

    /**
     * Accessor
     */
    public int getScore() { return score; }

    /**
     * When we have the optimal solution,
     * keep backtracking to the first Decision.
     * then we can summary information and draw the map
     *
     * @return An array contains information about optimal solution
     */
    public int[] backTrack() {
        int disarmed = 0;
        int totalCost = 0;
        ArrayList<Tile> completePath = new ArrayList<>();

        Decision curr = this;

        // Keep going back
        while (this.doable && curr != null) {
            disarmed ++;
            totalCost += curr.cost;
            completePath.addAll(curr.route);

            curr = curr.prev;
        }

        // Draw all of the previous path on the map
        for (Tile path: completePath) {
            int x = path.getPosition()[0];
            int y = path.getPosition()[1];

            if (Character.isDigit(map[x][y]))   // We have visited the Tile
                map[x][y]++;
            else    // We haven't visited
                map[x][y] = '1';
        }

        // Show the map
        for (char[] row: map) {
            for (char tile: row)
                System.out.print(tile + "  ");
            System.out.println();
        }

        return new int[]{disarmed, totalCost, stateExamined};
    }

    /**
     * Get the next possible Decisions: which bomb can I go for next
     *
     * @return A list of next possible Decisions
     */
    public ArrayList<Decision> getNext() {
        ArrayList<Decision> nexts = new ArrayList<>();

        // Set each bomb in the bomb list as target of next Decision
        for (int i  = 0; doable && i < bombList.size(); i++) {

            // Create a copy of current bomb list
            ArrayList<Bomb> remaining = new ArrayList<>();
            for (Bomb item: bombList)
                remaining.add(item.clone());

            Decision nextDecision = new Decision(this, target.getPosition(), remaining, i);

            if (nextDecision.doable)
                nexts.add(nextDecision);
        }

        return nexts;
    }

    /**
     * Here we evaluate this Decision: does it work?
     * Reward score of 1000 if bomb can be disarmed on time
     * then minus the cost
     */
    private void evaluateDecision() {
        // We do the path finding process here
        ArrayList<Object> info = findPath(initial, target);
        assert (info.get(0) instanceof ArrayList);
        assert (info.get(1) instanceof Integer);
        assert (info.get(2) instanceof Integer);

        // Then we have the route, cost, and state examined
        route = (ArrayList<Tile>)info.get(0);
        cost = (Integer)info.get(1);
        stateExamined += (Integer)info.get(2);


        if (cost <= target.getTime())    // Successful disarming bomb
        {
            score += 1000;   // Reward!
            doable = true;  // It worked
            bombList.remove(target);    // Remove current target from the bomb list

            // Remaining bombs are getting closer to explode!
            for (Bomb item: bombList)
                item.reduceTime(cost);
        }
        else // Fail disarming bomb
            doable = false;

        score -= cost;
    }

    /**
     * This method finds the optimal path between
     * ONE specific initial position and ONE specific bomb
     *
     * @param start Tile of starting position
     * @param bomb  The bomb we are looking for
     * @return  A package of: optimal path, the cost, # of states examined
     */
    private static ArrayList<Object> findPath(Tile start, Bomb bomb) {
        State initial, end = null;
        int costOfPath;
        int stateExamined = 0;

        // This is where we record optimal path
        ArrayList<Tile> optimalPath = new ArrayList<>();

        // This is where we record useful info and return to other method
        ArrayList<Object> infoPackage = new ArrayList<>();

        // Clean up the mess
        State.refresh();
        pathFindingQueue.clear();

        // Initialize the searching queue
        initial = new State(null, start, bomb.getPosition(), 0);
        pathFindingQueue.offer(initial);

        // Do the search
        // Check state -> Get next steps -> Check again
        while (end == null && !pathFindingQueue.isEmpty()) {

            State now = pathFindingQueue.poll();
            stateExamined ++;

            if (now.checkSolution())
                end = now;

            for (State next: now.getNext())
                pathFindingQueue.offer(next);
        }


        if (end != null) {  // We found a path
            State trace = end;
            costOfPath = end.getCost();

            // Backtrack through the path and find the optimal one
            while (trace.getPrev() !=  null) {
                int[] coor = trace.getCoordinate();

                Tile record = new Tile(coor[0], coor[1]);
                optimalPath.add(record);

                trace = trace.getPrev();
            }

        } else {    // We didn't find one
            costOfPath = 1000;
        }

        // Package all useful information
        infoPackage.add(optimalPath);
        infoPackage.add(costOfPath);
        infoPackage.add(stateExamined);
        return infoPackage;
    }
}

/**
 * This is Tile
 * It basically does nothing,
 * but put the x and y coordinates together.
 *
 * So I won't bother working with 2 things.
 */
class Tile {
    private int x, y;

    /**
     * Constructor
     * @param x x coordinate
     * @param y y coordinate
     */
    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Compare whether t1 and t2 have same coordinate
     *
     * @param t1 Tile 1
     * @param t2 Tile 2
     * @return Yes or No
     */
    public static boolean compare(Tile t1, Tile t2) { return (t1.x == t2.x && t1.y == t2.y); }

    /**
     * Accessor
     */
    public int[] getPosition() { return new int[]{x, y}; }
}

/**
 * This is Bomb
 * It tells where the bomb is,
 * and how much time do we left to disarm it.
 */
class Bomb {
    private Tile position;
    private int time;

    /**
     * Constructor
     * @param position Position of the bomb
     * @param time  Remaining time to explode
     */
    public Bomb(Tile position, int time) {
        this.position = position;
        this.time = time;
    }

    /**
     * Accessor
     */
    public Tile getPosition() { return position; }

    /**
     * Accessor
     */
    public int getTime() { return time; }

    /**
     * Reduce the remaining time
     * @param amount The amount of time (cost)
     */
    public void reduceTime(int amount) {
        time -= amount;

        if (time < 0)
            time = 0;
    }

    /**
     * Make a copy of this bomb
     *
     * @return A copy
     */
    public Bomb clone() { return new Bomb(position, time); }
}
