package cefalo.school.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by proshad on 11/23/16.
 */
public class OperationReceiver {
    protected List<String> stringList = new ArrayList<String>();

    public void add(String name) {
        stringList.add(name);
        System.out.println("After adding current items are: "+this.toString());
    }

    public void update(int position, String newName) {
        if (stringList.size() > position) {
            System.out.println("Before updating: "+this.toString());
            stringList.set(position, newName);
            System.out.println("After updating: "+this.toString());
        }else {
            System.out.println("Sorry, cannot update item from this position");
        }
    }

    public String delete() {
        int length = stringList.size();
        if (length > 0) {
            System.out.println("Before deleting current items are: "+this.toString());
            return stringList.remove(length-1);
        }else {
            System.out.println("Sorry, cannot delete item from this position");
            return null;
        }
    }

    public String read(int position) {
        if (stringList.size() > position) {
            System.out.println("Reading from index # "+position+" value # "+stringList.get(position));
            return stringList.get(position);
        }
        System.out.println("Sorry, there is no item in position "+position);
        return null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(stringList);
        return sb.toString();
    }

}
