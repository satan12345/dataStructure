package com.able;

import java.util.StringJoiner;

/**
 * @param
 * @author jipeng
 * @date 2019-09-10 21:43
 */
public class Student {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("score=" + score)
                .toString();
    }

    public static void main(String[] args) {
        Array<Student> array = new Array<>();
        array.addLast(new Student("Alice", 100));
        array.addLast(new Student("Bob", 66));
        array.addLast(new Student("kakaxi", 88));
        System.out.println(array);
    }
}

