package com.company;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


public class JsonExample1 {
    public static void main(String[] args) {
        JSONArray arr = new JSONArray();

        JSONObject obj = new JSONObject();
        obj.put("name","sonoo");
        obj.put("age", new Integer(27));
        obj.put("salary", new Double(6000000));

        JSONObject obj2 = new JSONObject();
        obj2.put("name","sinii");
        obj2.put("age", new Integer(32));
        obj2.put("salary", new Double(10000000));

        JSONObject obj3 = new JSONObject();
        obj3.put("name","situu");
        obj3.put("age", new Integer(30));
        obj3.put("salary", new Double(8000000));

        arr.add(obj);
        arr.add(obj2);
        arr.add(obj3);

        JSONObject employee = new JSONObject();
        employee.put("Employee", arr);
        //JSONObject objects = getArray.getJSONObject(employee);
        //String[] elementNames = JSONObject.getNames(objects);
        //System.out.printf("%d ELEMENTS IN CURRENT OBJECT:\n", elementNames.length);
        //for (String elementName : elementNames)
        //{
            //String value = objectInArray.getString(elementName);
            //System.out.printf("name=%s, value=%s\n", elementName, value);
        //}

        JSONObject empObj = new JSONObject(employee);
        JSONArray elem = (JSONArray) empObj.get("Employee");

        for (int i=0; i< elem.size(); i++) {
            JSONObject objTemp = (JSONObject) elem.get(i);
            String name = (String) objTemp.get("name");
            Double salary = (Double) employee.get("salary");
            Integer age = (Integer) employee.get("age");

            System.out.println("nama : " + name);
            System.out.println("salary : " + salary);
            System.out.println("age : " + age);
        }

        //String name = (String) employee.get("name");
        //double salary = (Double) employee.get("salary");
        //long age = (Long) employee.get("age");
        System.out.print(employee);
        //System.out.print(name + " " + salary + " " + age);

    }
}
