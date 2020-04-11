class ReverseArray {

  private static void reverse(int start, int end, char[] message) {
    while (start < end) {
        char temp = message[start];
        message[start] = message[end];
        message[end] = temp;
        start++;
        end--;
    }
  }
  
  private static void reverseWords(char[] message) {
    if (message.length <= 1) return;
   
    // Reverse the whole array in one pass.  
    reverse(0, message.length - 1, message);

    // Reverse each word in the array.
      // Two pointers: keep track of the start and end of a word - a word ends with a '' or end of the array
        // Reverse the word

    int start = 0;

    // i will represent the end of the word.
    for (int i = 0; i <= message.length; i++) {
      	if (i == message.length || message[i] == ' ') {
			    reverse(start, i - 1, message);
		    	start = i + 1;
        }
    }
  }

  public static void main(String[] args) {
    char[] expected1 = "vault".toCharArray();
    reverseWords(expected1);
    System.out.println(expected1);

    char[] expected2 = "cake thief".toCharArray();
    reverseWords(expected2);
    System.out.println(expected2);

    char[] expected3 = "get another one".toCharArray();
    reverseWords(expected3);
    System.out.println(expected3);
  }

}