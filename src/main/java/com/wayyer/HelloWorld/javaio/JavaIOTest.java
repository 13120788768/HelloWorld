package com.jnj.pangea.wcao.test.javaio;

import akka.remote.transport.netty.NettyTransportExceptionNoStack;
import com.jnj.pangea.wcao.test.lambda.Person;

import java.io.*;
import java.util.Date;

/**
 * @Author: wayyer
 * @Description: this is used for the basic experence of java io
 * @Program: local_test
 * @Date: 2018.07.04
 */
public class JavaIOTest {

    int  a = 2;
    static int b = 2;
    static byte[] byteArray = null;
    static char[] charArray = null;
    static String basics = "/Users/wcao12/Desktop/javaio/basic";
    static String basicDir = "/Users/wcao12/Desktop/javaio";
    public static void main(String[] ag) throws Exception {


        Date date = new Date(1931291546996L);
        long curr =  System.currentTimeMillis();
        System.out.println(date + ", curr " + curr);


        //use the input / output stream
        //read by byte FileInputStream
        byteFileInputStream();


        //write by byte FileOutputStream
        byteFileOutputStream();

        //copyFile  by file input/output Stream
        copyFile();


        //use the writer / reader
        //writerFile();


        //convertByteToChar
        //convertByteToCharStream();

        //fileOperation
        //fileOperation();

        //randomFileAccess
        //randomAccessFile();

    }




    /**
     * read a file by the byte array with file input stream
     * @throws Exception
     */
    private static void byteFileInputStream() throws Exception{
        File file= new File( basics);
        byteArray= new byte[( int) file.length()];
        InputStream fis = new FileInputStream(file);
        int size = fis.read(byteArray);
        System.out.println( "file size = "+ size +", \nfile contents = " + new String(byteArray));
        fis.close();

        fis = new ByteArrayInputStream(byteArray);


    }

    /**
     * write a new file by the byte array with file output stream
     * @throws Exception
     */
    private static void byteFileOutputStream() throws Exception{

        if(byteArray == null){
            return;
        }

        OutputStream fos= new FileOutputStream(
                basicDir + "/fos-copy-byteFileOutputStream-" + System.currentTimeMillis());
        fos.write(byteArray);
        fos.close();

    }

    /**
     * copy a file with reading with input stream and writing with output stream
     * @throws Exception
     */
    private static void copyFile() throws Exception{

        InputStream fis= new FileInputStream(basics);
        OutputStream fos= new FileOutputStream(
                basicDir + "/fos-copy-copyFile-" + System.currentTimeMillis());
        byte[] buffer=new byte[1024];
        int size=0;
        while((size=fis.read(buffer))!=-1){
            fos.write(buffer, 0, size);
        }
        fis.close();
        fos.close();
    }

    /**
     * reader
     * @throws Exception
     */
    private static void readerFile() throws Exception{

        File file = new File( basics);
        charArray = new char[( int) file.length()];
        Reader reader= new FileReader( file);
        int size= reader.read( charArray);
        System. out.println( "file size = "+ size +", \nfile contents = " + new String(byteArray));
        reader.close();
    }

    /**
     * writer
     * @throws Exception
     */
    private static void writerFile() throws Exception{
        Writer fw= new FileWriter(basicDir + "/writer-" + System.currentTimeMillis());
        fw.write( byteArray.toString());
        fw.close();

    }



    /**
     * convert the byte stream to char stream
     * @throws IOException
     */
    private static void convertByteToCharStream() throws IOException{
        File file= new File( basics);
        InputStream fis= new FileInputStream(file);
        Reader reader= new InputStreamReader( fis);
        char [] charArray= new char[( int) file.length()];
        int size= reader.read( charArray);
        System. out.println( "file size = "+ size +", \nfile contents = " + new String(byteArray));
        fis.close();
        reader.close();

    }


    private static void fileOperation() {
        //file
        File file = new File( basics);
        boolean fileExists = file.exists();
        System.out.println(fileExists);

        //file mkdir method is used for create new dirs only when current dir exists
        File file2 = new File( basicDir + "/dir");
        boolean dirCreated = file2.mkdir();
        System. out.println( dirCreated);

        //file mkdirs method is used for create new dirs either current dir exists or not
        File file3 = new File( basicDir + "/dir1/dir2");
        boolean dirCreated2 = file3.mkdirs();
        System. out.println( dirCreated2);


        File file4= new File( basics);
        //file size
        long length = file4.length();
        //rename
        //boolean isRenamed = file4.renameTo( new File(basics + "-rename"));
        //retrive back
        //file4.renameTo( new File(basics));
        //delete
        boolean isDeleted = file4.delete();

        File file5= new File( basicDir);
        boolean isDirectory = file5.isDirectory();
        //list files
        String[] fileNames = file5.list();
        //list directories
        File[]   files = file4.listFiles();

    }

    private static void randomAccessFile() throws  Exception{

        RandomAccessFile raf = new RandomAccessFile(basicDir+"/randomAccessFile.txt", "rw");
        Person caowei = new Person("Cao", "Wei", 26);
        caowei.write(raf);



    }
}
