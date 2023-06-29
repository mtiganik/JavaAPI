package org.example;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private int PersonId;

    private String FirstName;
    private String LastName;
    private int Age;
    private List<String> posts;

    public List<String> getAllPostsContainingWord(String word) {
        List<String> filteredPosts = new ArrayList<>();
        for(String post: posts) {
            if(post.contains(word))
                filteredPosts.add(post);
        }
        return filteredPosts;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public List<String> getPosts() {
        return posts;
    }

    public void setPosts(List<String> posts) {
        this.posts = posts;
    }
}
