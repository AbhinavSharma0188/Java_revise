import java.util.*;

class BrowserHistory {

    private List<String> history;
    private int curr;
    private int last;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        curr = 0;
        last = 0;
    }

    public void visit(String url) {
        curr++;
        if (curr < history.size()) {
            history.set(curr, url);
        } else {
            history.add(url);
        }
        last = curr;
    }

    public String back(int steps) {
        curr = Math.max(0, curr - steps);
        return history.get(curr);
    }

    public String forward(int steps) {
        curr = Math.min(last, curr + steps);
        return history.get(curr);
    }
}