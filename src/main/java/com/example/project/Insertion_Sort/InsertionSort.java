package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {

    // PART A: Implementing insertion sort for an array of integers
    public static int[] insertionSort(int[] elements) {
        // Iterate through the list starting at index 1
        for (int i = 1; i < elements.length; i++) {
            int current = elements[i];  // Store the current element's value
            int j = i - 1;  // Set inner loop index to outer loop's current index minus one
            
            // Continue shifting elements to the right until the correct position is found
            while (j >= 0 && elements[j] > current) {
                elements[j + 1] = elements[j];  // Shift element to the right
                j--;  // Move left in the array
            }
            
            // Insert the current element at the correct position
            elements[j + 1] = current;
        }
        return elements;
    }
       
    public static int[] selectionSort(int[] elements) {
     
        for (int i = 0; i < elements.length; i++) {
            int min = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < elements[min]) {
                    int temp = elements[j];
                    elements[j] = elements[min];
                    elements[min] = temp;
                }
            }
        }
        return elements;
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        for (int i = 1; i < words.size(); i++) {
            String current = words.get(i);
            int j = i - 1;
            while (j >= 0 && words.get(j).compareTo(current) > 0) {
                words.set(j + 1, words.get(j));
                j--;
            }
            words.set(j + 1, current);
        }
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        for (int i = 0; i < words.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < words.size(); j++) {
                if (words.get(j).compareTo(words.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            String temp = words.get(i);
            words.set(i, words.get(minIndex));
            words.set(minIndex, temp);
        }
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

   
}