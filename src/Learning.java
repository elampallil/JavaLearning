
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Learning {
    public static void main(String[] args) {
        startWith();
        //removeBlankSPaces("hello binson thomas elampallil");
        //flatMap();
        /*findCharOccurance('a',"aabbca");
        Scanner sc = new Scanner(System.in);
        System.out.print("enetr a string ");
        String str = sc.nextLine();
        //reverseString('a',str);
        reverseString(str);*/
        //stringConcatAndRemoveRepeatChar(str);

    }
    public static int points(String[] games) {
        return Arrays.stream(games)
                .mapToInt(item -> item.charAt(0) > item.charAt(2) ? 3 : item.charAt(0) == item.charAt(2) ? 1 : 0)
                .sum();
    }

    public static int calculate(String item){
        int point = 0;
        if(item.charAt(0) == item.charAt(2)){
            point = point +1 ;
        } else if (item.charAt(0) > item.charAt(2)) {
            point =point + 3 ;
        }else {
            point = point + 0 ;
        }
        return  point;
    }

    public static String whoLikesIt(String... names) {

        //Do your magic here
        return "";
    }

    public static boolean isSameAfterShift(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        for (int i = 0; i < str1.length(); i++) {
            String shiftedRight = shiftRight(str1, i);
            String shiftedLeft = shiftLeft(str1, i);

            if (shiftedRight.equals(str2) || shiftedLeft.equals(str2)) {
                return true;
            }
        }

        return false;
    }

    public static String shiftRight(String str, int positions) {
        positions = positions % str.length(); // ensure positions is within the length of the string
        String shifted = str.substring(str.length() - positions) + str.substring(0, str.length() - positions);
        return shifted;
    }

    public static String shiftLeft(String str, int positions) {
        positions = positions % str.length(); // ensure positions is within the length of the string
        String shifted = str.substring(positions) + str.substring(0, positions);
        return shifted;
    }






    //Idealoo question logic how can (IMP)

/*    Map<String, List<Double>> finalResult =
            offers.stream()
                    .collect(Collectors.groupingBy(item -> item.getProduct_name(),
                            Collectors.mapping(item ->item.getPrice(), Collectors.toList())));*/

    public static void groupingBySample(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> groupedNumbers = numbers.stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0)); // groupingBy(key, value)

        List<Integer> evenNumbers = groupedNumbers.get(true);   // VVVimp
        List<Integer> oddNumbers = groupedNumbers.get(false);

        System.out.println("Even numbers: " + evenNumbers);
        System.out.println("Odd numbers: " + oddNumbers);
    }


    //Write a program that takes a list of Strings and returns a Map containing each unique String as a key and the number
    // of times that String appears in the list as a value using the groupingBy() function in Java Streams.

    public static void mapKeyVale(){
        //??
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "pear", "banana");
        Map<String, Long> map =  strings.stream().collect(Collectors.groupingBy(s ->s,Collectors.counting())); //Imp
    }

    // sum of every string in a list

    public int sumOfEveryStringInAlist(List<String> list){
        int res = list.stream().mapToInt(s->s.length()).sum();
        return res;
    }

    public static void concatinateListOfString(){
        //Write a program that takes a list of Strings and returns the concatenation of all Strings in the list using the reduce() function in Java Streams.
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "pear", "banana");
        String result = strings.stream()
                .reduce("", (str1, str2) -> str1 + str2);
        System.out.print(result);
        /// concatinating unique strings in alist

        String res = strings.stream().distinct().reduce((a,b)-> a+b).toString();

    }
