/**
 * 
 */
package graphs;

import java.util.Iterator;

import org.junit.Assert;

/**
 * @author alexey
 *
 */
public class AssertGraph {

	public static <V> void assertEquals(Iterable<V> iter1, Iterable<V> iter2){
		Iterator<V> iterator = iter2.iterator();
		for (V v : iter1) {
			if(!iterator.hasNext()){
				Assert.fail("Iterables have different lenght thus not the same");
			}
			V w = iterator.next();
			Assert.assertEquals(v, w);
		}
	}

}
