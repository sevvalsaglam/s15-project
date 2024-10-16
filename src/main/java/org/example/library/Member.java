package org.example.library;

import java.util.Objects;

public class Member extends User{
    private String memberShipId; // Üyelik kimlik numarası

    public Member(String name, String password, UserType userType, String memberShipId) {
        super(name, password, userType);
        this.memberShipId = memberShipId;
    }

    // Üyelik kimliğini döndürme
    public String getMemberShipId() {
        return memberShipId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberShipId, member.memberShipId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(memberShipId);
    }
}
