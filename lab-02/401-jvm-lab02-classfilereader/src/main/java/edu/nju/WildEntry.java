package edu.nju;

import java.io.*;

/**
 * format : dir/.../*
 */
public class WildEntry extends Entry{
    public WildEntry(String classpath) {
        super(classpath);
    }

    @Override
    public byte[] readClassFile(String className) throws IOException {
        classpath = IOUtil.transform(classpath).substring(0,classpath.length()-1);
        //System.out.println(classpath);
        File path = new File(classpath);
        File[] fileList = path.listFiles();
        if(fileList == null){
            System.out.println("null!");
            return null;
        }
        for (File item:fileList
        ) {
            String fullPath = classpath+item.getName();
            ArchivedEntry archivedReader = new ArchivedEntry(fullPath);
            //System.out.println(fullPath);
            byte[] result = null;
            try{result = archivedReader.readClassFile(className);}
            catch (FileNotFoundException e){
                //e.printStackTrace();
                return null;
            }
            if(result != null){
                //System.out.println("success");
                return result;
            }
        }
        System.out.println("fail");
        return null;
    }
}
