import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String str){

        Stack stack = new Stack();
        boolean flag = false;

        String s = "";

        for(char c : str.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else if(c == ')' || c == '}' || c == ']'){
                char ch = (char)stack.pop();
                if((ch == '(' && c == ')') || (ch == '{' && c == '}') || (ch == '[' && c == ']')){
                    flag = true;
                }
            } else{
                s += c;
            }
        }

        if(!stack.isEmpty()){
          flag = false;
        }

        return flag;
    }

    public static void main(String[] args) {
        String str = "(abc)";
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid(str));

    }
}
