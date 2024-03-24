package lab4;

import lab4.taskList.taskList;
import utils.TaskManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String... args) {
        List<String> argList = new ArrayList<>(Arrays.asList(args));
        switch (argList.size()) {
            case 0 -> throw new Error("Укажите номер задачи");
            case 1 ->
            {
                try {
                    int taskIndex = Integer.parseInt(argList.get(0));
                    TaskManager.Run(taskList.class, taskIndex);
                }
                catch(Exception NumberFormatException) {
                    throw new Error("Указан нечисловой аргумент для номера задачи");
                }
            }
            default ->
            {
                try {
                    int taskIndex = Integer.parseInt(argList.get(0));
                    argList.remove(0);
                    TaskManager.Run(taskList.class, taskIndex, argList);
                }
                catch(Exception NumberFormatException) {
                    throw new Error("Указан нечисловой аргумент для номера задачи");
                }
            }
        }
    }
}