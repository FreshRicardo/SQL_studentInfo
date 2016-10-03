package com.Ricardo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Ricardo.db.DBUtil;
import com.Ricardo.model.Student;
import com.sun.javafx.collections.MappingChange.Map;

	public class StudentDao {
		public void addStudents(Student s) throws Exception{
			Connection con = DBUtil.getConnection();
			String sql = "INSERT INTO student_info"+
						 " VALUES("+
						 "?,?,?,?)";
			
			PreparedStatement ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, s.getId());
			ptmt.setString(2, s.getName());
			ptmt.setInt(3, s.getAge());
			ptmt.setString(4, s.getProfession());
			
			ptmt.execute();
		}
	
		public void updateStudents(Student s) throws Exception{
			Connection con = DBUtil.getConnection();
			String sql = "UPDATE student_info"+
						 " SET name=?,age=?,profession=?"+
						 " WHERE id=?";
			PreparedStatement ptmt = con.prepareStatement(sql);
			
			ptmt.setString(1, s.getName());
			ptmt.setInt(2, s.getAge());
			ptmt.setString(3, s.getProfession());
			ptmt.setInt(4, s.getId());
			
			ptmt.execute();
			
		}
		
		public void delStudent(Integer id) throws Exception{
			Connection con = DBUtil.getConnection();
			String sql = "delete from student_info"+
						 " where id=?";
			PreparedStatement ptmt = con.prepareStatement(sql);
			
			ptmt.setInt(1, id);
			ptmt.execute();
			
		}
		
		public List<Student> query() throws Exception{
			List<Student> result = new ArrayList<Student>();
			
			Connection con = DBUtil.getConnection();
			String sql = "select * from student_info";
			PreparedStatement ptmt = con.prepareStatement(sql);
			
			ResultSet rs = ptmt.executeQuery();
			Student s = null;
			while(rs.next()){
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				s.setProfession(rs.getString("profession"));
				result.add(s);
				
			}
			return result;
			
		}
		
		public List<Student> query(String name,String profession) throws Exception{
			List<Student> result = new ArrayList<Student>();
			
			Connection con = DBUtil.getConnection();
			String sql = "select * from student_info"+
						 " where name like ? and profession like ?";
			PreparedStatement ptmt = con.prepareStatement(sql);
			ptmt.setString(1,"%"+name+"%");
			ptmt.setString(2,"%"+profession+"%" );
			
			ResultSet rs = ptmt.executeQuery(sql);
			
			Student s = null;
			while(rs.next()){
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				s.setProfession(rs.getString("profession"));
				result.add(s);
			}
			return result;
			
		}
		
		public List<Student> query(List<HashMap<String,Object>> param){
			List<Student> result = new ArrayList<Student>();
			
			Connection con = DBUtil.getConnection();
			String sql = "select * from student_info"+
						 " where 1 = 1";
			if(param!=null && param.size()>0){
				for(int i = 0 ;i <param.size(); i ++){
					
				HashMap<String, Object> map=param.get(i);
				sql = sql + " and  "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ";
				}
			}
			PreparedStatement ptmt = con.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery(sql);
			
			Student s = null;
			while(rs.next()){
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAge(rs.getInt("age"));
				s.setProfession(rs.getString("profession"));
				result.add(s);
			}
			return result;

		}
		
		
		
		
		
		
	}
