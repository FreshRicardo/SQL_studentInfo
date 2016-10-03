package com.Ricardo.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.Ricardo.Dao.StudentDao;
import com.Ricardo.model.Student;

public class TestAction {
	
	public static void main(String[] args) throws Exception{
		StudentDao sd= new StudentDao();
		
		/*Student s = new Student();
		//test for addStudents
		s.setAge(35);
		s.setId(200094039);
		s.setName("yuchao");
		s.setProfession("computer");
		
		sd.addStudents(s);
		*/
		
		//test for query
		/*List<Student> result = sd.query("li","com");
		
		for( int i = 0 ; i < result.size(); i ++){
			System.out.println(result.get(i).getId()+"  "+result.get(i).getName());
		}
		*/
		List<Map<String, Object>> params=new ArrayList<Map<String,Object>>();
		
		Map<String, Object> map=new HashMap<String, Object>();
		
			map.put("name", "name");
			map.put("rela", "=");
			map.put("value", "'liurui'");
	}
}
