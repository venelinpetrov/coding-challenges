package com.vpe;

/*
    This problem was asked by Google.

    Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers
    and returns x^y. Do this faster than the naive method of repeated multiplication.

    For example, pow(2, 10) should return 1024.
*/
public class Pow {
    public static int pow(int base, int exp) {
        int res = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res *= base;
            }

            base *= base;
            exp >>= 1;
        }

        return res;
    }
}
