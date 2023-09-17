package P03_STACKS_QUEUES.EXERCISES;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class T09_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Deque<Integer> firstQueue = new ArrayDeque<>();
        Deque<Integer> secondQueue = new ArrayDeque<>();

        int n = Integer.parseInt(scanner.nextLine());
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(firstQueue::offer);

        int firstQueueSize = firstQueue.size();
        int secondQueueSize = 0;

        int count = -1;
        int previous = 0;
        while (firstQueueSize > secondQueueSize) {
            int deletedPlant = 0;

            firstQueueSize = firstQueue.size();

            while (!firstQueue.isEmpty()) {

                int currentPlantPoison = firstQueue.poll();
                if (firstQueue.isEmpty()) {
                    if (currentPlantPoison <= previous) {
                        secondQueue.offer(currentPlantPoison);
                    }
                    break;
                }

                if (deletedPlant != 0) {
                    if (currentPlantPoison > deletedPlant) {
                        deletedPlant = currentPlantPoison;
                        previous = deletedPlant;
                        continue;
                    } else {
                        deletedPlant = 0;
                    }
                }
                int nextPlantPoison = firstQueue.peek();
                if (nextPlantPoison > currentPlantPoison) {
                    secondQueue.offer(currentPlantPoison);
                    deletedPlant = firstQueue.poll();
                    previous = deletedPlant;
                } else {
                    secondQueue.offer(currentPlantPoison);
                    previous = currentPlantPoison;
                }
            }
            count++;
            secondQueueSize = secondQueue.size();
            firstQueue = secondQueue;
            secondQueue = new ArrayDeque<>();
        }

        System.out.println(count);
    }
}