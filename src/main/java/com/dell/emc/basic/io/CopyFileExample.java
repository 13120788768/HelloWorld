package com.dell.emc.basic.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 创建的文件都是空白的，现在需要我们往文件里写一些文字怎么操作呢？这就需要用到我们之前讲的 「IO」 操作流了~
 *
 * 复制一个, 主要过程分为以下过程:
 *
 * 定义输入的文件路径和输出的文件路径（由路径+文件名含文件格式后缀组成）
 * 定义 「文件输入流(FileInputStream)」 和 「文件输出流(FileOutputStream)」
 * 读取文件内容，写入目标文件
 * 关闭流通道
 */
public class CopyFileExample {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(IOConstant.RESOURCE_TOBE_COPIED);
        FileOutputStream fileOutputStream = new FileOutputStream(IOConstant.TARGET_TOBE_COPIED);

        // buffer to read the inputs each time with size 1024 bytes
        byte[] buffer = new byte[1024];

        int currentLength = 0;
        // read the RESOURCE_TOBE_COPIED file that saved at buffer per batch
        while((currentLength = fileInputStream.read(buffer, 0, buffer.length)) != -1) {
            // write to FILE_PATH_TEST
            System.out.println("buffer="+buffer);
            fileOutputStream.write(buffer, 0, currentLength);
        }

        // close stream
        fileInputStream.close();
        fileOutputStream.close();
    }
}
