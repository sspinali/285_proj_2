import java.util.*;
import java.lang.*;
import java.io.*;

public class HashTable {

    public static void main(String[] args)
    {
        HashTable ht = new HashTable(13);
        ht.Insert(33);
        ht.Insert(353);
        ht.Insert(95);

        System.out.println(ht.getItemCount());
        if (ht.entryExist(353));
        {
            System.out.println("YES");
        }

    }

    private LinkedList[] mainTable;
    private int itemCount;

    public HashTable(LinkedList[] hTable)
    {
        mainTable = hTable;
        itemCount = 0;
    }

    public HashTable(int size)
    {
        mainTable = new LinkedList[size];
        itemCount = 0;
    }

    public void Insert(Integer input)
    {
        if(mainTable[(input % mainTable.length)] == null)
        {
            mainTable[(input%mainTable.length)] = new LinkedList();
            mainTable[(input%mainTable.length)].ListInsert(input);
            itemCount++;
        }
        else
        {
            mainTable[(input%mainTable.length)].ListInsert(input);
        }
    }

    public int getItemCount()
    {
        return itemCount;
    }

    public int getTableLength()
    {
        return mainTable.length;
    }

    public boolean entryExist(Integer input)
    {
        LinkedList temp = mainTable[(input%mainTable.length)];
        if(temp == null)
        {
            return false;
        }

        else
        {
            if(temp.ContainsCode(input))
            {
                return true;
            }

            else
            {
                return false;
            }
        }
    }

    public HashTable Rehash(int newSize)
    {
        LinkedList[] newTable = new LinkedList[newSize];
        int tableIndex = 0;
        int lengthLinkedList = 0;
        for(int i = 0; i < mainTable.length ; i++)
        {
            lengthLinkedList = mainTable[i].ListLength();
            if(lengthLinkedList>=1)
            {
                for(int j = 1; j <= lengthLinkedList; j++)
                {
                    Integer newInsert = (int)mainTable[i].RetrieveCodeAt(j);
                    if(newTable[(newInsert)%(newTable.length)] == null)
                    {
                        newTable[(newInsert)%(newTable.length)] = new LinkedList();
                        newTable[(newInsert)%(newTable.length)].ListInsert(newInsert);
                    }
                    else
                    {
                        newTable[(newInsert)%(newTable.length)].ListInsert(newInsert);
                    }
                }
            }
        }
        HashTable cleanTable = new HashTable(newTable);
        return cleanTable;
    }

}
