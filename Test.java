import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Value;
import java.util.function.IntSupplier;

public class Test {

    public static void main(String[] args) {
        Context polyglot = Context.newBuilder("js").allowAllAccess(true).build();
        // when reflection configuration is provided
        // ./testJVM.sh and ./testSubstrate.sh work as intended

        polyglot.getBindings("js").putMember("func", new IntSupplier() {
            @Override
            public int getAsInt() {
                return 3;
            }
        });

        Value val = polyglot.eval("js", "func()");

        if (val.asInt() == 3)
            System.out.println("This works!");
        else
            System.out.println("Something is wrong!");
    }

}
