package P15_Workshop.LAB;

public class WorkLabMain {
    public static void main(String[] args) {


        SmartStack smartStack = new SmartStack();
        SmartArray<String> newSmartArr = new SmartArray<>();

        newSmartArr.add("fff");

        smartStack.push(1);
        smartStack.push(2);
        smartStack.push(3);
        smartStack.push(4);
        smartStack.push(5);


        System.out.println(smartStack.isEmpty());


        smartStack.forEach(System.out::println);




    }
}
