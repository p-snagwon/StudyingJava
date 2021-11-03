package algorithm.Hash;

public class MyHash_close {
    public Slot[] hashTable;

    public MyHash_close(Integer size) {
        hashTable = new Slot[size];
    }

    public class Slot{
        String key;
        String value;

        Slot(String key, String value) {
            this.value = value;
            this.key = key;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                this.hashTable[address].value = value;
                return true;
            } else {
                Integer currAddress = address +1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        this.hashTable[currAddress].value = value;
                        return true;
                    } else {
                        currAddress ++;
                        if (currAddress >= this.hashTable.length) {
                            return false;
                        }
                    }
                    this.hashTable[currAddress] = new Slot(key, value);
                    return true;
                }
            }

        } else {
            this.hashTable[address] = new Slot(key,value);

        }
        return true;
    }

    public String getData(String key) {
        Integer address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            if (this.hashTable[address].key == key) {
                return this.hashTable[address].value;
            } else {
                Integer currAddress = address + 1;
                while (this.hashTable[currAddress] != null) {
                    if (this.hashTable[currAddress].key == key) {
                        return this.hashTable[currAddress].value;
                    } else {
                        currAddress++;
                        if (currAddress >= this.hashTable.length) {
                            return null;
                        }
                    }
                }
                return null;
            }

        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        MyHash_close mainObject = new MyHash_close(20);
        mainObject.saveData("Davide", "0132101020");
        mainObject.saveData("Davidddde", "212121");
        mainObject.saveData("func-coiding", "010");
        System.out.println(mainObject.getData("Davide"));

    }
}
