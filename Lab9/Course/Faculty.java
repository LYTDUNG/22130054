package Lab9;

import java.util.*;

import java.util.*;

public class Faculty {
	private String name;
	private String address;
	private List<Course> courses;

	public Faculty(String name, String address, List<Course> courses) {
		this.name = name;
		this.address = address;
		this.courses = courses;
	}

	public Course getMaxPracticalCourse() {
		Course maxPracticalCourse = null;
		for (Course course : courses) {
			if (course.getType().equals("TH")) {
				if (maxPracticalCourse == null)
					maxPracticalCourse = course;
				else if (course.getStudents().size() > maxPracticalCourse.getStudents().size())
					maxPracticalCourse = course;
			}
		}
		return maxPracticalCourse;

	}

	public Map<Integer, List<Student>> groupStudentsByYear() {
		Map<Integer, List<Student>> studentByYear = new HashMap<>();
		for (Course course : courses) {
			for (Student student : course.getStudents()) {
				int key = student.getYear();
				List<Student> values = new ArrayList<>();
				if (studentByYear.containsKey(key))
					values.add(student);
				else {
					values = studentByYear.get(key);
					if (!values.contains(student))
						values.add(student);
				}
			}
		}
		return studentByYear;
	}

	public Set<Course> filterCourses(String type) {
		Set<Course> result = new TreeSet<>(
			    Comparator.<Course, Integer>comparing(course -> course.getStudents().size())
			              .reversed()
			);
	    for (Course course : courses) {
	        if (course.sameType(type)) {
	            result.add(course);
	        }
	    }

	    return result;
	}

    @Override
    public String toString() {
        return "Faculty [name=" + name + ", address=" + address + ", courses=" + courses + "]";
    }

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();

        List<Student> students1 = new ArrayList<>();
        students1.add(new Student("1", "Student1", 2018));
        students1.add(new Student("2", "Student2", 2019));
        courses.add(new Course("1","Course1", "Thuc hanh", students1, "Lecture1"));

        List<Student> students2 = new ArrayList<>();
        students2.add(new Student("1", "Student1", 2018));
        courses.add(new Course("2", "Course2", "Li Thuyet", students2, "Lecture2"));

        // Add more courses as needed...

        Faculty khoa = new Faculty("CNTT", "Nong Lam", courses);

        System.out.println("All Courses:");
        System.out.println(khoa);

        System.out.println("\nFiltered Courses (Type: Li Thuyet):");
        Set<Course> filteredCourses = khoa.filterCourses("Li Thuyet");
        for (Course course : filteredCourses) {
            System.out.println(course);
        }
    }
}