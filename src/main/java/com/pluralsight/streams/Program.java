package com.pluralsight.streams;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        // Creating instances of the Person class
        Person person1 = new Person("John", "Doe", 25);
        Person person2 = new Person("Jane", "Smith", 30);
        Person person3 = new Person("Alice", "Johnson", 22);
        Person person4 = new Person("Bob", "Williams", 40);
        Person person5 = new Person("Eva", "Davis", 28);
        Person person6 = new Person("Charlie", "Miller", 35);
        Person person7 = new Person("Sophia", "Brown", 26);
        Person person8 = new Person("Daniel", "Taylor", 32);
        Person person9 = new Person("Olivia", "Moore", 27);
        Person person10 = new Person("Michael", "Clark", 38);
        Person person11 = new Person("Sophia", "Clark", 50);

        // Creating a list to store the people
        List<Person> peopleList = new ArrayList<>();

        // Adding people to the list
        peopleList.add(person1);
        peopleList.add(person2);
        peopleList.add(person3);
        peopleList.add(person4);
        peopleList.add(person5);
        peopleList.add(person6);
        peopleList.add(person7);
        peopleList.add(person8);
        peopleList.add(person9);
        peopleList.add(person10);
        peopleList.add(person11);


        // Printing information about each person in the list
//        for (Person person : peopleList) {
//            System.out.println("Name: " + person.getFirstName() + " " + person.getLastName() + ", Age: " + person.getAge());

//        int sum = 0;
//
//        for(Person person: peopleList) {
//            sum += person.getAge();
//        }
//
//            double average = (double) sum /peopleList.size();
//
//
//            System.out.println("The average age of this group is: " + average);


      //nameSearch();

        System.out.println("What would you like to do?");
        System.out.println("[1] Search by name");
        System.out.println("[2] Get average age");
        System.out.println("[3] Find the eldest/youngest");

        Scanner keyboard = new Scanner(System.in);
        int input = keyboard.nextInt();

        switch (input){

            case 1:
                nameSearch(peopleList);
                break;
            case 2:
                getAverage(peopleList);
                break;
            case 3:
                getEldest(peopleList);
                getYoungest(peopleList);
                break;
        }

    }


    public static void nameSearch(List<Person> peopleList){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How would you like to search; by first or last name?");
        System.out.println("Enter [1] for first name or [2] for last name");
        int input = keyboard.nextInt();

        if(input == 1){


            System.out.println("Enter first name to search: ");
            String firstName = keyboard.next();

            peopleList.stream()
                    .filter(person -> person.getFirstName().equalsIgnoreCase(firstName))
                    .forEach(System.out::println);



//            for(Person person: peopleList){
//
//                if(firstName.equalsIgnoreCase(person.getFirstName())){
//
//                    System.out.println(person);
//                }
//
//            }
        }else if(input ==2){
            System.out.println("Enter last name to search: ");
            String lastName = keyboard.next();

            peopleList.stream()
                    .filter(person -> person.getLastName().equalsIgnoreCase(lastName))
                    .forEach(System.out::println);




//            for(Person person: peopleList){
//
//                if(lastName.equalsIgnoreCase(person.getLastName())){
//                    System.out.println(person);
//                }
//
//            }
//
//
        }



    }

    public static void getAverage(List<Person> peopleList){
//        List<Person> peopleList = new ArrayList<>();


        OptionalDouble average = peopleList.stream()

                //Lambda re
                .mapToInt(person -> person.getAge())
                .average();

     System.out.println(average.getAsDouble());

    }

    public static void getEldest(List<Person> peopleList){


        int eldest = peopleList.stream()

                //Below is an example of a method reference (Person::getAge)
                .mapToInt(Person::getAge)
                .reduce(Integer.MIN_VALUE,Integer::max);
                System.out.println(eldest);


    }

    public static void getYoungest(List<Person> peopleList){


        int youngest = peopleList.stream()
                //person -> person.getAge()
//              person is the input parameter.
//              person.getAge() is the body of the lambda expression, representing the method call to get the age of the person object.
                .mapToInt(person -> person.getAge())
                .reduce(Integer.MAX_VALUE,Integer::min);
                 System.out.println(youngest);

    }
}