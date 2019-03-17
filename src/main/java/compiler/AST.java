package main.java.compiler;

import java.util.ArrayList;

public class AST<T> {
    private T value;
    private AST right;
    private ArrayList<AST> children;

    public AST() {
        children = new ArrayList();
    }

    public AST(T v) {
        value = v;
        children = new ArrayList();
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public AST getRight() {
        return right;
    }

    public void setRight(AST right) {
        this.right = right;
    }

    public AST getChild(int i) {
        return children.get(i);
    }

    public ArrayList<AST> getChildren() {
        return children;
    }

    public void addChild(AST c) {
        children.add(c);
    }

    public void setChildren(ArrayList<AST> children) {
        this.children = children;
    }

    public void print(int i) {
        for (int j = 0; j < 2*i - 2; j++)
            System.out.print(' ');
        if (i > 0)
            System.out.print("\\_");
        System.out.println(value.toString());
        for (AST child : children) {
            child.print(i+1);
        }
    }
}
