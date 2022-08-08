package com.bots.botswithspring.bots.twitter;

import twitter4j.Status;
import twitter4j.TwitterException;

import java.util.List;

public interface TwitterBotInter {
    List<String> landingList() throws TwitterException;
}
