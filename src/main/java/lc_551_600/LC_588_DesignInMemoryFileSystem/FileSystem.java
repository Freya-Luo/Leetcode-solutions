package lc_551_600.LC_588_DesignInMemoryFileSystem;

import java.util.*;

class FileSystem {
    // Trie
    class INode {
        String content = "";
        boolean isfile;
        Map<String, INode> children = new HashMap<>();
    }

    private INode root;

    public FileSystem() {
        this.root = new INode();
    }

    // O(m+n+klog(k))
    public List<String> ls(String path) {
        INode r = root;
        List<String> files = new ArrayList<>();

        String[] levels = path.split("/"); // O(m)
        for(int i = 1; i < levels.length; i++) { // O(n)
            r = r.children.get(levels[i]);
        }
        if (r.isfile) {
            files.add(levels[levels.length - 1]);
            return files;
        } else {
            System.out.print(r.children.keySet() + " ");
            files.addAll(r.children.keySet());
            Collections.sort(files); // O(klogk)
            return files;
        }
    }

    // O(m+n)
    public void mkdir(String path) {
        INode r = root;
        String[] levels = path.split("/"); // O(m)
        for(int i = 1; i < levels.length; i++) { // O(n)
            if (!r.children.containsKey(levels[i])) {
                r.children.put(levels[i], new INode());
            }
            r = r.children.get(levels[i]);
        }
    }

    // O(m+n)
    public void addContentToFile(String filePath, String content) {
        INode r = root;
        String[] levels = filePath.split("/");
        for(int i = 1; i < levels.length - 1; i++) {
            r = r.children.get(levels[i]);
        }

        String filename = levels[levels.length - 1];
        if (!r.children.containsKey(filename)) {
            r.children.put(filename, new INode());
        }
        r = r.children.get(filename);
        r.content += content;
        r.isfile = true;
    }

    // O(m+n)
    public String readContentFromFile(String filePath) {
        INode r = root;
        String[] levels = filePath.split("/");
        for(int i = 1; i < levels.length; i++) {
            r = r.children.get(levels[i]);
        }
        return r.content;
    }
}