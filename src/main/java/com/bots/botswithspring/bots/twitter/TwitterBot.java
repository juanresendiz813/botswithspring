package com.bots.botswithspring.bots.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
public class TwitterBot implements TwitterBotInter{

    @Autowired
    public TwitterBot(){
        return;
    }

    private List<String> twitterFeed() throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("******************************************")
                .setOAuthConsumerSecret("******************************************")
                .setOAuthAccessToken("******************************************")
                .setOAuthAccessTokenSecret("******************************************");
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        List<Status> statuses = twitter.getHomeTimeline();
        List<String> l = new ArrayList<>();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
             l.add(status.getUser().getName() + ":" +
                    status.getText());
        }
        return l;
    }

    public List<String> landingList() throws TwitterException {
        return twitterFeed();

    }

}
