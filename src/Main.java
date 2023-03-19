import java.io.*;
import java.util.InputMismatchException;

public class Main {

    /*
    Создать класс Person  с полями  name  и age  и затем записать несколько обьектов этого класса в файл
     */
    public static void main(String[] args) {

        Person john = new Person("John",28);
        Person mia = new Person("Mia",30);
        Person rick = new Person("Rick",25);
        File PersonList = new File("Persons.txt");
        Person[] array = new Person[3];
        array[0]=john;
        array[1]=mia;
        array[2]=rick;
        savingFile(array,"Person.txt");
        fileRead("Person.txt");


    }
    public static void savingFile(Person[]array,String txt){
        for (int i = 0; i < array.length; i++) {
            try(BufferedWriter saver = new BufferedWriter(new FileWriter(txt,true))){
                saver.write(array[i].name+" ");
                saver.write(array[i].age+"\n");
            }catch(IOException e){
                System.out.println("Запись не удалась.");
            }
        }
        System.out.println("Запись в файл прошла успешно.");
    }
    public static void fileRead(String txt){

        try(BufferedReader reader = new BufferedReader(new FileReader(txt))){
            String counter =" ";
            while((counter = reader.readLine()) != null) {
                System.out.println(counter);
            }
        }catch(IOException e){
            e.getMessage();
        }
        System.out.println("\nЧтение завершено.");
    }
}
/*
OUT:
Запись в файл прошла успешно.
John 28
Mia 30
Rick 25

Чтение завершено.
 */