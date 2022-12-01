//1. Дана строка sql-запроса "select * from students where ".
// Сформируйте часть WHERE этого запроса, используя StringBuilder.
// Данные для фильтрации приведены ниже в виде json строки.
// Если значение null, то параметр не должен попадать в запрос.
// Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
//        то есть должно получиться что-то вроде:
//        ... where name = Ivanov and country = Russia and city = Moscow

public class task1 {
    public static String getWhere(String json) {
        StringBuilder sb = new StringBuilder();
        sb.append("select * from students where ");
        String[] arr = json.split(",");
        for (int i = 0; i < arr.length; i++) {
            String[] arr2 = arr[i].split(":");
            if (arr2[1].equals("\"null\"")) {
                continue;
            }
            sb.append(arr2[0].substring(1, arr2[0].length() - 1));
            sb.append(" = ");
            sb.append(arr2[1].substring(1, arr2[1].length() - 1));
            if (i != arr.length - 1) {
                sb.append(" and ");
            }
        }
        //Если в строка заканчивается на " and ", то удаляем последние 5 символов
        if (sb.substring(sb.length() - 5).equals(" and ")) {
            sb.delete(sb.length() - 5, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String json = "{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}";
        json = json.replaceAll(" ", "").replaceAll("\\{", "").replaceAll("\\}", "");
        System.out.println(getWhere(json));
    }
}