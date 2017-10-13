package twitt;

import java.util.List;

import javax.swing.JOptionPane;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwittCalls {

	public void makeTwittCall(String Query) throws TwitterException {
        Twitter twitter = new TwitterFactory().getInstance();
        try {
            Query query = new Query(Query);
            QueryResult result;
            do {
            	
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
}
	}

	public static void main(String[] args) throws TwitterException {
		TwittCalls twc = new TwittCalls();
		twc.makeTwittCall(JOptionPane.showInputDialog("TwitterSökning?"));
	}

}
