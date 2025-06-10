import java.util.Scanner;

public class Strings {

    private static String compress (String s) {
        StringBuilder ans = new StringBuilder();
        char prev = s.charAt(0);
        int cnt = 1;
        for (int ind = 1; ind < s.length(); ind++) {
            char current = s.charAt(ind);
            if (current != prev) {
                if (cnt > 1) {
                    ans.append(cnt);
                }
                ans.append(prev);
                cnt = 1;
                prev = current;
            } else {
                cnt++;
            }
            if (ind == s.length() - 1) {
                if (cnt > 1) {
                    ans.append(cnt);
                }
                ans.append(prev);
            }
        }
        return ans.toString();
    }

    private static boolean isPalindrome (int leftStart, int rightStart, int size, String s) {
        int i = leftStart, j = rightStart;
        int len = size;
        while (len-- > 0) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
            len--;
        }
        return true;
    }

    private static String sentencePalindrome(String sentence) {
        int left = 0, right = sentence.length() - 1;
        while (left < right) {
            int leftStart = left;
            while (left < right && sentence.charAt(left) != ' ') {
                left++;
            }
            int rightEnd = right;
            int leftLen = left - leftStart;
            right -= leftLen;
            int rightLen = rightEnd - right;
            if (leftLen != rightLen) {
                return "Not a Palindrome";
            } else {
                if (!isPalindrome(leftStart, rightEnd, leftLen, sentence)) {
                    return "Not a Palindrome";
                }
            }
            left++;
        }
        return "Palindrome";
    }

    private static int findIndexOfReverseWord(String sentence, String target) {
        int ind = target.length() - 1;
        for (int ind1 = 0; ind1 < sentence.length(); ind1++) {
            if (sentence.charAt(ind1) == target.charAt(ind)) {
                if (ind == target.length() - 1 && sentence.charAt(ind1 - 1) != ' ') {
                    continue;
                }
                ind--;
            } else {
                ind = target.length() - 1;
            }
            if (ind < 0) {
                return ind1 - target.length() + 2;
            }
        }
        return -1;
    }

    private static void justify(String s, int space) {
        int gap = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                gap++;
            }
        }
        int needToFill = space - s.length();
        int neededGaps = (needToFill / gap) + (needToFill % gap);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ' && neededGaps > 0) {
                System.out.print(c + " ");
                neededGaps--;
            }
            System.out.print(c);
        }
    }

    private static boolean isVowel (char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static String longestConsantsSubstring (String s) {
        int n = s.length();
        int start = 0, prev = 0;
        int maxLen = 0;
        for (int ind = 0; ind < n; ind++) {
            char c = s.charAt(ind);
            if (isVowel(c)) {
                int windowSize = ind - (prev + 1);
                if (windowSize > maxLen) {
                    maxLen = windowSize;
                    start = prev + 1;
                    prev = ind;
                }
            }
        }
        return s.substring(start, Math.min(n, start + maxLen));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
    }

}
