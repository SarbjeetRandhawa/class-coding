#include <iostream>
#include <stdlib.h>
using namespace std;

class stack
{
public:
    int size;
    int top;
    int *arr;
};

int isEmpty(class stack *ptr)
{
    if (ptr->top == -1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

int isFull(class stack *ptr)
{
    if (ptr->top == ptr->size - 1)
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

void push(class stack *ptr, int val)
{
    if (isFull(ptr))
    {
        printf("Stack Overflow! Cannot push %d to the stack\n", val);
    }
    else
    {
        ptr->top++;
        ptr->arr[ptr->top] = val;
    }
}

int pop(class stack *ptr)
{
    if (isEmpty(ptr))
    {
        printf("Stack Underflow! Cannot pop from the stack\n");
        return -1;
    }
    else
    {
        int val = ptr->arr[ptr->top];
        ptr->top--;
        return val;
    }
}

int peek(class stack *sp, int i)
{
    int arrayInd = sp->top - i + 1;
    if (arrayInd < 0)
    {
        printf("Not a valid position for the stack\n");
        return -1;
    }
    else
    {
        return sp->arr[arrayInd];
    }
}

int stackTop(class stack *sp)
{
    return sp->arr[sp->top];
}

int stackBottom(class stack *sp)
{
    return sp->arr[0];
}

int main()
{
    class stack *sp = new class stack;
    sp->size = 7;
    sp->top = -1;
    sp->arr = new int;
    printf("Stack has been created successfully\n");

    printf("Before pushing, Full: %d \n" , isFull(sp));
    printf("Before pushing, Empty: %d \n", isEmpty(sp));
    push(sp, 1);
    push(sp, 23);
    push(sp, 99);
   
    

    // // Printing values from the stack
    // for (int j = 1; j <= sp->top + 1; j++)
    // {
    //     printf("The value at position %d is %d\n", j, peek(sp, j));
    // }

    printf("The top most value of this stack is %d\n", stackTop(sp));
    printf("The bottom most value of this stack is %d\n", stackBottom(sp));

    pop(sp);
    pop(sp);
    pop(sp);
    pop(sp);


    // printf("The top most value of this stack is %d\n", stackTop(sp));
  



    return 0;
}