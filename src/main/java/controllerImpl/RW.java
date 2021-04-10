package controllerImpl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import com.google.gson.Gson;

public class RW<X> {
	
	
	public void write(Set<X> set, String pathname) {
		Gson gson = new Gson();
		try(FileWriter writer = new FileWriter(pathname)){
			gson.toJson(set, writer);
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	public Set<X> read(Type type,String pathname){
		Gson gson = new Gson();
		Set<X> set = new HashSet<>();
		final Type typeSet = type;
		
		try (Reader reader = new FileReader(pathname)){
			set=gson.fromJson(reader, typeSet);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return set;
	
		
		
		
	}
}
