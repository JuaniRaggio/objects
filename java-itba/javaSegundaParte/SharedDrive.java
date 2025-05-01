import java.util.ArrayList;
import java.util.Objects;

public class SharedDrive implements Iterable<SharedFile> {

  private ArrayList<SharedFile> files = new ArrayList<>();

  public SharedDrive addFile(String fileName, String assignmentName) {
    files.add(new SharedFile(fileName, assignmentName));
    return this;
  }

  // Simpre poner la interfaz mas generica
  public Iterable<SharedFile> getAllFiles() {
    // Para clonar un array list:
    return new ArrayList<>(files);
  }

  public SharedFile getLastFile() {
    return files.getLast();
  }

  public SharedFile getFirstFile(Predicate<? super SharedFile> requirement) {
    for (SharedFile file : files) {
      if (requirement.test(file))
        return file;
    }
    throw new NoSushElementException();
  }

  public static class SharedFile {

    private final String fileName, assignmentName;

    public SharedFile(String file, String assignment) {
      fileName = file;
      assignmentName = assignment;
    }

    @Override
    public String toString() {
      return "File %s in work area %s".formatted(fileName, assignmentName);
    }

    public String getFileName() {
        return fileName;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    @Override
    public int hashCode() {
      return Objects.hash(fileName, assignmentName);
    };

    @Override
    public boolean equals(Object obj) {
      return this
    };

  };

}
