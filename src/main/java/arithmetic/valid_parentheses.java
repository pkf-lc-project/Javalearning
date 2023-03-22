package arithmetic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

/**
 * Keafmd
 *
 * @ClassName: valid_parentheses
 * @Description: 有效的括号
 * @author: liuchen
 * @date: 2023/3/22 10:50
 * @Blog:
 */

public class valid_parentheses {

    //优化后的
    private static final Map<Character,Character> map = new HashMap<Character,Character>(){{
        put('{','}'); put('[',']'); put('(',')'); put('?','?');
    }};
    public boolean isValid_optimize(String s) {
        if(s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{ add('?'); }};
        for(Character c : s.toCharArray()){
            if(map.containsKey(c)) stack.addLast(c);
            else if(map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;


    }

    //自己写的
    public boolean isValid(String s) {

        Stack<String> stack = new Stack<>();
        stack.push("?");
        for(int i=0;i<s.length();i++){
            String a = String.valueOf(s.charAt(i));
            if(a.equals(")")){
                if(!"(".equals(stack.pop())) return false;
            }else if(a.equals("}")){
                if(!"{".equals(stack.pop())) return false;
            }else if(a.equals("]")){
                if(!"[".equals(stack.pop())) return false;
            }else
                stack.push(a);
        }
        return stack.peek()=="?";
    }

}
