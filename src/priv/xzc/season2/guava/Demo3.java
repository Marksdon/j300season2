package priv.xzc.season2.guava;

import java.util.Collection;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

/**
 *guava1.8后就com.google.common.collect.Constraint没了
 * 加入约束条件：非空，长度验证
 * @author randall
 *
 */
public class Demo3 {

	public static void main(String[] args) {
		Set<String> sets = Sets.newHashSet();
		//创建约束
		Constraint<String> constraint = new Constraint<String>(){

			@Override
			public String checkElement(String element) {
				//非空验证
				Preconditions.checkNotNull(element);
				//长度验证：5-20
				Preconditions.checkArgument(element.length() >= 5 && element.length() <=20);
				return element;
			}
			
		};
		
		//根据约束包装set
		Set<String> cs = Constraints.constrainedSet(sets, constraint);
		/*cs.add(null);//java.lang.NullPointerException
		cs.add("good");//java.lang.IllegalArgumentException*/	
		cs.add("bjsxt");//加入成功
		System.out.println(cs);
		
		
	}
}

/**
 * 下边类是另外加的
 */

/**
 * 解决guava-18.0.jar不能使用
 * com.google.common.collect.Constraints、
 * com.google.common.collect.Constraint 的问题。
 * @author liguodong
 * @param <E>
 */
interface Constraint<E>{
    //public String checkElement(String element);
    E checkElement(E element);
}

class Constraints<E>{
    public static <E> Set<E> constrainedSet(
              Set<E> set, Constraint<? super E> constraint) {
            return new ConstrainedSet<E>(set, constraint);
          }
     private static <E> Collection<E> checkElements(
              Collection<E> elements, Constraint<? super E> constraint) {
            Collection<E> copy = Lists.newArrayList(elements);
            for (E element : copy) {
              constraint.checkElement(element);
            }
            return copy;
          }
     /** @see Constraints#constrainedSet */
     static class ConstrainedSet<E> extends ForwardingSet<E> {
       private final Set<E> delegate;
       private final Constraint<? super E> constraint;

       public ConstrainedSet(Set<E> delegate, Constraint<? super E> constraint) {
         this.delegate = checkNotNull(delegate);
         this.constraint = checkNotNull(constraint);
       }
       @Override protected Set<E> delegate() {
         return delegate;
       }
       @Override public boolean add(E element) {
         constraint.checkElement(element);
         return delegate.add(element);
       }
       @Override public boolean addAll(Collection<? extends E> elements) {
         return delegate.addAll(checkElements(elements, constraint));
       }
     }
     
     
     /**
      * Ensures that an object reference passed as a parameter to the calling method is not null.
      *
      * @param reference an object reference
      * @return the non-null reference that was validated
      * @throws NullPointerException if {@code reference} is null
      */
     public static <T> T checkNotNull(T reference) {
       if (reference == null) {
         throw new NullPointerException();
       }
       return reference;
     }
     
}


