package ca.bytetube.ood._07_shippingcost;

public class Member {
    private String id;
    private String name;
    private MemberShipLevel level;

    public Member(String id, String name, MemberShipLevel level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberShipLevel getLevel() {
        return level;
    }

    public void setLevel(MemberShipLevel level) {
        this.level = level;
    }
}
