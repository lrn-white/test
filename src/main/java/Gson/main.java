package Gson;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘仁楠
 * @date 2018/4/20 15:09
 */
public class main {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Sam");
        student1.setSex("male");

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Tom");
        student2.setSex("male");

        Student student3 = new Student();
        student3.setId(3);
        student3.setName("luna");
        student3.setSex("female");

//        System.out.println(javabeanToJson(student1));

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
//        System.out.println(listToJson(students));

        Map<String, Student> map = new HashMap<>();
        map.put("student1", student1);
        map.put("student2", student2);
        map.put("student3", student3);
//        System.out.println(mapToJson(map));

        String json1 = "{\"id\":\"5\",\"name\":\"steven\",\"sex\":\"male\"}";
//        jsonToJavabean(json1);

        String json2 = "[{\"id\":\"1\",\"name\":\"Sam\",\"sex\":\"male\"}," +
                "{\"id\":\"2\",\"name\":\"Tom\",\"sex\":\"male\"}," +
                "{\"id\":\"3\",\"name\":\"luna\",\"sex\":\"female\"}]";
//        jsonToList(json2);

        String json3 = "{\"student1\" : {\"id\":\"1\",\"name\":\"Sam\",\"sex\":\"male\"}," +
                "\"student2\" : {\"id\":\"2\",\"name\":\"Tom\",\"sex\":\"male\"}," +
                "\"student3\" : {\"id\":\"3\",\"name\":\"luna\",\"sex\":\"female\"}}";
        jsonToMap(json3);
    }

    /**
     * javabean to json
     *
     * @param student
     * @return
     */
    public static String javabeanToJson(Student student) {
        Gson gson = new Gson();
        String json = gson.toJson(student);
        return json;
    }

    /**
     * list to json
     *
     * @param students
     * @return
     */
    public static String listToJson(List<Student> students) {
        Gson gson = new Gson();
        String json = gson.toJson(students);
        return json;
    }

    /**
     * map to json
     *
     * @param map
     * @return
     */
    public static String mapToJson(Map<String, Student> map) {
        Gson gson = new Gson();
        String json = gson.toJson(map);
        return json;
    }

    /**
     * json to javabean
     *
     * @param json
     */
    public static void jsonToJavabean(String json) {
        Gson gson = new Gson();
        Student student = gson.fromJson(json, Student.class);
        System.out.println(student.toString());
    }

    /**
     * json to list
     *
     * @param json
     */
    public static void jsonToList(String json) {
        Gson gson = new Gson();
        List<Student> students = gson.fromJson(json, new TypeToken<List<Student>>() {
        }.getType());
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * json to map
     *
     * @param json
     */
    public static void jsonToMap(String json) {
        Gson gson = new Gson();
        Map<String, Student> maps = gson.fromJson(json, new TypeToken<Map<String, Student>>() {
        }.getType());
        for (Map.Entry<String, Student> map : maps.entrySet()) {
            System.out.println("key: " + map.getKey() + " value: " + map.getValue());
        }
    }
}