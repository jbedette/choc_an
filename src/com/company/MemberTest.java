package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    @Test
    void getMemNum() {
        String []a =  {"a","b","c","d"};
        Member member = new Member(a,"12345","696969696","true");
        System.out.print(member.getMemNum());
    }

    @Test
    void getMemValid() {
        String []a =  {"a","b","c","d"};
        Member member = new Member(a,"12345","696969696","true");
        System.out.print(member.getMemValid());
    }

    @Test
    void dispAll() {
        String []a =  {"a","b","c","d"};
        Member member = new Member(a,"12345","696969696","true");
        member.dispAll();
    }
}
