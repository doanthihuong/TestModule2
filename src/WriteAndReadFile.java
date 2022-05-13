import java.awt.image.ImagingOpException;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class WriteAndReadFile {
    ManagePerson managePerson = new ManagePerson();

    public WriteAndReadFile() throws FileNotFoundException {
    }

    public void writeFile(String filePath, List<Person> personList) throws ImagingOpException, IOException {
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        String a = "Tên,Số Điện Thoại,Nhóm,Giới Tính,Địa Chỉ,Email,Ngày Sinh\n";
        for (Person p : personList) {
            a += p.getName() + ","
                    + p.getPhoneNumber() + ","
                    + p.getGroup() + ","
                    + p.getGender() + ","
                    + p.getAddress() + ","
                    + p.getEmail() + ","
                    + p.getDateOfBirth() + '\n';
        }
        bw.write(a);
        bw.close();
        fw.close();
    }

    public void readFile(String filePath, List<Person> personList) throws Exception {
        FileReader fw = new FileReader(filePath);
        Scanner sc = new Scanner(fw);
        personList.clear();
        if (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(s);
            String[] arr = s.split("'");
            Person person = new Person(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]);

            try {
                for (Person person1 : personList) {
                    if (!person1.getPhoneNumber().equals(arr[1])) {
                        personList.add(person);
                    }

                }
            }
            catch (Exception e) {
            }
        }
    }
}