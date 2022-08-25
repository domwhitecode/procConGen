import java.io.File;
import java.io.FileWriter;
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

    public static void writeToMapFile(){
        try
        {
            FileWriter myWriter = new FileWriter("games/dw895game/map3.tmx");
            myWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            myWriter.write("\t<map version=\"1.0\" orientation=\"orthogonal\" width=\"10\" height=\"10\" tilewidth=\"64\" tileheight=\"64\">\n");
            myWriter.write("\t\t<properties>\n");
            myWriter.write("\t\t\t<property name=\"name\" value=\"Blackrock\"/>\n");
            myWriter.write("\t\t</properties>\n");
            myWriter.write("\t\t<tileset firstgid=\"1\" name=\"graphics\" tilewidth=\"64\" tileheight=\"64\">\n");
            myWriter.write("\t\t\t<image source=\"graphics2x-basic.png\" width=\"640\" height=\"1344\"/>\n");
            myWriter.write("\t\t</tileset>\n");
            myWriter.write("\t\t<tileset firstgid=\"211\" name=\"walls\" tilewidth=\"64\" tileheight=\"64\">\n");
            myWriter.write("\t\t\t<image source=\"graphics2x-walls.png\" width=\"128\" height=\"1024\"/>\n");
            myWriter.write("\t\t</tileset>\n");







            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        }
        catch (IOException e)
        {
            System.out.println("write error");
            e.printStackTrace();
        }

    }

    public static void main(String args[]){
        System.out.println("hey");

        CreateNewMap();
        writeToMapFile();
    }
}

