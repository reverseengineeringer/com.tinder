package com.google.i18n.phonenumbers;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

class RegexCache$LRUCache$1
  extends LinkedHashMap<K, V>
{
  RegexCache$LRUCache$1(d.a parama, int paramInt, float paramFloat, boolean paramBoolean)
  {
    super(paramInt, paramFloat, paramBoolean);
  }
  
  protected boolean removeEldestEntry(Map.Entry<K, V> paramEntry)
  {
    return size() > d.a.a(a);
  }
}

/* Location:
 * Qualified Name:     com.google.i18n.phonenumbers.RegexCache.LRUCache.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */