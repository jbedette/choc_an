package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberListTest {

    @Test
    void dispAll() {
        MemberList memberList = new MemberList();
        memberList.dispAll();
    }

    @Test
    void getName() {
        MemberList memberList = new MemberList();
        memberList.getName("Winston Brown");
        memberList.getName("Winston_Brown");
        memberList.getName("Brown Winston");
    }

    @Test
    void verifyMem() {
        MemberList memberList = new MemberList();
        memberList.verifyMem(98765321);
        memberList.verifyMem(98765);
    }

    @Test
    void addMember() {
        MemberList memberList = new MemberList();
        memberList.addMember("a","b","c","d","00000","true");
        memberList.addMember("w","x","y","z","99999","false");
        memberList.dispAll();
    }

    @Test
    void removeMem() {
        MemberList memberList = new MemberList();
        memberList.dispAll();
        memberList.removeMem("987654321");
        dispAll();

    }
}
