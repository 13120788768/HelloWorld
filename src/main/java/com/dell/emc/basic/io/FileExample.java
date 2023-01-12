package com.dell.emc.basic.io;

import java.io.File;

/**
 * 「File」 即文件操作，
 * 在我们平时操作文件的时候，有文件夹和文件操作，
 *  基本的创建、修改、删除等操作，
 *  在Java中是 「File」 类去做的一些相关操作,所以我们需要先实例化它。
 *
 */
public class FileExample {
    public static void main(String[] args) throws Exception{
        // pure File
        // ./is the root project path
        File file = new File("./target/filetest.txt");
        // exists.
        if (file.exists()) {
            System.out.println("Already exist!");
        } else {
            try {
                // createNewFile
                if (file.createNewFile()) {
                    System.out.println("Create a file named file.test.txt!");
                }
            } catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }
        // delete this file
        //file.delete();
        //System.out.println("Delete a file named filetest.txt!");

        // renameTo
        file.renameTo(new File("./target/renamedFile.txt"));
        System.out.println("Renamed a file named renamedFile.txt!");

        // isFile
        boolean isFile = file.isFile();
        System.out.println("File named renamedFile.txt! is file? = " + isFile);

        // Directory
        File dir = new File("./target/io");
        if (!dir.exists()) {
            dir.mkdir();
            System.out.println("Create a new folder named ./target/io!");


        } else {
            System.out.println("Folder io already exists!");
        }
        // isDirectory
        boolean isDir = dir.isDirectory();
        System.out.println("Folder named ./target/io! is file? = " + isDir);

        // multi dirs
        File dirs = new File("./target/io/l1/l2/l3");
        if (!dirs.exists()) {
            dirs.mkdirs();
            System.out.println("Create muitl dirs ./target/l1/l2/l3.");
        } else {
            System.out.println("Folders ./target/l1/l2/l3 already exists!");
        }
    }





}
