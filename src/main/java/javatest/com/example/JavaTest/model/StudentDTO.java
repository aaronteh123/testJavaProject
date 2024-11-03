package javatest.com.example.JavaTest.model;

public class StudentDTO {
    private Integer id;
    private String name;
    private String contact;
    private Integer age;

    public StudentDTO(Student student ) {
        this.id = student.getId();
        this.name = student.getSname();
        this.contact = student.getContact();
        this.age = student.getAge();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}


