import java.util.Arrays;

import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

class MergeArrays {
  
  public static int[] mergeArrays(int[] array1, int[] array2) {
    int[] result = new int[array1.length + array2.length];
    int index1 = 0;
    int index2 = 0;
    int indexResult = 0;

    while (index1 < array1.length && index2 < array2.length) {
      if (array1[index1] < array2[index2]) {
        result[indexResult] = array1[index1];
        index1++;
      } else {
        result[indexResult] = array2[index2];
        index2++;
      }
      indexResult++;
    }

    if (index1 < array1.length) {
      fillArray(array1, result, index1, indexResult);
    } else {
      fillArray(array2, result, index2, indexResult);
    }

    return result;
  }

  private static void fillArray(int[] origin, int[] destination, int originIndex, int destinationIndex) {
    for (int i = originIndex; i < origin.length; i++) {
      destination[destinationIndex] = origin[i];
      destinationIndex++;
    }
  }

  public static void main(String[] args) {
    int[] array1 = new int[]{};
    int[] array2 = new int[] { 4, 5, 7, 8, 9};

    System.out.println(Arrays.toString(mergeArrays(array1, array2)));
  }
}