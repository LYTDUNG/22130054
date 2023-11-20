package Lab9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Course {
    private String courseId;
    private String courseName;
    private String type;
    private List<Student> students;
    private String lecture;

    public Course(String courseId, String courseName, String type, List<Student> students, String lecture) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.type = type;
        this.students = students;
        this.lecture = lecture;
    }

    public String getType() {
        return type;
    }

    public List<Student> getStudents() {
        return students;
    }


    public boolean moreThanStudent(Course that) {
        return this.students.size() > that.students.size();
    }

    public Map<Integer, List<Student>> groupStudentsByYear() {
        Map<Integer, List<Student>> result = new HashMap<>();
        for (Student student : students) {
            int year = student.getYear();
            if (result.containsKey(year)) {
                result.get(year).add(student);
            } else {
                List<Student> temp = new ArrayList<>();
                temp.add(student);
                result.put(year, temp);
            }
        }
        return result;
    }

    public boolean sameType(String thatType) {
        return this.type.equals(thatType);
    }

    public int getNumberStudents() {
        return students.size();
    }

    public String getId() {
        return courseId; // use courseId instead of id
    }

    public String getTitle() {
        return courseName; // use courseName instead of title
    }

    public String getLecture() {
        return lecture;
    }

    @Override
    public String toString() {
        return "Course [id=" + courseId + ", size=" + students.size() + ", type=" + type + "]\n";
    }
}
