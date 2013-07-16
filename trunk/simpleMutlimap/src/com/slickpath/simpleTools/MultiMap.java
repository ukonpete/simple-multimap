/**
 * 
 */
package com.slickpath.simpleTools;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;

/**
 * @author Procopio
 *
 */
public class MultiMap<K, V>{

	private final HashMap<K, HashMap<K, V>> internalMap = new HashMap<K, HashMap<K, V>>();

	public MultiMap()
	{
	}

	public void add(final K primaryKey, final K secondaryKey, final V newObj)
	{
		put(primaryKey, secondaryKey, newObj);
	}

	public void put(final K primaryKey, final K secondaryKey, final V newObj)
	{
		HashMap<K, V> hmValues = internalMap.get(primaryKey);
		if ( hmValues != null )
		{
			hmValues.put(secondaryKey, newObj);
		}
		else
		{
			hmValues = new HashMap<K,V>();
			hmValues.put(secondaryKey, newObj);
			internalMap.put(primaryKey, hmValues);
		}
	}

	public Object get(final Object primaryKey, final Object secondaryKey)
	{
		Object retObj = null;

		final HashMap<K, V> keyHashMap = internalMap.get(primaryKey);
		if ( keyHashMap != null )
		{
			retObj = keyHashMap.get(secondaryKey);
		}

		return retObj;
	}

	public Object get(final MultiMapKey key)
	{
		Object retObject = null;

		if ( key != null )
		{
			if ( !key.areKeysNull() )
			{
				retObject = get(key.primaryKey,key.secondaryKey);
			}
		}

		return retObject;
	}


	public HashMap<K,V> getAllByPrimaryKey(final Object primaryKey)
	{
		final HashMap<K, V> hmValues = internalMap.get(primaryKey);
		return hmValues;
	}

	public Vector<V> getAllValues()
	{
		final Vector<V> retVector = new Vector<V>();

		final Collection<HashMap<K, V>> col = internalMap.values();
		final Iterator<HashMap<K, V>> it = col.iterator();

		while (it.hasNext())
		{
			final HashMap<K, V> keyHashMap = it.next();
			retVector.addAll(keyHashMap.values());
		}
		return retVector;
	}

	public Iterator<V> iterator()
	{
		final Collection<HashMap<K, V>> primaryValues = internalMap.values();
		final Vector<V> vValues = new Vector<V>();


		final Iterator<HashMap<K, V>> primaryIterator = primaryValues.iterator();
		{
			while ( primaryIterator.hasNext() )
			{
				final HashMap<K, V> hashMapOfValues = primaryIterator.next();
				vValues.addAll(hashMapOfValues.values());
			}
		}
		return vValues.iterator();
	}


	public Collection<V> values()
	{
		final Collection<HashMap<K, V>> primaryValues = internalMap.values();
		final Vector<V> vValues = new Vector<V>();

		final Iterator<HashMap<K, V>> primaryIterator = primaryValues.iterator();
		{
			while ( primaryIterator.hasNext() )
			{
				final HashMap<K,V> hashMapOfValues = primaryIterator.next();
				vValues.addAll(hashMapOfValues.values());
			}
		}
		return vValues;
	}


	public Set<MultiMapEntry> entrySet()
	{
		final HashSet<MultiMapEntry> retHashSet = new HashSet<MultiMapEntry>();

		final Set<Entry<K, HashMap<K, V>>>  primarySet = internalMap.entrySet();

		final Iterator<Map.Entry<K,HashMap<K,V>>> primaryIterator = primarySet.iterator();
		while ( primaryIterator.hasNext() )
		{
			final Entry<K, HashMap<K, V>> tempPrimaryEntry = primaryIterator.next();
			final Object primaryKey = tempPrimaryEntry.getKey();
			final HashMap<K, V> hmSecondary = tempPrimaryEntry.getValue();

			final Set<Entry<K, V>> secondarySet = hmSecondary.entrySet();
			final Iterator<Entry<K, V>> secondaryIterator = secondarySet.iterator();
			while ( secondaryIterator.hasNext() )
			{
				final Entry<K, V> tempSecondaryEntry = secondaryIterator.next();
				final Object secondaryKey = tempSecondaryEntry.getKey();
				final MultiMapKey tempKey = new MultiMapKey(primaryKey,secondaryKey);
				final Object val = tempSecondaryEntry.getValue();
				final MultiMapEntry entry = new MultiMapEntry(tempKey,val);
				retHashSet.add(entry);
			}
		}
		return retHashSet;
	}

	public Set<MultiMapKey> keys()
	{
		final HashSet<MultiMapKey> retHashSet = new HashSet<MultiMapKey>();

		final Set<Entry<K, HashMap<K, V>>> primarySet = internalMap.entrySet();

		final Iterator<Entry<K, HashMap<K, V>>> primaryIterator = primarySet.iterator();
		while ( primaryIterator.hasNext() )
		{
			final Entry<K, HashMap<K, V>> tempPrimaryEntry = primaryIterator.next();
			final Object primaryKey = tempPrimaryEntry.getKey();
			final HashMap<K, V> hmSecondary = tempPrimaryEntry.getValue();

			final Set<Entry<K, V>> secondarySet = hmSecondary.entrySet();
			final Iterator<Entry<K, V>> secondaryIterator = secondarySet.iterator();
			while ( secondaryIterator.hasNext() )
			{
				final Entry<K, V> tempSecondaryEntry = secondaryIterator.next();
				final Object secondaryKey = tempSecondaryEntry.getKey();
				final MultiMapKey tempKey = new MultiMapKey(primaryKey,secondaryKey);
				retHashSet.add(tempKey);
			}
		}
		return retHashSet;
	}

	public void removeAllPrimaries(final K primaryKey)
	{
		final Collection<HashMap<K, V>> col = internalMap.values();
		final Iterator<HashMap<K, V>> it = col.iterator();

		while (it.hasNext())
		{
			final HashMap<K, V> hmValues = it.next();
			hmValues.remove(primaryKey);
		}
	}

	public boolean remove(final K primaryKey, final K secondaryKey)
	{
		final HashMap<K, V> hmValues = internalMap.get(primaryKey);
		if ( hmValues != null )
		{
			hmValues.remove(secondaryKey);
			return true;
		}
		return false;
	}


	public int size()
	{
		return getAllValues().size();
	}

	public boolean Contains(final Object value)
	{
		boolean bContains = false;
		final Vector<V> vAll = getAllValues();
		bContains = vAll.contains(value);
		return bContains;
	}

	public class MultiMapKey
	{
		public Object primaryKey = null;
		public Object secondaryKey = null;

		public MultiMapKey(final Object primary_Key, final Object secondary_Key)
		{
			primaryKey = primary_Key;
			secondaryKey = secondary_Key;
		}

		public Object getPrimaryKey()
		{
			return primaryKey;
		}

		public Object getSecondaryKey()
		{
			return secondaryKey;
		}

		public boolean areKeysNull()
		{
			return ( (primaryKey == null) || (secondaryKey == null));
		}
	}

	public class MultiMapEntry
	{
		private Object _value = null;;
		private MultiMapKey _key = null;

		public MultiMapEntry(final MultiMapKey key, final Object value)
		{
			_key = key;
			_value = value;
		}

		public Object getValue() {
			return _value;
		}

		public void setValue(final Object value) {
			this._value = value;
		}

		public MultiMapKey getKey() {
			return _key;
		}

		public void setKey(final MultiMapKey key) {
			this._key = key;
		}
	}
}