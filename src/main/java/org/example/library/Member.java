package org.example.library;

public class Member extends User{
    private String membershipId;

    public Member(String name, String password, UserType userType, String membershipId) {
        super(name, password, userType);
        this.membershipId = membershipId;
    }

    public Member(String name, String password, UserType userType) {
        super(name, password, userType);
    }


    public String getMembershipId() {
        return membershipId;
    }

}
