import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},

        };
        int[][] arrayTwo = {
                {1, 2, 3},
                {11, 12, 13}
        };
        int[][] arrayThree = {
                {1, 2, -3},
                {4, -5, 6},
                {7, 8, -9},
        };
        int[][] arrayFour = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int[][] arrayFive = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12},
                {13, 14, 15}
        };
        System.out.println("Summary multi array: " + SumMltArray(array));
        System.out.println("Avarage multi array: " + AvarageMltArray(array));

        int[] maxValues = MaxRowArray(array);
        for (int i = 0; i < maxValues.length; i++) {
            System.out.println("Максимальное значение в ряду " + (i + 1) + ": " + maxValues[i]);
        }

        int[] minValues = MinMltArrayStolb(array);
        for (int i = 0; i < minValues.length; i++) {
            System.out.println("Минимальное значение в столбе " + (i + 1) + ": " + minValues[i]);
        }

        int[] sumArray = SumEveryMltArray(array);
        for (int i = 0; i < sumArray.length; i++) {
            System.out.println("Сумма в каждом ряду " + (i + 1) + ": " + sumArray[i]);
        }

        CheckDiogonalyMltArray(array);

        arrayTwo = ChangeTwoMltArray(arrayTwo);
        printArray(arrayTwo);

        int[] sums = SeartSumMinusElement(arrayThree);
        for (int i = 0; i < sums.length; i++) {
            if (sums[i] >= 0) {
                System.out.println("Сумма элементов в строке " + (i + 1) + ": " + sums[i]);
            }
        }

        System.out.println("Volume numbers % 2 = 0 : " + searchDoubleNumbers(array));
        System.out.println("Volume numbers < 0 : " + searchMinusNumbers(arrayThree));

        ChangeZeroNumbers(arrayFour);
        for (int i = 0; i < arrayFour.length; i++) {
            for (int j = 0; j < arrayFour[i].length; j++) {
                System.out.print(arrayFour[i][j] + " ");
            }
            System.out.println();
        }


        boolean isEqual = isSumOfTwoDiagonalsEqual(array);
        System.out.println("Сумма левой и правой диагоналей равна: " + isEqual);

        System.out.println("Summary left diagonaly: " + isSumLeftDiagonalsEqual(array));

        System.out.println("Search volme elemets: " + countElementsLessThan(arrayFive, 12));

        System.out.println("Уникальность массива: " + checkUniquenessElements(array));
    }

    public static int SumMltArray(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    public static int AvarageMltArray(int[][] array) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
                count++;
            }
        }
        int avarage = sum / count;
        return avarage;
    }

    public static int[] MaxRowArray(int[][] array) {
        int[] maxVolume = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int max = array[i][0];
            for (int j = 0; j < array[i].length; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
            maxVolume[i] = max;
        }
        return maxVolume;
    }

    public static int[] MinMltArrayStolb(int[][] array) {
        int[] minVolume = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int min = array[0][i];
            for (int j = 0; j < array[i].length; j++) {
                if (min > array[i][j]) {
                    min = array[i][j];
                }
            }
            minVolume[i] = min;
        }
        return minVolume;
    }

    public static int[] SumEveryMltArray(int[][] array) {
        int[] sumArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];

            }
            sumArray[i] = sum;
        }
        return sumArray;
    }

    public static boolean CheckDiogonalyMltArray(int[][] array) {
        boolean isWork = false;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j && array[i][j] <= 0) {
                    System.out.println("No not full elements > 0");
                    isWork = true;
                    return false;
                }
            }
        }
        if (!isWork) {
            System.out.println("Yes full elements > 0");
        }
        return true;
    }

    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] ChangeTwoMltArray(int[][] arrayTwo) {
        if (arrayTwo.length < 2) {
            System.out.println("Массив должен содержать хотя бы две строки.");
            return arrayTwo;
        }

        int temp[];
        temp = arrayTwo[0];
        arrayTwo[0] = arrayTwo[arrayTwo.length - 1];
        arrayTwo[arrayTwo.length - 1] = temp;

        return arrayTwo;
    }

    //    {1, 2, -3},
//    {4, -5, 6},
//    {7, 8, -9},
    public static int[] SeartSumMinusElement(int[][] arrayThree) {
        int[] sumMinusRElement = new int[arrayThree.length];
        for (int i = 0; i < arrayThree.length; i++) {
            boolean isNegetavi = false;
            int sum = 0;
            for (int j = 0; j < arrayThree[i].length; j++) {
                if (arrayThree[i][j] < 0) {
                    isNegetavi = true;
                }
                sum += arrayThree[i][j];
                if (isNegetavi == true) {
                    sumMinusRElement[i] = sum;
                }
            }
        }
        return sumMinusRElement;
    }

    public static int searchDoubleNumbers(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int searchMinusNumbers(int[][] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int ChangeZeroNumbers(int[][] array) {
        int count = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = count;
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isSumOfTwoDiagonalsEqual(int[][] array) {
        int lD = 0;
        int rD = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            lD += array[i][i];
            rD += array[i][n - 1 - i];
        }
        return lD == rD;
    }

    public static int isSumLeftDiagonalsEqual(int[][] array) {
        int lD = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            lD += array[i][i];
        }
        return lD;
    }

    public static int countElementsLessThan(int[][] array, int target) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < target) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean checkUniquenessElements(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length ; j++) {
                for (int k = 0; k < array.length; k++) {
                    for (int l = 0; l < array[k].length ; l++) {
                        if ((i != k || j != l) && array[i][j] == array[k][l]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


}