package com.example.demo.model;


import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@ToString
public class Review implements Serializable {
    @Id
    private String username;
    private String experience;
    private String feedback;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

//    @Override
//    public String toString()
//    {
//        return "Review [UserName=" + username + ", experience=" + experience + ", description=" + feedback
//                + "]";
//    }

}
