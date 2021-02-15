import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        File classPath = new File(Constants.WEB_ROOT);
        System.out.println(classPath.getCanonicalPath());
    }
}
