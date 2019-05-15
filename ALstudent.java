package filerwintoarraylist;

import java.io.*;
import java.util.*;


// Program reads all the lines of blrstudent2.csv
// loads student atrributes to Student object - to be done as assignment

public class ALstudent {

    public static void main(String args[]) {

        String filepath = "C:\\Users\\Bharath\\Documents\\arrayliststudent.csv";
        ArrayList<String> linesRead = new ArrayList<String>();

        ArrayList<Student> records = new ArrayList<Student>();

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String currentline = br.readLine();

            while (currentline != null) {
                linesRead.add(currentline);// Add line to String Arraylist
                currentline = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int rollno = 0, age = 0;
        String token, name = null;
        int count = 0;
        int size = linesRead.size();
        System.out.println("The size of Arraylist in which lines from file are read is " + size + "\n");
        System.out.println("Now printing String Values again directly thru call to print strings of ArrayList");
        System.out.println(linesRead);

        //StringTokenizer stz;
        // Now USe Stringtokenizer to sepearte tokens so that seprated token can be rollno, name and age for Student object
        // initialization.S
        Student sobj;
        //using enhanced loop
        for (String s : linesRead) {
            //System.out.println("Line read from file : " + s);
            String[] tokens = s.split(","); //this splits the line based on "," as delimiter
            //tokens[0] will be rollno, tokens[1] will be name and tokens[2] will be age
            sobj = new Student(Integer.parseInt(tokens[0]), tokens[1], Integer.parseInt(tokens[2]));
            records.add(sobj);
            //System.out.println("Tokens seperated :" + rollno + " " + name + " " + age + "\n");
        } // for loop ends here

        size = records.size();
        System.out.println("\nThe size of Arraylist in which Student Objs are stored is " + size + "\n");

        /*System.out.println("Now printing Object Values through for loop Object");
        for(Object e:records)
            System.out.println(e);
        System.out.println();

        System.out.println("Now printing Object Values through forEach");
        records.forEach((s)-> System.out.println(s));
        System.out.println();*/

        // Both for loop and forEach print junk if object is printed directly.

        // System.out.println(records); Avoid this bad programming


        System.out.println("Now printing Object Values");
        for (Student st : records) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }

       /* System.out.println("\nNow printing Object Values again directly thru call to print objects of ArrayList");
        System.out.println(records); //won't work, displays garbage*/

        System.out.println("\nNow printing Object Values accessing student detials thru ArrayLiast Object");
        for (int i = 0; i < size; i++) {
            System.out.println(records.get(i).rollno + " " + records.get(i).name + " " + records.get(i).age);
            //System.out.println(records.get(i)); won't work, displays garbage
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("\nNow printing specific Values");

        // First task
        System.out.println("\nEnter Student name to filter records : ");
        String nm = scan.next();
        for (Student st1 : records) {
            if (nm.equals(st1.name)) System.out.println(st1.rollno + " " + st1.name + " " + st1.age);
        }

        // Second task
        System.out.println("\nEnter first letter of Student name to filter records : ");
        char c = scan.next().charAt(0);
        for (Student st : records) {
            if (c == (st.name.charAt(0))) System.out.println(st.rollno + " " + st.name + " " + st.age);
        }

        System.out.println("Enter Student age to filter records : ");
        int ag = scan.nextInt();
        for (Student st : records) {
            if (ag == st.age) System.out.println(st.rollno + " " + st.name + " " + st.age);
        }

        // Second task

        System.out.println("\nFiltered records based on Entered Student age and first letter of Student name : ");
        for (Student st : records) {
            if ((ag == st.age) && (c == (st.name.charAt(0))))
                System.out.println(st.rollno + " " + st.name + " " + st.age);

            /*for (Student st1 : records)
                System.out.println(st1.rollno + " " + st1.name + " " + st1.age);*/
        }

    }
}


// Student class and constructor
class Student {
    int rollno;
    String name;
    int age;

    Student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }


}

