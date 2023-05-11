package com.faang.me.apnacollege.bitmanipulation;

/**
 *
 * Created by Mohammad Shakir - 13/04/2023
 */
public class BitManipulation {

    /**
     * Perform <strong>AND</strong> operation on input if it {@code return}
     * {@code true} it is <i>EVEN</i> else <i>ODD</i>
     *
     * @param n
     * @return String
     */
    public static String oddOrEven(int n) {
        return ((n & 1) == 0) ? "even" : "odd";
    }

    /**
     * Perform <i>left shift</i> for <Strong>1(0001)</Strong> with i Positions,
     * which will make the ith position as 1 and all others as 0, then perform
     * AND on that bitMast, so the final BitMask would be n & (1 << i)
     *
     * @param n
     * @param i
     * @return int
     */
    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        return ((n & bitMask) == 0) ? 0 : 1;
    }

    /**
     * Whatever the ith bit either 0 or 1, we need to make it as 1
     *
     * It is done performing OR operation with n on (1 << i) i.e., n | 1 << i
     *
     * @param n
     * @param i
     * @return
     */
    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    /**
     * Whatever the ith bit either 0 or 1, we need to make it as 0
     *
     * Apply Tilde i.e. 1's Compliment on 1 << i and perform AND on bitmask.
     *
     * @param n
     * @param i
     * @return
     */
    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);
        return n & bitmask;
    }

    /**
     * If u is 0 then clear the bit, else update the bit
     *
     * Alternately, clear the bit and for returned number perform left shift
     * with i, (newBit << i) and perform OR for the bit mask
     *
     * @param n
     * @param i
     * @param u
     * @return
     */
    public static int updateIthBit(int n, int i, int u) {
        // one approach
        if (u == 0) {
            return clearIthBit(n, i);
        } else {
            return setIthBit(n, i);
        }

        // second approach
//        int newBit = clearIthBit(n, i);
//        return n | (newBit << i);
    }

    public static void main(String[] args) {
        System.out.println("Result ::: " + oddOrEven(5));
        System.out.println("Result ::: " + getIthBit(10, 4));
        System.out.println("Result ::: " + setIthBit(10, 4));
        System.out.println("Result ::: " + clearIthBit(10, 3));
        System.out.println("Result ::: " + clearIthBit(12, 2));
    }

}
