package CUM;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CUMM_Shot
{
    public static File pic1 = new File("E:\\desktop\\drawing content\\");
    public static void main(String[] args)
    {
        List <String> files = new ArrayList<>();
        List <String> dirs = new ArrayList<>();
        List <String> files_path = new ArrayList<>();
        String path1 = pic1.getAbsolutePath();
        int count = readFiles(pic1,dirs,files,true);

        repeat(pic1, dirs,files_path,files);
        yourFilesShallBeMINE(dirs, files_path, files);

        System.out.println(files);
        System.out.println(count);
        System.out.println(dirs);
        System.out.println(files_path);

    }

    public static void repeat(File baseDirectory, List dirs, List files_path, List files)
    {
        String temp1 = baseDirectory.getAbsolutePath() + "en";
        String temp2 = baseDirectory.getAbsolutePath() + "ru";
        File porn2 = new File(temp1);
        File porn3 = new File(temp2);
        int temp_ru = readFiles(porn2, dirs,files,false);
        int temp_en = readFiles(porn3, dirs,files,false);
        System.out.println(temp_ru);
        System.out.println(temp_en);
    }



    public static int readFiles(File baseDirectory, List dirs,List files, boolean what){
        int counter = 0;
        if (baseDirectory.isDirectory()){
            for (File file : baseDirectory.listFiles())
            {
                if(file.isFile())
                {
                    files.add(file.getName());
                }
                else
                    {
                        if (what)
                        {
                            dirs.add(file.getName());
                        }
                    counter++;
                    readFiles(file,dirs,files, what);
                    }
                }
            }
        return counter;
        }

    public static void readFiles1(File baseDirectory, List files_path){
        if (baseDirectory.isDirectory()){
            for (File file : baseDirectory.listFiles())
            {
                if(file.isFile())
                {
                    files_path.add(file.getAbsolutePath());
                }
            }
        }
    }


        public static void yourFilesShallBeMINE(List dirs, List files_path, List files)
        {
            String temp = pic1.getAbsolutePath();
            for (int i = 0;i<3;i++)
            {
                temp += "\\" + dirs.get(0);
                dirs.remove(0);
                File porn1 = new File(temp);
                //System.out.println(temp);
               // System.out.println(dirs);
                readFiles1(porn1, files_path);
                //System.out.println(files_path);
            }
        }
    }


