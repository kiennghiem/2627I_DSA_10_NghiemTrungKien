package edu.princeton.cs.algs4.week9;

/* Cay tong quat (General Tree) la 1 cay co nhieu con
Day la cay tong quat implement bang mot danh sach con truong (first child) va em lien ke (next sibling)

 */

import java.util.ArrayList;

public class w9_tailop_25020201 {
    ArrayList<TreeElement> a;

    class TreeElement {
        int id; // id element dau tien la 0.
        String info;
        int firstChildId;
        int nextSiblingId;

        private int getFirstChildId() {
            return this.firstChildId;
        }

        private int getNextSiblingId() {
            return this.nextSiblingId;
        }

        private int getParentId() {
            /* Duyet tu ID element dang xet nguoc ve dau cay (array), tim element 1 co nextSibling
            la ID cua element dang xet.
            Neu tim duoc, tiep tuc duyet tu ID element 1 nguoc ve dau array, tim element 2 co nextSibling
            la ID cua element 1. Cu tiep tuc nhu vay den khi ko tim duoc nua.
            Neu ko tim duoc, thi duyet tu ID element dang xet nguoc ve dau cay, tim element co firstChild
            la ID element dang xet. Element do chinh la parent cua element ban dau.
             */

            int i = this.id;
            int currentSiblingId = i;
            while (i != -1) {
                currentSiblingId = i;
                i = a.get(i).getPreviousSibling();
            }

            // Khi nay, currentSiblingId la ID cua sibling truong.
            int j = currentSiblingId;
            while (j >= 0 && a.get(j).firstChildId != currentSiblingId) {
                j--;
            }
            return j;
        }

        private int getPreviousSibling() {
            int i = this.id;
            while (i >= 0 && a.get(i).nextSiblingId != this.id) {
                i--;
            }
            return i; // return -1 neu ko co element nao nhan element dang xet la nextSibling.
        }
    }
}