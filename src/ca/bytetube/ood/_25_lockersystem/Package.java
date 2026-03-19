package ca.bytetube.ood._25_lockersystem;

public class Package {
    private int size;
    private String id;
    private String desc;

    public Package(String id, int size, String desc) {
        this.size = size;
        this.id = id;
        this.desc = desc;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }



    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Package{" +
                "size=" + size +
                ", id='" + id + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
