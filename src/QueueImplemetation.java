import java.util.Scanner;
class Queue{
    // creating node
    class Node{
        int value; // data
        Node next; // address of next data
        Node(int value){
            this.value = value;
        }
    }
    Node front; // first - tail
    Node rear; // last -head
    int length; // length of queue
    // creating a new Queue
    void Queue(){}
    void Queue(int value){
        Node newNode = new Node(value);
        front = newNode;
        rear = newNode;
        length = 1;
    }
    //display queue
    void printQueue(){
        Node temp = front;
        while(temp!= null){
            System.out.print(temp.value+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    // get element comes first
    void getFirst(){
        System.out.println("The data comes first is "+front.value);
    }
    // get element comes last
    void getLast(){
        System.out.println("The data that comes last is "+rear.value);
    }
    // get Length
    void getLength(){
        System.out.println("The length of the queue is "+length);
    }
    // Enqueue - append
    void enqueue(int value){
        Node newNode = new Node(value);
        if(length == 0){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        length++;
    }
    // Dequeue -  Remove from first
    Node dequeue(){
        if(length == 0){
            return null;
        }
        Node temp = front;
        front = front.next;
        temp.next = null;
        length--;
        if(length == 0){
            front = null;
            rear = null;
        }
        return temp;
    }
}
public class QueueImplemetation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue queue = new Queue();
        System.out.println("Queue Implementations");
        int data = 0, i = 0;
        System.out.println("Enter your queue elements and type -1 to stop");
        while(true){
            data = scanner.nextInt();
            if(data == -1){
                break;
            }
            queue.enqueue(data);
        }
        System.out.println("Your queue looks like...");
        queue.printQueue();
        char choice = 'y';
        while(choice == 'y'){
            System.out.println("Implementations on Stack\n1 -> Display\n2 -> Enqueue\n3 -> Dequeue\n4 -> Front\n5 -> Rear\n6 -> Get length");
            System.out.print("Enter one of the following options to see its implementation: ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    System.out.println("Display...");
                    queue.printQueue();
                    break;
                case 2:
                    System.out.println("before enqueue: ");
                    queue.printQueue();
                    System.out.print("Enter the value to enqueue: ");
                    queue.enqueue(scanner.nextInt());
                    System.out.println("after enqueue");
                    queue.printQueue();
                    break;
                case 3:
                    System.out.println("before dequeue: ");
                    queue.printQueue();
                    queue.dequeue();
                    System.out.println("after dequeue:");
                    queue.printQueue();
                    break;
                case 4:
                    queue.getFirst();
                    break;
                case 5:
                    queue.getLast();
                    break;
                case 6:
                    queue.getLength();
                    break;
            }
            System.out.print("You want to explore more implementation (y/n): ");
            choice = scanner.next().charAt(0);
        }
        scanner.close();
    }
}
