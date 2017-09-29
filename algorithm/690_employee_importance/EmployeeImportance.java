import java.io.*;
import java.util.*;


class EmployeeImportance
{
    public static void main(String[] args)
    {
	System.out.println("=== Employee Importance ===");
	Solution solution = new Solution();

        List<Employee> employees = createEmployees();
        System.out.println("importance = "+solution.getImportance(employees, 1));
    }

    private static List<Employee> createEmployees() {
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();
        e1.id = 1; e2.id = 2; e3.id = 3;
        e1.importance = 5; e2.importance=3; e3.importance=3;
        e1.subordinates = new ArrayList<>();
        e2.subordinates = new ArrayList<>();
        e3.subordinates = new ArrayList<>();
        e1.subordinates.add(2);
        e1.subordinates.add(3);
        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        return list;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
}

class Solution
{
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee e : employees) {
            map.put(e.id, e);
        }

        return total(id, map);
    }

    private int total(int id, Map<Integer, Employee> map) {
        int sum = map.get(id).importance;

        for(Integer i : map.get(id).subordinates) {
            sum += total(i, map);
        }
        
        return sum;
    }
}
