import java.io.File;
import java.io.IOException;

public class CreateNewMap {
    //1. first create a function that can build a simple map (not necessarily generated)
    //      -> create a file map.tmx
    //      -> write to file 
    //2. the utilize kruskals algorithm to generate new maps

    //PART 1

    public static void CreateNewMap()
    {
        try
        {
            File newMapFile = new File("games/dw895game/map3.tmx");
            if(newMapFile.createNewFile())
            {
                System.out.println("File created: " + newMapFile.getName());
            }

            else
            {
                System.out.println("File already exists");
            }
        }
        catch(IOException e)
        {
            System.out.println("error");
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        System.out.println("hey");

        CreateNewMap();
    }
}

