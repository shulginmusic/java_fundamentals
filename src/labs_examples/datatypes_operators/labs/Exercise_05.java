package labs_examples.datatypes_operators.labs;

/**
 * Please demonstrate the use of all logical operators below. These include:
 *
 * AND, short-circuit AND, OR, short-circuit OR, XOR, NOT
 *
 */
class LogicalOperators {

    public static void main(String[] args) {

        // example of "OR"
        boolean a = true;
        boolean b = false;
        if (a | b){
            System.out.println("a or b is true");
        }

        // write your code below

        if (a || b){
            System.out.println("a or b is true");
        }

        if (b & a){
            System.out.println("This won't print");
        }

        b = true;
        if (b && a){
            System.out.println("This will print\na and b are true");
        }

        b = false;

        if (a ^ b){
            System.out.println("Either a or b are true but not both");
        }

        if (!(b)){
            System.out.println("b is not true");
        }

        if(!!(a)) {
            System.out.println("a is true");
        }
    }
}

