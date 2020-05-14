import java.util.Arrays;

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {

        int count = 0;
        for(int i = 0; i < rating.length; i++){
            for(int j = i+1; j < rating.length; j++){
                for(int k = j+1; k < rating.length; k++){
                    if(rating[i] > rating[j] && rating[j] > rating[k]) {
                        count++;
                    } else if(rating[i] < rating[j] && rating[j] < rating[k]) {
                        count++;
                    }
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int [] rating = {2,5,3,4,1};
        CountNumberOfTeams c = new CountNumberOfTeams();
        System.out.println(c.numTeams(rating));

    }

}
