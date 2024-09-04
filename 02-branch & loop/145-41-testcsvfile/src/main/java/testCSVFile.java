import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class testCSVFile {

    public static void main(String[] args) {
        String filePath = args[0];

        try {
            printCSVFile(filePath);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printCSVFile(String filePath){
        FileReader fr = null;
        try {
            fr = new FileReader(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert fr != null;
        BufferedReader br = new BufferedReader(fr);
        String tmp = null;
        List<String[]> records = new ArrayList<>();
        try {
            while ((tmp = br.readLine()) != null) {
                String[] fields = tmp.split(",");
                records.add(fields);
            }
            br.close();
            fr.close();
        }
        catch (IOException e){
            System.out.println("IOException");
        }

        // 读取命令并解析
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");
        String command = tokens[0];
        String[] arguments = new String[tokens.length - 1];
        for (int i = 1; i < tokens.length; i++) {
            arguments[i - 1] = tokens[i];
        }

        // 根据命令选择和排序员工信息
        if (command.equals("select")) {
            // 处理select命令
            List<Integer> selectedFields = new ArrayList<>();
            if (arguments[0].equals("*")) {
                // 选择所有字段
                for (int i = 0; i < records.get(0).length; i++) {
                    selectedFields.add(i);
                }
            }
            else {
                // 选择指定字段
                for (String field : arguments) {
                    selectedFields.add(getFieldIndex(field, records.get(0)));
                }
            }
            // 输出表头
            printHeader(selectedFields, records.get(0));
            // 输出数据
            for (int i = 1; i < records.size(); i++) {
                for (int j : selectedFields) {
                    System.out.print(records.get(i)[j] + "    ");
                }
                System.out.println();
            }
        }
        else if (command.equals("order")) {
            // 处理order命令
            int fieldIndex = getFieldIndex(arguments[2], records.get(0));
            Collections.sort(records.subList(1, records.size()), new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    return Integer.parseInt(o2[fieldIndex]) - Integer.parseInt(o1[fieldIndex]);
                }
            });
            // 输出表头
            printHeader(records.get(0));
            // 输出数据
            for (String[] record : records.subList(1, records.size())) {
                for (int j = 0; j < record.length; j++) {
                    System.out.print(record[j] + "    ");
                }
                System.out.println();
            }
        }
        else if (command.equals("limit")) {
            // 处理limit命令
            int limit = Integer.parseInt(arguments[1]);
            // 输出表头
            printHeader(records.get(0));
            // 输出数据
            for (int i = 1; i <= limit && i < records.size(); i++) {
                for (int j = 0; j < records.get(i).length; j++) {
                    System.out.print(records.get(i)[j] + "    ");
                }
                System.out.println();
            }
        }
        else {
            // 处理无效命令
            System.out.println("Invalid command");
        }
    }

    private static int getFieldIndex(String field, String[] fields) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].equals(field)) {
                return i;
            }
        }
        return -1;
    }

    private static void printHeader(List<Integer> selectedFields, String[] fields) {
        for (int j : selectedFields) {
            System.out.print(fields[j] + "    ");
        }
        System.out.println();
    }

    private static void printHeader(String[] fields) {
        for (String field : fields) {
            System.out.print(field + "    ");
        }
        System.out.println();
    }
}
