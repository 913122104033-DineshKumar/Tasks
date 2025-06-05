public class Strings {
    private static int findIndexOfReverseWord (String sentence, String target) {
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
}
