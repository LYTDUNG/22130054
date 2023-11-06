package Lab7_Set.set_student;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class MyPredicates {
	// Remove every object, obj, from coll for which
	// pr.test(obj) is false. (That is, retain the
	// objects for which the predicate is true.)
	public static <T> void retain(Collection<T> coll, Predicate<T> p) {
		// You can use the negate method to create a new predicate that is the opposite
		// of p
		// Then you can use the remove method with the negated predicate
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (p.test(next)) {
				iter.remove();
			}
		}
	}

	// Return a Set that contains all unique objects, obj,
	// from the collection, coll, such that p.test(obj)
	// is true.
	public static <T> Set<T> collect(Collection<T> coll, Predicate<T> p) {
		// TODO
		// You can use a HashSet to store the unique objects that satisfy the predicate
		// Then you can use a for-each loop to iterate over the collection and add the
		// objects to the set
		Set<T> result = new HashSet<>();
		for (T obj : coll) {
			if (p.test(obj)) {
				result.add(obj);
			}
		}
		return result;
	}

	// Return the index of the first item in list
	// for which the predicate is true, if any.
	// If there is no such item, return -1.
	public static <T> int find(Collection<T> coll, Predicate<T> p) {
		// TODO
		// You can use a counter variable to keep track of the index of the current item
		// Then you can use an iterator to loop over the collection and check the
		// predicate
		// If the predicate is true, return the counter value
		// If the iterator reaches the end, return -1
		int index = 0;
		Iterator<T> iter = coll.iterator();
		while (iter.hasNext()) {
			T next = iter.next();
			if (p.test(next)) {
				return index;
			}
			index++;
		}
		return -1;
	}
}