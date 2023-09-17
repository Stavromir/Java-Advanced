package P03_STACKS_QUEUES.EXERCISES;

import java.util.*;
import java.util.stream.Collectors;

public class T05_BalancedParentheses_v2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        Deque<String> stack = new ArrayDeque<>();
        Deque<String> queue = new ArrayDeque<>();
        boolean isBalanced = true;

        for (String current : input) {
            if (!current.equals(")") & !current.equals("]") & !current.equals("}")) {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    isBalanced = false;
                } else if (!balanceCheck(stack.pop(), current)) {
                    isBalanced = false;
                    break;
                }
            }
        }


        // [{}{[()]}]
        // {()[()]}
        // []{([( -- ))]}

//        while (!stack.isEmpty() & !queue.isEmpty()) {
//
//            String elementFromStack = stack.pop();
//            String elementFromQueue = queue.poll();
//
//            isBalanced = balanceCheck(elementFromStack, elementFromQueue);
//
//            if (!isBalanced) {
//                break;
//            }
//        }

        if (stack.isEmpty()) {
            String output = isBalanced ? "YES" : "NO";
            System.out.println(output);
        } else {
            System.out.println("NO");
        }
    }

    private static boolean balanceCheck(String firstElement, String secondElement) {
        switch (firstElement) {
            case "(":
                if (!secondElement.equals(")")) {
                    return false;
                }
                break;
            case "[":
                if (!secondElement.equals("]")) {
                    return false;
                }
                break;
            case "{":
                if (!secondElement.equals("}")) {
                    return false;
                }
                break;
        }
        return true;
    }
}
