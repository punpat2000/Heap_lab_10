
import java.util.Random;

public class MaxIntHeap extends Heap{
	
	public static void main(String[] args) throws Exception {
		int[] x = new int[1000000]; //100, 10000, 1000000
		for (int i = 0; i < x.length; x[i++] = new Random().nextInt());
		
		long startTime = System.nanoTime();
		Heap h = new MaxIntHeap();
		for (int i = 0; i < x.length; h.add(x[i++]));
		long endTime = System.nanoTime();
		System.out.println("Add time: " + (endTime - startTime));
		
		startTime = System.nanoTime();
		while (!h.isEmpty())
			h.pop();
		endTime = System.nanoTime();
		System.out.println("Pop time: " + (endTime - startTime));
		
	}
	
	@Override
	public void add(Object element) {
		// Add your code here
		super.add(element);
	}
	@Override
	public Object pop() throws Exception {
		// Add your code here
		return super.pop();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void percolateUp() {
		int parent;
		int child = size - 1;
		Comparable temp;
		while (child > 0) {
			parent = (child - 1) / 2;
			if (((Comparable) mData[parent]).compareTo(mData[child]) > 0)
				break;
			temp = (Comparable) mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	protected void percolateDown(int start) {
		int parent = start;
		int child = 2 * parent + 1;
		Object temp;
		while (child < size) {
			if (child < size - 1
					&& ((Comparable) mData[child]).compareTo(mData[child + 1]) <= 0)
				child++;
			if (((Comparable) mData[parent]).compareTo(mData[child]) > 0)
				break;
			temp = mData[child];
			mData[child] = mData[parent];
			mData[parent] = temp;
			parent = child;
			child = 2 * parent + 1;
		}
	}
}
