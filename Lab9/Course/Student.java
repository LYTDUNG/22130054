package Lab9;

public class Student {
    private String id;
    private String name;
    private int year;

    public Student(String id, String name, int year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", year=" + year + "]";
    }
}
