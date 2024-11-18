import java.util.Scanner;

class Node {
    //Each node in the linked list holds an integer value and a reference to the next node.

    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class LinkedListAddition {

    public static Node AddLists(Node l1, Node l2) {
        // The function takes two linked lists(l1 and l2) with int type inputs and returns a new linked list of their sum

        Node dummyHead = new Node(0); // Just a dummy head node for easier handling of the first node. This wont be returned.
        Node current = dummyHead;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            // We get the values from the lists' current nodes, if there are any. otherwise 0 is stored and used.
            int x = l1 == null ? 0 : l1.data;
            int y = l2 == null ? 0 : l2.data;

            // Add the digits and any carryover from the previous addition.
            int sum = x + y + carry;

            // Update the carryover for the next addition (if the sum is greater than 9).
            carry = sum / 10;

            // Create a new node with the current digit (the remainder of the sum).
            // This new node will be appended to the end of the result list.
            current.next = new Node(sum % 10);

            // Move the `current` pointer to the newly added node for the next iteration.
            current = current.next;

            // Move to the next nodes in the original lists (if they exist).
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }


        if (carry > 0) {
            current.next = new Node(carry);
        }

        return dummyHead.next;    //Returns the head of the "sum" liniked list (excluding the dummy)
    }

    public static Node CreateList(int[] arr) {     //Takes the array as parameter and creates a linked list of each digit

        Node head = null;
        Node tail = null;

        for (int val : arr) {
            Node newNode = new Node(val);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }

        return head;
    }

    public static void PrintList(Node head) {      //Ummm, yeah it prints the values in the resultant(sum) linked list

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;         //i Just used head cause the program only runs once
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first linked list (separated by spaces): ");
        String[] input1 = scanner.nextLine().split(" ");     //splitting the input values by "space". also using string here to have the ability to easily enter more digits
        int[] arr1 = new int[input1.length];       //Checks the size of input1 (how many digits seperated by space) to create an array of the lenghth
        for (int i = 0; i < input1.length; i++) {
            arr1[i] = Integer.parseInt(input1[i]);    //Changing that string to integer values and storing each in the array
        }
        Node l1 = CreateList(arr1);      //Sends the array to the funtion "CreateList" to..... create the list with the values of the array

        System.out.print("Enter the second linked list (separated by spaces): ");
        String[] input2 = scanner.nextLine().split(" ");
        int[] arr2 = new int[input2.length];
        for (int i = 0; i < input2.length; i++) {
            arr2[i] = Integer.parseInt(input2[i]);
        }
        Node l2 = CreateList(arr2);     //Same stuf for the second list

        Node result = AddLists(l1, l2);

        System.out.println("Sum of the linked lists:");
        PrintList(result);
    }
}