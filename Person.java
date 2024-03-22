// Each person was considered as Node
// One way linking is used for efficiency
public class Person {
    String name;
    String tel_no;
    Person next;

    // The null assignment process
    public Person(){
        next=null;
    }
    // The new one adding process
    public Person(String name, String tel_no) {
        this.name = name;
        this.tel_no = tel_no;
        this.next = null;
    }
}
