import java.io.*;

public class FileHandler implements Writable {



    @Override
    public void saveFile(Serializable object) throws IOException {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("FamilyTree.out"));
            objectOutputStream.writeObject(object);
            objectOutputStream.close();

    }

    @Override
    public FamilyTree readFile() throws ClassNotFoundException, IOException {

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("FamilyTree.out"));
        Object familyTree = objectInputStream.readObject();
        objectInputStream.close();
        return (FamilyTree) familyTree;

    }

}
