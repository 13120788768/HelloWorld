package com.dell.emc.basic.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;

/**
 * 文件内容操作 InputStreamReader & OutputStreamWriter
 * 不管是磁盘还是网络传输，最小的存储单元都是字节，而不是字符。
 *  但是在程序中操作的通常是字符形式的数据，因此需要提供对字符进行操作的方法。涉及两个类:
 *
 * InputStreamReader 实现从字节流解码成字符流；
 * OutputStreamWriter 实现字符流编码成为字节流。
 */
public class InputStreamReaderOutputStreamWriterExample {

    public static void main(String[] args) throws Exception {
        // read file
        FileReader fileReader = new FileReader(IOConstant.TARGET_TOBE_COPIED);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String currentLine = null;
        // read per line
        while ((currentLine = bufferedReader.readLine()) != null) {
            System.out.println(currentLine);
        }

        // write file with a new output stream
        FileOutputStream output = new FileOutputStream(IOConstant.WRITE_WITH_NEW);
        // create a writer stream to write target file
        OutputStreamWriter writer = new OutputStreamWriter(output);

        // the new data to be written
        String data = "这是我追加的数据！！！啊啊啊啊啊啊啊";

        // append the data to the end of the existing contents
        writer.append("\n" + data);

        // flush the changed data to local target mandatory
        writer.flush();
        writer.append("\n" + data);

        // write with covering old contents
        //writer.write(data);


        writer.close();
        output.close();

        fileReader.close();
        bufferedReader.close();
    }
}
