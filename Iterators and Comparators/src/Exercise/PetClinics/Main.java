package Exercise.PetClinics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Pet> pets = new HashMap<>();
        Map<String, Clinic> clinics = new HashMap<>();
        int number = Integer.parseInt(scan.nextLine());
        while (number-->0){
            String[] commands = scan.nextLine().split("\\s+");
            if(commands[0].equals("Create")){
                if(commands[1].equals("Pet")){
                    String petName = commands[2];
                    int age = Integer.parseInt(commands[3]);
                    String kind = commands[4];
                    pets.putIfAbsent(petName,new Pet(petName,age,kind));
                }else{
                    String name = commands[2];
                    int rooms = Integer.parseInt(commands[3]);
                    try {
                        clinics.putIfAbsent(name,new Clinic(rooms));
                    }catch (IllegalArgumentException exception){
                        System.out.println(exception.getMessage());
                    }
                }
            }else if(commands[0].equals("Add")){
                String petName = commands[1];
                String clinicName = commands[2];
                System.out.println(clinics.get(clinicName).addPet(pets.get(petName)));
            }else if(commands[0].equals("Release")){
                System.out.println(clinics.get(commands[1]).releasePet());
            }else if(commands[0].equals("Print")){
                if(commands.length==2){
                    Arrays.stream(clinics.get(commands[1]).getRoomsWithPet()).map(room -> room == null
                            ? "Room empty" : room.toString()).forEach(System.out::println);
                }else{
                    int room = Integer.parseInt(commands[2]);
                    clinics.get(commands[1]).print(room);
                }
            }else if(commands[0].equals("HasEmptyRooms")){
                System.out.println(clinics.get(commands[1]).hasEmptyRooms());
            }
        }
    }
}
