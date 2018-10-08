package javaImp.Util;

import javaImp.Array.Array;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class FileOperation {

    /**
     * 文件读取操作，将filename文件中的文件内容读入words中
     * @param filename
     * @param words
     * @return
     */
    public static boolean readFile(String filename, Array<String> words) {
        if (filename == null || words == null) {
            System.out.println("Illegal arguments");
            return false;
        }
        
        // 文件的读取
        Scanner scanner = null;
        
        try {
            File file = new File(filename);
            if(file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                scanner = new Scanner(new BufferedInputStream(fis), "UTF-8");
                scanner.useLocale(Locale.ENGLISH);
            } else {
                System.out.println("file is not exists");
                return false;
            }
        } catch(IOException e) {
            System.out.println("Cannot open" + filename);
            return false;
        }
        
        // 简单分词操作
        if(scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();
            
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); ) {
                if(i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.append(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else {
                    i ++;
                }
            }
        }
        return true;
    }

    /**
     * 寻找字符串s中， 从start的位置开始的第一个字母字符的位置
     * @param s
     * @param start
     * @return
     */
    private static int firstCharacterIndex(String s, int start) {
        for(int i = start; i < s.length(); i++) {
            if(Character.isLetter(s.charAt(i))) {
                return i;
            }
        }
        return s.length();
    }
}
