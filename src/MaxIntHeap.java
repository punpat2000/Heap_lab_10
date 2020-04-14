
public class MaxIntHeap extends Heap{
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
