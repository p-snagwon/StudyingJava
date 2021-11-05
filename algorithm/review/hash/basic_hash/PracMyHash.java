package algorithm.review.hash.basic_hash;

public class PracMyHash {
    public Slot[] hashTable;

    public PracMyHash(int size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        public String value;

        public Slot(String value) {
            this.value = value;
        }
    }

    public Integer hashFunc(String key) {
        return (int)(key.charAt(0)) % hashTable.length;
    }

    public boolean addData(String key, String value) {
        Integer address = hashFunc(key);
        if (this.hashTable[address] != null) {
            this.hashTable[address].value = value;
        } else {
            this.hashTable[address] = new Slot(value);
        }
        return true;
    }



    public String getData(String key) {
        Integer address = hashFunc(key);
        if (this.hashTable[address] != null) {
            return this.hashTable[address].value;
        } else {
            return null;
        }
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
