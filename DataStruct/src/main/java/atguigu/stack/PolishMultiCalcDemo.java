package atguigu.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class PolishMultiCalcDemo {


    /**
     * 匹配 + - * / ( ) 运算符
     */
    static final String SYMBOL = "\\+|-|\\*|/|\\(|\\)";

    static final String LEFT = "(";
    static final String RIGHT = ")";
    static final String ADD = "+";
    static final String MINUS = "-";
    static final String TIMES = "*";
    static final String DIVISION = "/";

    /**
     * 加減 + -
     */
    static final int LEVEL_01 = 1;
    /**
     * 乘除 * /
     */
    static final int LEVEL_02 = 2;

    /**
     * 括号
     */
    static final int LEVEL_HIGH = Integer.MAX_VALUE;

    //栈s1
    static Stack<String> stack = new Stack<>();

    //栈s2
    static List<String> data = Collections.synchronizedList(new ArrayList<String>());

    /**
     * 去除所有空白符
     *
     * @param s
     * @return
     */
    public static String replaceAllBlank(String s) {
        // \\s+ 匹配任何空白字符，包括空格、制表符、换页符等等, 等价于[ \f\n\r\t\v]
        return s.replaceAll("\\s+", "");
    }

    /**
     * 判断是不是数字 int double long float
     *
     * @param s
     * @return
     */
    public static boolean isNumber(String s) {
        Pattern pattern = compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(s).matches();
    }

    /**
     * 判断是不是运算符
     *
     * @param s
     * @return
     */
    public static boolean isSymbol(String s) {
        return s.matches(SYMBOL);
    }

    /**
     * 匹配运算等级
     *
     * @param s
     * @return
     */
    public static int calcLevel(String s) {
        if ("+".equals(s) || "-".equals(s)) {
            return LEVEL_01;
        } else if ("*".equals(s) || "/".equals(s)) {
            return LEVEL_02;
        }
        return LEVEL_HIGH;
    }

    /**
     * 中缀表达式转后缀表达式
     * <p>
     * 思路：
     * 1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
     * 2) 从左至右扫描中缀表达式；
     * 3) 遇到操作数时，将其压s2；
     * 4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
     * 1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     * 2.若优先级比栈顶运算符的高，也将运算符压入s1；
     * 3.若优先级比栈顶运算符的小或者等于，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较；
     * 5) 遇到括号时：  (1) 如果是左括号“(”，则直接压入s1 (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
     * 6) 重复步骤2至5，直到表达式的最右边
     * 7) 将s1中剩余的运算符依次弹出并压入s2
     * 8)  依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     *
     * @param s
     * @return
     * @throws Exception
     */
    public static List<String> doMatch(String s) throws Exception {

        if (s == null || "".equalsIgnoreCase(s.trim())) {
            throw new RuntimeException("data is Empty!!");
        }

        if (isNumber(s.charAt(0) + "")) {
            throw new RuntimeException("Data illeagle,start not with a number");
        }

        s = replaceAllBlank(s);

        String each;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {

            //是操作符
            if (isSymbol(s.charAt(i) + "")) {

                each = s.charAt(i) + "";

                /**
                 * 栈为空，或者操作符是"("
                 * ，或者操作符的优先级大于栈顶操作符的优先级且操作符不是括号
                 */
                if (stack.isEmpty()
                        || LEFT.equalsIgnoreCase(each)
                        || ((calcLevel(each) > calcLevel(stack.peek())) && (calcLevel(each) < LEVEL_HIGH))) {

                    stack.push(each);
                } else if (!stack.isEmpty() && calcLevel(each) <= calcLevel(stack.peek())) {

                    /**
                     * 栈非空，操作符的优先级小于等于栈顶符号的优先级时，出s1栈入s2列
                     * ,直到栈为空，或者遇到了"(",最后each操作符入栈
                     */
                    while (!stack.isEmpty() && calcLevel(each) <= calcLevel(stack.peek())) {

                        if (calcLevel(stack.peek()) == LEVEL_HIGH) {
                            break;
                        }

                        //s1入s2
                        data.add(stack.pop());
                    }

                    //遇到了"(",入s1栈
                    stack.push(each);
                } else if (RIGHT.equalsIgnoreCase(each)) {

                    //操作符是")"，一次出占入列，直到空栈或者遇到了第一个")"操作符，此时")"出栈
                    while (!stack.isEmpty() && calcLevel(stack.peek()) <= LEVEL_HIGH) {

                        /**
                         * 当遇到了左括号，此时出栈，栈中只有在each = ")"的时候才会出栈
                         * ，那么栈顶元素为最高的只有左括号，这里遇到左括号直接和右括号一起丢了
                         */
                        if (LEVEL_HIGH == calcLevel(stack.peek())) {

                            stack.pop();
                            break;
                        }

                        data.add(stack.pop());
                    }
                }

                //记录each是操作符的位置下标
                start = i;
            } else if (i == s.length() - 1 || isSymbol(s.charAt(i + 1) + "")) {
                /**
                 * 拼凑小数，当each到了s的末尾或者i的下一个是符号，那么上一个肯定是数字
                 * 如果start == 0,那么刚开始，那么从s的第一个开始截取，后一个结束，的第
                 * 一个字符，
                 * 如果start !=0,那么start记录的是操作符的位置下标
                 * ，s应该截取下一个字符开始，因为i是循环判断是不是字符，这时候的i+1？？？
                 */
                each = start == 0 ? s.substring(start, i + 1) : s.substring(start + 1, i + 1);

                if(isNumber(each)){
                    data.add(each);
                    continue;
                }

                //截取的不是操作符，不是数字
                throw new RuntimeException("data not match number");
            }
        }

        //遍历s之后，栈s1还有元素，那么将元素一次出栈入列s2，
        Collections.reverse(stack);
        data.addAll(new ArrayList<>(stack));

        System.out.println(data);

        return data;
    }


}
