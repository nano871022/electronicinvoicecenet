package co.com.japl.facturacionelectronica.util;
import java.util.Map;
import java.util.HashMap;

public class Cache{
	private Map<String,Object> cache;
	private static Cache instance;

	private Cache(){
		cache = new HashMap<String,Object>();
	}

	public static Cache instance(){
		if(instance == null){
			instance = new Cache();
		}
		return instance;
	}

	public <O> void add(String key,O value){
		cache.put(key,value);
	}

	public <O> O get(String key){
		return (O)cache.get(key);
	}

	public Boolean exists(String key){
		return cache.containsKey(key);
	}

	public void remove(String key){
		cache.remove(key);
	}
}