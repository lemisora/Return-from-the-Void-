import java.util.ArrayList;

class User{
    private String user;
    private String pasword;
    private ArrayList<ArrayList<Integer>> scores;

    public User(String user, String pasword){
        this.user = user;
        this.pasword = pasword;
        this.scores = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<3; i++){
            this.scores.add(new ArrayList<Integer>());
        }
    }

    public boolean log(String user, String pasword){
        return (user.compareTo(this.user) == pasword.compareTo(this.pasword));
    }

    public Integer getMaxScore(int level){
        Integer max = 0;
        for(int i=0; i<this.scores.get(level-1).size(); i++){
            if(this.scores.get(level-1).get(i) > max){
                max = this.scores.get(level-1).get(i);
            }
        }
        return max;
    }

    public void saveScore(int level, int score){
        this.scores.get(level-1).add(score);
    }

    public ArrayList<Integer> getScore(int level){
        return this.scores.get(level-1);
    }

}