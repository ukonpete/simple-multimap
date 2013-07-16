package com.slickpath.simpleTools;

public class MutliMap2 {

	public MutliMap2() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * 	public void clear() {
		// TODO Auto-generated method stub
		mMap.clear();
	}


	public boolean containsKey(final K key) {
		return mMap.containsKey(key);
	}


	public boolean containsValue(final V value) {

		for(final Collection<V> collection: mMap.values())
		{
			if(collection.contains(value))
			{
				return true;
			}
		}
		return false;
	}

	 //NOTE: This could be faster... WIll look into
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		final Set<java.util.Map.Entry<K, V>> entrySet = new HashSet<java.util.Map.Entry<K, V>>();
		final Set<K> keys = this.mMap.keySet();

		for(final K key : keys)
		{
			final Collection<V> values = this.mMap.get(key);
			for(final V value: values)
			{
				final Map.Entry<K, V> entry = new Map.Entry<K,V>(){

					@Override
					public K getKey() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public V getValue() {
						// TODO Auto-generated method stub
						return null;
					}

					@Override
					public V setValue(V value) {
						// TODO Auto-generated method stub
						return null;
					}

				};
				entrySet.add(entry);
			}
		}
		return entrySet;
	}

	public Collection<V> get(final K key) {
		return mMap.get(key);
	}


	public boolean isEmpty() {
		return count == 0;
	}


	public Set<K> keySet() {
		return mMap.keySet();
	}


	public V put(final K key, final V value) {
		final Collection<V> collection = getValueCollection(key);
		if(add(collection, value))
		{
			return value;
		}
		return null;
	}

	private boolean add(final Collection<V> collection, final V value)
	{
		final boolean returnVal = collection.add(value);
		if ( returnVal )
		{
			count++;
		}
		return returnVal;
	}

	private Collection<V> getValueCollection(final K key)
	{
		Collection<V> collection = mMap.get(key);
		if ( collection == null )
		{
			collection = new HashSet<V>();
			mMap.put(key, collection);
		}
		return collection;
	}

	public void putAll(final MultiMap<? extends K, ? extends V> multiMap) {
		for(final Entry<? extends K, ? extends V> entry : multiMap.entrySet() )
		{
			this.put(entry.getKey(), entry.getValue());
		}
	}


	public Collection<V> remove(final K key) {
		final Collection<V> collection = mMap.remove(key);
		if ( collection.isEmpty() )
		{
			return null;
		}
		return collection;
	}


	public long size() {
		return count;
	}


	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}
	 */
}
