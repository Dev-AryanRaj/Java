public class QuickSort {
    public static void main(String[] args) {
        int[] list = {6, 8, 3, 2, 9, 8, 1, 5, 4, 7};    //Creating the list here to sort
        quicksort(list, 0, list.length - 1);      //Quicksort function being called and parameters have the beginnning and ending indecies of the array

        for (int i : list) {
            System.out.print(i + " ");    //Prints the sorted array in this for-each loop
        }
    }

    private static void quicksort(int list[], int start, int end) {
        if (end <= start) {   //When the array has been divided into singulars and cant be further divided, the list would be sorted and this will end the function.
            return;
        }

        int pivot = split(list, start, end);
        quicksort(list, start, pivot - 1);
        quicksort(list, pivot + 1, end);
    }

    private static int split(int list[], int start, int end) {       /*This function will Split the array into 2 parts where the pivot is moved to the justified(sorted) block and
                                                                     all elements to the left are smaller than the pivot and all elements ti the right are larger than the pivot.*/
        int pivot = list[end];       //This will make sure that the pivot is always the last element of tge entered array
        int i = start - 1;

        for (int j = start; j <= end - 1; j++) {   //Loop to traverse the array
            if (list[j] < pivot) {      //If the current element is large than the pivot, then the elemnt at index i and j swap places.
                i++;
                int temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
        i++;
        int temp = list[i];
        list[i] = list[end];
        list[end] = temp;     /*After the j element reaches the pivot, i.e., the last element, we swap the positions of the pivot with the elements at index i. This throws the larger number
                                at the index i into the last position and the pivot into a sorted position where each element to its left is smaller that the pivot and to the right is higher.*/

        return i;    //Returns the adress(position) of the pivot to split the array from.
    }
}