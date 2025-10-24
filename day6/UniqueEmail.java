import java.util.*;

class UniqueEmail {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String e : emails) {
            int at = e.indexOf('@');
            String local = e.substring(0, at).split("\\+")[0].replace(".", "");
            set.add(local + e.substring(at));
        }
        return set.size();
    }
    public static void main(String[] args){
        // Test the numUniqueEmails method
        UniqueEmail obj = new UniqueEmail();

        String[] emails = {
            "test.email+alex@leetcode.com",
            "test.e.mail+bob.cathy@leetcode.com",
            "testemail+david@lee.tcode.com"
        };

        int result = obj.numUniqueEmails(emails);
        System.out.println("Number of unique emails: " + result);
    }
}