//Write a program that takes a list of Strings and returns the longest String in the list using the reduce() function in Java Streams.
    public static void longestString(){
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "pear", "banana");
       String res =  strings.stream().reduce("",(str1,str2) -> (str1.length() > str2.length() ? str1: str2));
        System.out.print(res);
    }

    //Write a program that takes a list of Strings and returns a Map containing each unique character in the list as a key
    // and the number of times that character appears in the list as a value using the flatMap() and groupingBy() functions in Java Streams.
    public static void flatMap(){
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "pear", "banana");
        String s = strings.stream().flatMap(word -> word.chars().mapToObj(c->c)).map(Objects::toString).collect(Collectors.joining());
        System.out.println(s);

        Map<Character, Long> res= strings.stream().flatMap(ch -> ch.chars().mapToObj(c ->(char) c)).collect(Collectors.groupingBy(c ->c, Collectors.counting()));
    }



    public static void maxLengthString(){
        List<String> strings = Arrays.asList("apple", "banana", "apple", "orange", "banana", "pear", "banana");

       // List<String> res = strings.stream().filter(s -> s.length() > 6).collect(Collectors.toList());

        //eliminating string which length lessthan 6 and concat all other strings
        List<String> res = strings.stream().filter(s -> s.length() < 6).map(s -> s+s).collect(Collectors.toList());


    }

    public static long findVowels(String str){

        long count = str.chars().
                filter(ch -> "aeiouAEIOU".indexOf(ch) != -1).count();
        System.out.println("total count is "+ count);

        //Inside the character class we have some more methods
        long isAllletter = str.chars().filter(ch -> Character.isLetter(ch)).count();

        System.out.println("total number of character "+ isAllletter);

        //long count = Stream.of(str).flatMapToInt(CharSequence :: chars).filter(s ->"aeiouAEIOU".indexOf(s) != -1).count();
        System.out.println("total count is "+ count);

        return count;
    }

    public static String reverseString(String str){


       /* String reversedString = Stream.of(str)
                .map(s -> new StringBuilder(s).reverse().toString())
                .findFirst()
                .orElse("");*/

        Optional<String> res = (str.chars().mapToObj(c -> (char) c).map(s-> new StringBuilder(s).reverse().toString()).findFirst());
        System.out.println("Original string: " + str);
        System.out.println("Reversed string: " + res.get());

        return res.get();
    }

    public static boolean isPalindrome(String str){
        boolean value = Boolean.parseBoolean(String.valueOf(Stream.of(str)
                .map(s -> new StringBuilder(s).reverse().toString())
                .findFirst()
                .orElse("")
                .matches(str)));
        if(value){
            System.out.print("yes");
        }else {
            System.out.print("No");
        }
        return true;
    }

    public static void removeBlankSPaces(String str){
        String str2 = str.replace(" ","");
        StringBuilder sb = new StringBuilder(str);
       // sb.reverse();
       /* String stringWithOutSpace = Stream.of(str)
                .map(s -> s.replace(" ",""))
                .findFirst()
                .orElse("");*/
        String stringWithOutSpace = str.chars().mapToObj(c-> (char) c).filter(ch -> ch != ' ').toString();
        System.out.print("string with out space is "+ str2);
        System.out.print("revserse "+ sb.reverse());
    }

    public static String reverseWords(final String original)
    {
        return Arrays.stream(original.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }


    public static void findNonRepeatingChar(String str){
        //???
        Optional<Character> result = str.chars() // get a stream of integer values representing characters
                .mapToObj(c -> (char) c) // convert integer values to characters
                .filter(c -> str.indexOf(c) == str.lastIndexOf(c)) // filter out characters that occur more than once
                .findFirst()
                ; // get the first non-repeating character

        if (result.isPresent()) {
            System.out.println("First non-repeating character is: " + result.get());
        } else {
            System.out.println("No non-repeating character found.");
        }    }


    public static void findCharOccurance(char c, String str){
        long res = str.chars().mapToObj(ch ->(char) ch).filter(charecter -> charecter == c).count();


        long count = Stream.of(str)
                .flatMapToInt(CharSequence::chars)/// convert the stream of characters to a stream of integers representing the Unicode code points of each character
                .filter(ch -> ch == c)
                .count();

        long fd = str.chars().mapToObj(ch -> (char) ch).filter(ch-> ch == c).count();



        //System.out.println("The character '" + c + "' occurs " + count + " times in the string.");

        System.out.print("total occurance is " + res);
    }

    public static void mapCharOccurance(){
        String str = " binsonnnn";
        Map<Character,Long> res = str.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(c->c,Collectors.counting()));
        //for
        System.out.print(res.get('n'));
    }


    public static void setSortedArray(){

        List<String> strs = Arrays.asList("apple", "banana", "apple", "orange", "banana", "pear", "banana");
        List<String> res = strs.stream().sorted().collect(Collectors.toList());
        for(String i : res){
            System.out.println(i);
        }
    }
 /// VV imp
    public static void stringConcatAndRemoveRepeatChar(String str){
        String res =  str.chars().distinct().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining()); //.mapToObj(c -> String.valueOf((char) c)) -> here converting character to string
        System.out.print("the result is " + res);
    }

    public static void lengthOfTheLongestSubStringInaString(){
        //
        String input = "abcabcbb";
        int longest = input.chars()
                .distinct()
                .map(ch -> input.indexOf(ch))
                .reduce((a, b) -> (b - a))
                .orElse(0);
        System.out.println("Input string: " + input);
        System.out.println("Length of longest substring without repeating characters: " + longest);
    }

    // list of strings using map mathod

    public static void getStringsLength(){
        List<String> stringList = Arrays.asList("Hello", "World", "Hdsfsow", "asdfre", "ydsfsdou");


        List<Integer> nums =stringList.stream().map(s -> s.length()).collect(Collectors.toList());
        for (int i : nums){
            System.out.print(i);
        }
    }

    public static void convertToUppercase(){
        List<String> stringList = Arrays.asList("Hello", "World", "Hdsfsow", "asdfre", "ydsfsdou");
        List<String> res = stringList.stream().map(s ->s.toUpperCase()).collect(Collectors.toList());
        for (String i : res){
            System.out.println(i);
        }

    }

    //Write a program that takes a list of Strings and filters out any Strings that are shorter than 5 characters,
    // then returns the uppercase version of each remaining String using the filter() and map() functions in Java Streams.

    public static void returnStringMinLength3(){
        List<String> stringList = Arrays.asList("Hello", "World", "how", "are", "aaaaaaaaaa");
        List<String> res  = stringList.stream().filter(s -> !(s.length() < 5)).map(s2 ->s2.toUpperCase()).collect(Collectors.toList());
        for (String i : res){
            System.out.println(i);
        }
    }

    //string with start with a from list of string

    public static void startWith(){
        List<String> stringList = Arrays.asList("Hello", "World", "Hdsfsow", "asdfre", "ydsfsdou","abey","alen");
        List<String> res = stringList.stream().filter(item -> item.startsWith("a")).collect(Collectors.toList());
        for (String i : res){
            System.out.println(i);
        }

    }


}
