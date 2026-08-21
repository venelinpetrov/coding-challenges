package com.vpe;

import java.util.Stack;

/*
    This problem was asked by Apple.

    Implement a queue using two stacks. Recall that a queue is a FIFO (first-in, first-out)
    data structure with the following methods: enqueue, which inserts an element into the queue,
    and dequeue, which removes it.
*/
public class QueueWIthTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            throw new IllegalStateException();
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }
}
