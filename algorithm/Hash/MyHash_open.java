package algorithm.Hash;

public class MyHash_open {
    public Slot[] hashTable;

    public MyHash_open(Integer size) {
        hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;
        Slot next;

        Slot(String key, String value) {
            this.value = value;
            this.key = key;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            Slot prevSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    findSlot.value = value;
                    return true;
                } else {
                    prevSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);

        } else {
            this.hashTable[address] = new Slot(key,value);

        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash_open mainObject = new MyHash_open(20);
        mainObject.saveData("Davide", "0132101020");
        mainObject.saveData("Davidddde", "212121");
        mainObject.saveData("func-coiding", "010");
        System.out.println(mainObject.getData("Davide"));

    }
}
