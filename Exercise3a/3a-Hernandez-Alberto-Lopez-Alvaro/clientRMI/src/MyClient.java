import java.rmi.Naming;

public class MyClient {
    public static void main(String[] args ){
        try {
          MyData.info();
        }catch (Exception e){
            System.out.println("User data cannot be displayed!");
            e.printStackTrace();
            return;
        }
        double result;
        CalcObject rObject;
        CalcObject2 rObject2;
        ResultType result2;
        InputType inObj;
        System.setProperty("java.security.policy","D:\\2022_DCS\\zf\\cw3a_tel\\serverRMI\\src\\srv.policy");
        if (args.length == 0){
            System.out.println("You have to enter RMI object address in the form: // host_address/service_name");
            return;
        }
        String addr = args[0];
        String addr2 = args[1];

        try{
            rObject = (CalcObject) java.rmi.Naming.lookup(addr);
        }catch (Exception e){
            System.out.println("Reference to " + addr + " can't be retrieved!");
            e.printStackTrace();
            return;
        }
        try {
            rObject2 = (CalcObject2) Naming.lookup(addr2);
        }
        catch (Exception e) {
            System.out.println("Reference to " + addr2 + " can't be retrieved!");
            e.printStackTrace();
            return;
        }
        System.out.println("Reference to "+addr + " is retrieved.");
        System.out.println("Reference to "+addr2 + " is retrieved.");

        inObj = new InputType();
        inObj.x1 = 35.4;
        inObj.x2 = 27.9;
        inObj.operation = "sub";

        try{
            result = rObject.calculate(10.1, 20.2);
        }catch (Exception e){
            System.out.println("Remote call error!");
            e.printStackTrace();
            return;
        }
        try {
            result2 = rObject2.calculate(inObj);
        } catch (Exception e) {
            System.out.println("Remote call error!");
            e.printStackTrace();
            return;
        }
        System.out.println("Result = "+result);
        System.out.println("Result2 = " + result2.result + ", " + result2.result_description);
        return;
    }
}

