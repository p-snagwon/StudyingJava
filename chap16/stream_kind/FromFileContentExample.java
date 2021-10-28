package chap16.stream_kind;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FromFileContentExample {

    public static void main(String[] args) throws IOException {

        //현재 클래스객체를 기준으로 파일의 상대경로를 넣어주면 된다.
        Path path = Paths.get("src/chap16/stream_kind/linedata.txt");
        Stream<String> stream;

        //1. Files.lines를 이용하는 방법
        stream = Files.lines(path, Charset.defaultCharset());
        stream.forEach(System.out::println);
        stream.close();
        System.out.println();


        //2. BufferedReader의 lines를 이용하는 방법
        File file = path.toFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        stream = bufferedReader.lines();
        stream.forEach(System.out::println);
        stream.close();
        System.out.println();
    }
}
