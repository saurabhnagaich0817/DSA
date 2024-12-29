import java.util.ArrayList;
import java.util.List;
class RecentCounter {
    List<Integer> list = new ArrayList<>();
    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        int duration = 3000;
        list.add(t);
        int startTime = t-duration;
        int counter = 0;
        for(Integer n : list) {
            if(n >= startTime && n <= t) {
                counter ++;
            }
        }
        return counter;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */