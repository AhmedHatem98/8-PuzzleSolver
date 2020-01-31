/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puzzlesolver;

import java.util.Comparator;

/**
 *
 * @author Ahmed Hatem
 */
public class PriorityComparator implements Comparator<InformedNode> {

    @Override
    public int compare(InformedNode n1, InformedNode n2) {
        if (n1.getTotalCost() > n2.getTotalCost()) {
            return 1;
        } else if (n1.getTotalCost() < n2.getTotalCost()) {
            return -1;
        }

        return 0;
    }

}
