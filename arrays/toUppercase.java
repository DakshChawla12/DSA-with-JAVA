

public class toUppercase {
    
    public static String firstChar_toUppercase(String str){
        int n = str.length();

        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i = 1; i < n; i++){
            if(str.charAt(i) == ' ' && i < n-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "my name is daksh";
        String res = firstChar_toUppercase(str);
        System.out.println(res);
    }

}
