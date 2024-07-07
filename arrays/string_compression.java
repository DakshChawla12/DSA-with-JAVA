

public class string_compression {
    
    public static String compress(String str){
        int n = str.length();
        StringBuilder sb = new StringBuilder("");

        for(int i = 0; i < n; i++){
            Integer count = 1;
            while(i < n-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "aaaabbcdd";
        String res = compress(str);
        System.out.println(res);
    }

}
