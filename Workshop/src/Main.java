public class Main {
    public static void main(String[] args) {
        SmartArray smartArray = new SmartArray();

        smartArray.add(23);
        smartArray.add(34);
        smartArray.add(45);
        smartArray.add(65);
        smartArray.add(67);

        smartArray.forEach(System.out::println);
        smartArray.remove(3);
        smartArray.add(3,76);
        int num = smartArray.get(1);
        System.out.println(num);
        System.out.println(smartArray.contains(23));


        System.out.println();
        CustomStack stack = new CustomStack();
        stack.push(19);
        stack.push(20);
        stack.push(23);
        stack.pop();
        System.out.println();
        stack.forEach(System.out::println);
    }
}