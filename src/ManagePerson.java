import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ManagePerson {
List<Person> personList = new ArrayList<>();
Person person =new Person();
   public void add(){
       personList.add(person);
       System.out.println("Thêm thành công!");

   }

    public void edit(String name) {
       if (findByName(name) != -1){
        personList.set(findByName(name), person);
        System.out.println("Đã sửa xong.");
    } else {
        System.out.println("Không tồn tại " + name);
    }
    }

    public void remove(String name) {
        if (findByName(name) != -1){
            personList.remove(findByName(name));
            System.out.println("Đã xóa.");
        } else {
            System.out.println("Không tồn tại " + name);
        }
    }

    public void display() {
        for (int i = 0; i < personList.size(); i++) {
            System.out.println(personList.get(i));
        }
    }
    public int findByName(String name){
        for (int i = 0; i <personList.size(); i++) {
            if (personList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
    public void findPersonByName(String name){
        if (findByName(name) != -1) {
            System.out.println("Thông tin người cần tìm là:");
            System.out.println(personList.get(findByName(name)));
        } else {
            System.out.println("Không tồn tại " + name);
        }
    }

    public void findByPhoneNumber(String phoneNumber){
        int count = 0;
        for (Person p : personList) {
            if (p.getPhoneNumber().contains(phoneNumber)){
                count++;
                System.out.println(p);
            }
        }
        if (count == 0){
            System.out.println("Không tìm thấy!!!");
        }

}
}