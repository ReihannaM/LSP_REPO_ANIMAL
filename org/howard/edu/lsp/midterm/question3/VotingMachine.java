package src.org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

class VotingMachine {
    private Map<String, Integer> votes;

    public VotingMachine() {
        votes = new HashMap<>();
    }

    public void addCandidate(String name) {
        if (!votes.containsKey(name)) {
            votes.put(name, 0);
        }
    }

    public boolean castVote(String name) {
        if (votes.containsKey(name)) {
            votes.put(name, votes.get(name) + 1);
            return true;
        }
        return false;
    }

    public String getWinner() {
        String winner = null;
        int maxVotes = 0;
        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}

//citation: stack overflow
