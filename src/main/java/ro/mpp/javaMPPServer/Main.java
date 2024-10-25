package ro.mpp.javaMPPServer;

import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        var reader = new OmniReader("C:\\Users\\Stefy\\Desktop\\CCC\\src\\main\\java\\ro\\mpp\\javaMPPServer\\data\\classic_str_mat.in");

        var strings = reader.readStringsFromFile();

        return;
    }
}