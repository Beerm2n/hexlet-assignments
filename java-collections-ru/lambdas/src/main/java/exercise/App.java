package exercise;

import java.util.Arrays;

public class App {

    public static String[][] enlargeArrayImage(String[][] image) {
    /*   int rows = image.length;
       int cols = image[0].length;
       String[][] newImage = new String[rows*2][cols*2];
       for (int i = 0; i<rows; i++) {
           for (int j = 0; j<cols; j++) {
               String pixel = image[i][j];
               newImage[i*2][j*2] = pixel;
               newImage[i*2+1][j*2] = pixel;
               newImage[i*2][j*2+1] = pixel;
               newImage[i*2+1][j*2+1] = pixel;
           }
       }
       return newImage; */
        return Arrays.stream(image)
                .map(row -> Arrays.stream(row)
                        .flatMap(cell -> Arrays.stream(new String[] {cell, cell}))
                        .toArray(String[]::new))
                .flatMap(row -> Arrays.stream(new String[][] {row, row}))
                .toArray(String[][]::new);
    }

}
