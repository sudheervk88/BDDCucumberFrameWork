package utilsPackage;

public class    ResourceUtils {

    public static String getResourcePath(String resourceName){

        String path = getBaseName() + resourceName;
        return path;

    }

    public static String getBaseName(){

        String path = ResourceUtils.class.getClassLoader().getResource(".").getPath();
        return  path;
    }

}
