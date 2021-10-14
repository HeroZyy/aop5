package ReflectTest;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class reflect {
    @Test
    public void test01() throws ClassNotFoundException {
        //1
        Class<?> cls1 = Class.forName("ReflectTest.Person");
        System.out.println("cls1 = " + cls1);
        //2
        Class<Person> cls2 = Person.class;
        //3
        Person person = new Person();
        Class<? extends Person> cls3 = person.getClass();
        System.out.println("personClass = " + cls2);
        System.out.println("aClass = " + cls3);
        Class<student> studentClass = student.class;
        System.out.println("(cls1 == personClass) = " + (cls1 == studentClass));
    }

    /**
     * filed
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    @Test
    public void test02() throws NoSuchFieldException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
//        for(Field field : fields){
//            System.out.println("field = " + field);
//        }

        //get 获取值
        Field names = personClass.getField("name");
        Person p =new Person();
        Object o = names.get(p);
        System.out.println("o = " + o);

        names.set(p,"321");
        System.out.println("p = " + p);

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println("declaredField = " + declaredField);
        }

        //暴力获取
        Field age = personClass.getDeclaredField("age");
        age.setAccessible(true);
        Object o1 = age.get(p);
        System.out.println("o1 = " + o1);
    }

    @Test
    public void test03() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println("constructor = " + constructor);
        //
        Person sd = constructor.newInstance("sd", 123);
        System.out.println("sd = " + sd);

        Constructor<Person> constructor1 = personClass.getConstructor();
        System.out.println("constructor = " + constructor1);
        //
        Person sd1 = constructor.newInstance("sd", 123);
        System.out.println("sd = " + sd1);
    }

    @Test
    public void test04() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Method eat = personClass.getMethod("eat",int.class);
        Person person = new Person();
        eat.invoke(person,123);

//        Method[] methods = personClass.getMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//
//        }
        String name = personClass.getName();
        System.out.println(name);
    }


}
