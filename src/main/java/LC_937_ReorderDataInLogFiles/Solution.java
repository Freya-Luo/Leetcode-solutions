package LC_937_ReorderDataInLogFiles;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Time: O(M * NlogN), where M is the max len of the log
 */
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        Comparator<String> comp = new Comparator<>() {
            
            @Override
            public int compare(String s1, String s2) {
                String[] partsOfS1 = s1.split(" ", 2);
                String[] partsOfS2 = s2.split(" ", 2);
                
                String idOfS1 = partsOfS1[0], idOfS2 = partsOfS2[0];
                String contentOfS1 = partsOfS1[1], contentOfS2 = partsOfS2[1];
                
                if (Character.isLetter(contentOfS1.charAt(0)) 
                        && Character.isLetter(contentOfS2.charAt(0))) {
                    
                    int res = contentOfS1.compareTo(contentOfS2);
                    return res == 0 ? idOfS1.compareTo(idOfS2) : res;
                }
                
                if (Character.isDigit(contentOfS1.charAt(0)) 
                        && Character.isDigit(contentOfS2.charAt(0))) {
                    return 0;
                }
                
                return Character.isDigit(contentOfS1.charAt(0)) ? 1 : -1;
            }
        };
        
        Arrays.sort(logs, comp);
        return logs;
    }
}