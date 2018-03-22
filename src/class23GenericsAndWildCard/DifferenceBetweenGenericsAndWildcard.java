package class23GenericsAndWildCard;

import java.util.Collection;
import java.util.List;
class E {
	
}
class Number {
	
}
public abstract class DifferenceBetweenGenericsAndWildcard {
	// cases when Generics and Wildcard do the same job
	public abstract <T> boolean containsAll2(Collection<T> c);
	public abstract boolean containsAll1(Collection<?> c);
	 
	public abstract <T extends E> boolean addAll2(Collection<T> c);
	public abstract boolean addAll1(Collection<? extends E> c);
	

	// cases when  Generics and Wildcard do the different job
	// because Wildcard cannot restrict the type in src and desc are the same
	// while Generics can restrict that type in the two lists are the same
	public abstract <T extends Number> void copy1(List<T> src, List<T> desc);
	public abstract void copy(List<? extends Number> src, List<? extends Number> desc);
	
	
	// one example to demonstrate that wild card cannot guarantee the type of captured object
	// the code cannot be complied because the object which list.remove(0) may not be the same type
	// for add()
	// so usually wildcard is used to read not to write
//	public static boolean fun(List<?> list) {
//		return list.add(list.remove(0)); 
//	}
}
