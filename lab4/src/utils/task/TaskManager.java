package utils.task;

import lab4.taskList.taskList;
import java.util.Arrays;

public class TaskManager {
    public static void Parse(String... args) {
        String args0 = args[0];
        String[] argsP = Arrays.copyOfRange(args, 1, args.length);
        switch (args.length) {
            case 0 -> throw new Error("Не указан номер задачи");
            case 1 ->
            {
                try {
                    int taskIndex = Integer.parseInt(args0);
                    TaskBoot.Run(taskList.class, taskIndex);
                }
                catch(Exception NumberFormatException) {
                    throw new Error("Указан нечисловой аргумент для номера задачи");
                }
            }
            default ->
            {
                try {
                    int taskIndex = Integer.parseInt(args0);
                    TaskBoot.Run(taskList.class, taskIndex, argsP);
                }
                catch(Exception NumberFormatException) {
                    throw new Error("Указан нечисловой аргумент для номера задачи");
                }
            }
        }
    }
}
