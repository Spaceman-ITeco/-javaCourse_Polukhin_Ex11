package collection;

import java.util.*;

public class Menu {
    Comparator<Student> studentComparator
            = new StudentAgeCompare().thenComparing(new StudentFioCompare());
    Set<Student> studentSet = new TreeSet<Student>(studentComparator) ;
    protected  void menu() {
        System.out.println("1. Ввести ученика.");
        System.out.println("2. Вывести всех учеников по возрастанию.");
        System.out.println("3. Вывести всех учеников по убыванию.");
        System.out.println("4. Удалить ученика по индексу.");
        System.out.println("5. Выйти из программы.");
        Scanner sc = new Scanner(System.in);
        String choice = sc.nextLine();
        if (Objects.equals(choice, "1"))
        {inputPupil();}
        if (Objects.equals(choice, "2"))
        {increasePupilList();}
        if (Objects.equals(choice, "3"))
        {decreasePupilList();}
        if (Objects.equals(choice, "4"))
        {deletePupil();}
        if (Objects.equals(choice, "5"))
        {
            System.exit(0);
        }
        else
        {  System.out.println("Введены некорректные данные. Повторите ввод.");
            menu();}
    }

    protected void inputPupil() {

        System.out.println("Введите ФИО ученика:");
        Scanner scn = new Scanner(System.in);
        String newPupilFIO=scn.nextLine();
        System.out.println("Введите возраст ученика,целое число:");
        Scanner scn2 = new Scanner(System.in);
        int newPupilAge= Integer.parseInt(scn2.nextLine());
        System.out.println("Введите класс ученика:");
        Scanner scn3 = new Scanner(System.in);
        int newPupilGrade= Integer.parseInt(scn3.nextLine());
        System.out.println("Выберите любимый предмет ученика:");
        System.out.println(Arrays.toString(Items.values()));
        Scanner scn4 = new Scanner(System.in);
        Items favourItem = Items.valueOf(scn4.nextLine());
        Student student = new Student(newPupilFIO,newPupilAge,newPupilGrade,favourItem);
        for (Student element: studentSet)
        {if(studentComparator.compare(student,element)==0)
            System.out.println("Такой студент уже есть.");
        }
        studentSet.add(student);
        menu();
    }

    protected void deletePupil() {
        System.out.println("Введите индекс элемента, который нужно удалить:");
        Scanner delete = new Scanner(System.in);
        int deletePupilIndex= Integer.parseInt(delete.nextLine());
        studentSet.remove(studentSet.toArray()[deletePupilIndex]);
        menu();
    }

    protected void decreasePupilList() {
      ArrayList<Student> reverseStudentSet = new ArrayList<>();
       for ( int i = 0; i<= studentSet.toArray().length-1; i++)
       {
             reverseStudentSet.add((Student)studentSet.toArray()[studentSet.toArray().length-1-i]);
           }
        for (Student element: reverseStudentSet)
        {System.out.println(element.getFio() + " "+ element.getAge()+ " " + element.getGrade()
                + " " + element.getItems());}

        menu();
    }

    protected void increasePupilList() {
        for (Student element: studentSet)
        {System.out.println(element.getFio() + " "+ element.getAge()+ " " + element.getGrade()
                + " " + element.getItems());}
        menu();
    }


}

class StudentFioCompare implements Comparator<Student>{

    @Override
    public int compare(Student student1, Student student2) {
        return student1.getFio().compareTo(student2.getFio());
    }
}

class  StudentAgeCompare implements Comparator<Student>
{
    @Override
    public int compare(Student student1, Student student2) {
        return student1.getAge()-student2.getAge();

    }
}
