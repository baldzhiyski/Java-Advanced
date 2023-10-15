package Exercise.PetClinics;

import java.util.Iterator;

public class Clinic implements Iterable<Pet>{
    private Pet[] roomsWithPet;

    public Clinic(int number) {
        if(number%2==0){
            throw new IllegalArgumentException("Invalid Operation!");
        }
        this.roomsWithPet = new Pet[number];
    }

    public Pet[] getRoomsWithPet() {
        return roomsWithPet;
    }
    public boolean addPet(Pet pet){
        int room = this.roomsWithPet.length/2;
        int index = 0;
        while (index<this.roomsWithPet.length){
            if (index % 2 == 0) {
                room += index;
            } else {
                room -= index;
            }
            if (this.roomsWithPet[room] == null) {
                this.roomsWithPet[room] = pet;
                return true;
            }
            index++;
        }
        return false;
    }
    public boolean releasePet(){
        int room = this.roomsWithPet.length/2;
        while (room<this.roomsWithPet.length){
            if(this.roomsWithPet[room]!=null){
                this.roomsWithPet[room]=null;
                return true;
            }
            room++;
        }
        int index = 0;
        while (index<room){
            if(this.roomsWithPet[index]!=null){
                this.roomsWithPet[index]=null;
                return true;
            }
            index++;
        }
        return false;
    }
    public boolean hasEmptyRooms(){
        for (int i = 0; i < this.roomsWithPet.length; i++) {
            if(this.roomsWithPet[i]==null){
                return true;
            }
        }
        return false;
    }
    public void print(int room) {
        System.out.println(this.roomsWithPet[room - 1] == null ? "Room empty" : roomsWithPet[room - 1].toString());
    }
    @Override
    public Iterator<Pet> iterator() {
        return new Iterator<Pet>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index<roomsWithPet.length;
            }
            @Override
            public Pet next() {
                return roomsWithPet[index++];
            }
        };
    }
}
