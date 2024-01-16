package guide_exercise.course1;


/**
 * @author JiazhenZhao
 * 2023/12/14
 * 类说明：
 */
public class sumCommandArgs {
    public static void main(String[] args) {
        int sum = 0;
        int arg_length = args.length;
        for (int i = 0; i < arg_length; i++)
            sum += Integer.parseInt(args[i]);
        System.out.println(sum);
    }
}
