package games.dw895game;

import games.dw895game.Vertex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateNewMap {

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
        generateMapString gms = new generateMapString(5);
        try
        {
            FileWriter myWriter = new FileWriter("games/dw895game/map3.tmx");
            myWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            myWriter.write("\t<map version=\"1.0\" orientation=\"orthogonal\" width=\"9\" height=\"9\" tilewidth=\"64\" tileheight=\"64\">\n");
            myWriter.write("\t\t<properties>\n");
            myWriter.write("\t\t\t<property name=\"name\" value=\"Blackrock\"/>\n");
            myWriter.write("\t\t</properties>\n");
            myWriter.write("\t\t<tileset firstgid=\"1\" name=\"graphics\" tilewidth=\"64\" tileheight=\"64\">\n");
            myWriter.write("\t\t\t<image source=\"graphics2x-basic.png\" width=\"640\" height=\"1344\"/>\n");
            myWriter.write("\t\t</tileset>\n");
            myWriter.write("\t\t<tileset firstgid=\"211\" name=\"walls\" tilewidth=\"64\" tileheight=\"64\">\n");
            myWriter.write("\t\t\t<image source=\"graphics2x-walls.png\" width=\"128\" height=\"1024\"/>\n");
            myWriter.write("\t\t</tileset>\n");
            myWriter.write("\t\t <layer name=\"Tile Layer 1\" width=\"9\" height=\"9\">\n");
            myWriter.write("\t\t\t<data>\n");
            myWriter.write(gms.buildMapString());
            myWriter.write("\t\t\t</data>\n");
            myWriter.write("\t\t</layer>\n");
            myWriter.write("\t</map>\n");

            // Write gid's via a function (Kruskals?")



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
        CreateNewMap();
        writeToMapFile();
        Vertex myV = new Vertex(3);
    }
}

