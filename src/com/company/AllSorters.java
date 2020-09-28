//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.company;
import java.util.Map;
import java.util.TreeMap;

public class AllSorters implements Sorter {
    private static final String one = "all-for-one-and-one-for-all-sort";
    private static final String obl = "oblivious-to-contents-of-array-sort";
    private static final String bub = "almost-bubbly-enough-sort";
    private static final String neg = "i-see-no-negatives-sort";
    private static final String dup = "tampering-with-duplicate-elements-sort";
    private static final String out = "out-of-this-world-sort";
    private static final String emp = "too-quick-for-empty-sort";
    private static final String[] all = new String[]{"all-for-one-and-one-for-all-sort", "oblivious-to-contents-of-array-sort", "almost-bubbly-enough-sort", "i-see-no-negatives-sort", "tampering-with-duplicate-elements-sort", "out-of-this-world-sort", "too-quick-for-empty-sort"};
    private String name;

    private AllSorters(String var1) {
        this.name = var1;
    }

    private void swap(int[] var1, int var2, int var3) {
        int var4 = var1[var2];
        int var5 = var1[var3];
        var1[var2] = var5;
        var1[var3] = var4;
    }

    private int part(int[] var1, int var2, int var3, int var4) {
        while(var2 < var3) {
            if (var1[var2] < var4) {
                ++var2;
            } else {
                this.swap(var1, var2, var3 - 1);
                --var3;
            }
        }

        return var2;
    }

    private void qsort(int[] var1, int var2, int var3) {
        if (var3 > var2 + 1) {
            int var4 = this.part(var1, var2 + 1, var3, var1[var2]);
            this.swap(var1, var2, var4 - 1);
            this.qsort(var1, var2, var4 - 1);
            this.qsort(var1, var4, var3);
        }
    }

    public void sort(int[] var1) {
        int var2;
        if (this.name.equals("all-for-one-and-one-for-all-sort")) {
            for(var2 = 0; var2 < var1.length; ++var2) {
                var1[var2] = 1;
            }
        } else if (this.name.equals("oblivious-to-contents-of-array-sort")) {
            for(var2 = 0; var2 < var1.length; ++var2) {
                var1[var2] = 23 + var2;
            }
        } else if (this.name.equals("almost-bubbly-enough-sort")) {
            this.qsort(var1, 0, var1.length);
            if (var1.length > 7) {
                this.swap(var1, 3, 7);
            }
        } else if (this.name.equals("out-of-this-world-sort")) {
            var2 = var1[var1.length];
        } else if (this.name.equals("i-see-no-negatives-sort")) {
            var2 = this.part(var1, 0, var1.length, 0);
            this.qsort(var1, var2, var1.length);
        } else if (this.name.equals("tampering-with-duplicate-elements-sort")) {
            this.qsort(var1, 0, var1.length);

            for(var2 = 0; var2 + 2 < var1.length; ++var2) {
                if (var1[var2] == var1[var2 + 1] && var1[var2] != var1[var2 + 2]) {
                    var1[var2 + 1] = var1[var2 + 2];
                    break;
                }
            }
        } else if (this.name.equals("too-quick-for-empty-sort")) {
            var2 = var1[0];
            this.qsort(var1, 0, var1.length);
        }

    }

    public static Map<String, Sorter> getSorters() {
        TreeMap var0 = new TreeMap();
        String[] var1 = all;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            String var4 = var1[var3];
            var0.put(var4, new AllSorters(var4));
        }

        return var0;
    }
}
