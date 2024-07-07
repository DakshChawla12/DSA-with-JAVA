

public class PrintCharsInSortedWay {

    public static void printInSorted(String str) {
        int[] arr = new int[26];
        int[] capArr = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int asciiValue = str.charAt(i);
            if (asciiValue >= 65 && asciiValue <= 90) {
                capArr[str.charAt(i) - 'A']++;
            } else {
                arr[str.charAt(i) - 'a']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            int count = 0;
            if (capArr[i] > 0) {
                while (count < capArr[i]) {
                    System.out.print((char) (i + 'A'));
                    count++;
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            int count = 0;
            if (arr[i] > 0) {
                while (count < arr[i]) {
                    System.out.print((char) (i + 'a'));
                    count++;
                }
            }
        }
    }


}