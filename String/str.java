public class str {
    public static void main(String[] args) {
        String s = "hello";
        String s1 = new String("hello");
        String s2 = "hello";
        String s3 = new String("hello");
        System.out.println(s.charAt(3));
        System.out.println(s == s1);
        System.out.println(s == s2);
        System.out.println(s == s3);
        System.out.println(s.equals(s1));
        System.out.println(s.equals(s2));
        System.out.println(s.equals(s3));

    }

}