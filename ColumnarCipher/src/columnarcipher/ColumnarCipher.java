/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package columnarcipher;

import java.util.Scanner;
import java.util.Arrays;
import java.util.*;

/**
 *
 * @author MY
 */
public class ColumnarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in =new Scanner(System.in);
        
//        convert everything in capital
        
        String PT=in.nextLine().toUpperCase();
        String key=in.nextLine().toUpperCase();
        int rows=(int) Math.ceil(PT.length()/key.length());
        int colmns=key.length();
        char[][] temp=new char[rows][colmns];
        for (int i = 0,k=0; i < rows; i++) {
            for (int j = 0; j < colmns; j++) {
                temp[i][j]=PT.charAt(k++);
            }
        }
        
        
//        colmns

        int[] keySort=new int[colmns];
        for (int i = 0; i < colmns; i++) {
            keySort[i]=((int)key.charAt(i))-64;
        }
        
        String encText="";
        ArrayList list=new ArrayList();
        list.add(keySort);
        
        for (int i = 0; i < keySort.length; i++) {
            int minIndex=getMinIndex(list);
            for (int j = 0; j < rows; j++) {
                encText+=temp[j][minIndex];
            }
            list.remove(minIndex);
            
        }
        
        System.out.println(encText);
        
    }
    
    private static int getMinIndex(ArrayList keySort){
        
        int min=(int)keySort.get(0);int minIndex=0;
        for (int i = 0; i < keySort.size(); i++) {
            if((int)keySort.get(i)<=min){
                minIndex=i;
                min=(int)keySort.get(i);
            }
        }
        
        return minIndex;
    }

    
}
