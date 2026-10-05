class Student {
    int count = 0; // instance field

    Student() {
        count++;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        System.out.println(s1.count); // 1
        System.out.println(s2.count); // 1
        System.out.println(s3.count); // 1
    }
}
