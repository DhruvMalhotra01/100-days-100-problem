class String {
    public int lengthOfLastWord(String st) {
        String[] words = st.trim().split("\\s+");
        Stack<String> s = new Stack<>();
        int i = words.length-1;
        s.push(words[i]);
        String a = s.pop();
        return a.length();
    }
    public static void main(String[] args) {
        String str = new String();
        String test = "hello world ";
        System.out.println(lengthOfLastWord(test));
    }
}
