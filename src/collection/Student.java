package collection;


public class Student implements Comparable<Student>{

  public String getFio() {
    return fio;
  }

  public int getAge() {
    return age;
  }

  public int getGrade() {
    return grade;
  }

  private  String fio;
  private int age;
  private int grade;

  public Items getItems() {
    return items;
  }

  private final Items items;


  public Student (String fio,int age, int grade,Items items)
  {
    this.fio = fio;
    this.age = age;
    this.grade=grade;
    this.items = items;
  }


  @Override
  public int compareTo(Student o) {
    return 0;
  }
}
