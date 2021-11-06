package algorithm.review.hash.basic_hash;

public class PracMyHash {
    public Slot[] hashTable;

    public PracMyHash(int size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String value;
        String key;
        Slot next;

        public Slot(String key,String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % hashTable.length;
    }

    public boolean addData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (hashTable[address] != null) {
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
            this.hashTable[address] = new Slot(key, value);
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
        }
        return null;
    }

    public static void main(String[] args) {
        PracMyHash myHash = new PracMyHash(20);
        myHash.addData("dav", "231132");
        myHash.addData("cv", "32132");
        myHash.addData("da", "1541");

        String data = myHash.getData("dav");
        System.out.println(data);

    }

}
