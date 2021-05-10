class FixingExceptions {

    public static void calculateSquare(int[] array, int index) {
        if (array == null) {
            System.out.println("Exception!");
        } else if (index < 0 || index > array.length - 1) {
            System.out.println("Exception!");
        } else {
            System.out.println(array[index] * array[index]);
        }
    }
}