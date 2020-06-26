import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class FileAndDirectory {

	public static void main(String[] args) throws IOException {
		
		Path Currentpath = Paths.get(".");
		
//		Files.list(Paths.get(".")).forEach(System.out::println);
		
		Predicate<? super Path> predicate= path -> String.valueOf(path).contains("FileAndDirectory.java");
//		Files.walk(Currentpath,3)
//					.filter(predicate)
//					.forEach(System.out::println);
		
		BiPredicate<Path, BasicFileAttributes> javaMatcher = (path, attribue) -> String.valueOf(path).contains("FileAndDirectory.java");
		Files.find(Currentpath, 3, javaMatcher )
					.forEach(System.out::println);;
	}

}
