package Exams;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class Natural implements Supplier<Integer>{
    public int i = 0;
    public Integer get() {
    	return ++i;
    }
    
}
