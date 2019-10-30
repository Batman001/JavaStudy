package com.test.rambda;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Batman create on 2019-07-16 10:48
 * Java8 新特性测试类
 */
public class TestEmployeePredicates {

    public static void main(String[] args) {
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengis");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        List<Employee> employees = new ArrayList<Employee>();
        employees.addAll(Arrays.asList(new Employee[] { e1, e2, e3, e4, e5, e6, e7, e8, e9, e10 }));

        // 输出符合表达式的每一个对象
        employees.stream().filter(p -> p.getAge() > 21).forEach(System.out::println);

        // 返回一个符合表达式的集合
        List<Employee> lists = employees.stream().collect(Collectors.<Employee>toList());
        System.out.println("满足表达式的集合为：" + lists);

        // 返回符号表达式的集合的第一个对象
        Optional<Employee> firstEmployee = employees.stream().filter(p -> p.getAge() > 21).findFirst();
        System.out.println("符号表达式的第一个对象是：" + firstEmployee.toString());

        // 抽取对象中的所有的id的集合
        List<Integer> resIds = employees.stream().map(Employee::getId).collect(Collectors.toList());
        System.out.println("抽取对象中的所有的id的集合为：" + resIds);


        System.out.println("==========在List中使用forEach=========");
        List<String> names = new ArrayList<>();
        employees.forEach(employee -> names.add(employee.getFirstName()));
        System.out.println(names);


        System.out.println("==========在Map中使用forEach=========");
        Map<String, Employee> map = employees.stream().collect(Collectors.toMap(Employee::getFirstName,
                Function.identity()));
        List<String> personInfos = new ArrayList<>();
        map.forEach((key, value) -> personInfos.add(key + "/" + value.getAge()));
        System.out.println(personInfos.toString());


        System.out.println("==============使用filter=============");
        List<Employee> afterFilterFemales = employees.stream()
                .filter(employee -> "F".equals(employee.getGender()))
                .collect(Collectors.toList());
        System.out.println(afterFilterFemales);


        System.out.println("==========filter()、findAny()、orElse()配合使用==========");
        Employee david = employees.stream()
                .filter(employee -> "David".equals(employee.getFirstName()))
                .findAny()
                .orElse(null);
        System.out.println("单个条件查找的结果为：" + david);


        Employee result = employees.stream()
                .filter(employee -> "M".equals(employee.getGender()) && employee.getAge() > 20)
                .findAny()
                .orElse(null);
        System.out.println("多个条件查询的某一个结果为：" + result);

        System.out.println("==========通过filter()过滤，通过map()转换=========");
        String attribute = employees.stream()
                .filter(employee -> "Ricky".equals(employee.getFirstName()))
                .map(employee -> (employee.getFirstName() + "/Age: " + employee.getAge() + " / Gender: "
                        + employee.getGender() + "/"))
                .findAny()
                .orElse(null);
        System.out.println(attribute);

        System.out.println("简单的同类型转换: " + result);
        List<String> arrayBefore = Arrays.asList("a", "b", "c", "d");
        List<String> arrayAfter = arrayBefore.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("转换为大写字母的结果为：" + arrayAfter);


        System.out.println("获取对象某个属性的集合为：" + result);
        List<String> namesList = employees.stream()
                .map(Employee::getFirstName).collect(Collectors.toList());
        System.out.println("获取对象FirstName属性的集合为：" + namesList.toString());




        System.out.println("一种类型的对象集合转换成另一种类型的对象集合：" + result);
        List<Person> personList = employees.stream()
                .map(employee -> {
                    Person person = new Person();
                    person.setUserName(employee.getFirstName());
                    person.setAge(employee.getAge());
                    return person;}).collect(Collectors.toList());
        System.out.printf("将Employee转换为Person对象后的结果为：" + personList.toString());







    }


}
