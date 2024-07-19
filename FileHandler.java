import java.io.*;

public class FileHandler {
    public static void saveSchoolToFile(School school, String filename) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(school);
        } catch (IOException e) {
            throw new IOException("Error saving school data to file", e);
        }
    }

    public static School loadSchoolFromFile(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            return (School) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IOException("Error loading school data from file", e);
        }
    }
}
