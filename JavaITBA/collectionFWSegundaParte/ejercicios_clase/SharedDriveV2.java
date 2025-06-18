import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.Predicate;

import SharedDrive.SharedFile;

public class SharedDriveV2 {

  private Set<SharedFile> files = new HashSet<>();

  public SharedDriveV2 addFile(String fileName, String assignmentName) {
    files.add(new SharedFile(fileName, assignmentName));
    return this;
  }

  public boolean fileExists(String fileName, String assignmentName) {
    return files.contains(new SharedFile(fileName, assignmentName));
  }

  public int filesCount(Predicate<SharedFile> requirementToCount) {
  }

  private SharedFile buildFile(String fileName, String assignmentName) {
    return new SharedFile(fileName, assignmentName);
  }

  public void renameFile(String oldName, String assignmentName, String newName) {
    if (files.remove(buildFile(oldName, assignmentName))) {
      files.add(buildFile(newName, assignmentName));
      return;
    }
    throw new NoSuchElementException();
  }

}
