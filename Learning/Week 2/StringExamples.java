public class StringExamples
{
    public static void main(String[] args)
    {
        String firstName = "Clarissa";
        String lastName = "Milligan";

        int index = firstName.indexOf('a');
        System.out.println(index);
        index = firstName.lastIndexOf('a');
        System.out.println(index);

        char letter = lastName.charAt(3);
        System.out.println(letter);

        int len = firstName.length();
        System.out.println(len);

        String newWord = lastName.replace('l', 't');
        System.out.println(newWord);

        newWord = firstName.toUpperCase();
        System.out.println(newWord);
    }
}
