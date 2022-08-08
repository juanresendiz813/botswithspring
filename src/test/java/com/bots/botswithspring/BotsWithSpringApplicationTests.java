package com.bots.botswithspring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

@SpringBootTest
class BotsWithSpringApplicationTests {

    @Test
    void twitterLoadsTest() throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("******************************************")
                .setOAuthConsumerSecret("******************************************")
                .setOAuthAccessToken("******************************************")
                .setOAuthAccessTokenSecret("******************************************");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        List<Status> statuses = twitter.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }

    @Test
    void twitterTweetTest() throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("******************************************")
                .setOAuthConsumerSecret("******************************************")
                .setOAuthAccessToken("******************************************")
                .setOAuthAccessTokenSecret("******************************************");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();

        String myTweet = "Tweeted with spring-boot.";

        try {
            Status status = twitter.updateStatus(myTweet);
            System.out.println("Tweeted to your timeline."+status.getText());

        } catch (TwitterException e){
            e.printStackTrace();
        }
    }

}
