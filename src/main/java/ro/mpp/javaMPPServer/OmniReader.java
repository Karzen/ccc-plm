package ro.mpp.javaMPPServer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OmniReader {

    private String filePath;

    // Constructor with filename as a parameter
    public OmniReader(String filePath) {
        this.filePath = filePath;
    }

    public int[][] readUnspecifiedMatrixFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // First pass to determine the dimensions N (rows) and M (columns)
            int rows = 0;
            int cols = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                rows++;
                if (cols == 0) {
                    // Split the first line to count columns
                    cols = line.trim().split("\\s+").length;
                }
            }

            // Initialize matrix with determined size
            int[][] matrix = new int[rows][cols];

            // Reset the reader to read values into the matrix
            try (BufferedReader readerAgain = new BufferedReader(new FileReader(filePath))) {
                int i = 0;
                while ((line = readerAgain.readLine()) != null) {
                    String[] values = line.trim().split("\\s+");
                    for (int j = 0; j < values.length; j++) {
                        matrix[i][j] = Integer.parseInt(values[j]);
                    }
                    i++;
                }
            }

            return matrix;
        }
    }

    public int[][] readMatrixFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read the first line for N and M
            String[] dimensions = reader.readLine().trim().split("\\s+");
            int rows = Integer.parseInt(dimensions[0]);
            int cols = Integer.parseInt(dimensions[1]);

            // Initialize the matrix with given dimensions
            int[][] matrix = new int[rows][cols];

            // Read the matrix data
            for (int i = 0; i < rows; i++) {
                String[] values = reader.readLine().trim().split("\\s+");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }

            return matrix;
        }
    }

    public String[] readStringsFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Read the first line for N
            int n = Integer.parseInt(reader.readLine().trim());
            String[] strings = new String[n];

            // Read the strings
            for (int i = 0; i < n; i++) {
                strings[i] = reader.readLine().trim();
            }

            return strings;
        }
    }

    public String[] readUnspecifiedStringsFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // First pass to determine the number of strings
            int n = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                n++;
            }

            // Initialize the array with the determined size
            String[] strings = new String[n];

            // Reset the reader to read the strings
            try (BufferedReader readerAgain = new BufferedReader(new FileReader(filePath))) {
                int i = 0;
                while ((line = readerAgain.readLine()) != null) {
                    strings[i] = line.trim();
                    i++;
                }
            }

            return strings;
        }
    }

    public String readString() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int readInt() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

}
