package com.springboot.api.dto;

public class MemberDto {

    private String name;
    private String age;
    private String organization;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "MemberDto{"
                + "name=" + name
                + ", age=" + age
                + ", organization=" + organization
                + "}";
    }
}
