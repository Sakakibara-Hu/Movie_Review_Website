package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

	public abstract class JDBCTemplates<T> {

		public  T selectOne(String sql, Object[] params) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			
			try {
				con =JDBCUtils.Getconnection();
				ps = con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
				rs = ps.executeQuery();
				T t = null;
				while (rs.next()) {
					t = rowMapper(rs);
				}
				return t;
			} catch(Exception e) {
			     
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return null;
		}
public  T selectOne(String sql) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			
			try {
				con =JDBCUtils.Getconnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				T t = null;
				while (rs.next()) {
					t = rowMapper(rs);
				}
				return t;
			} catch(Exception e) {
			     
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return null;
		}
		public List<T> selectAll(String sql, Object[] params) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			
			try {
				con = JDBCUtils.Getconnection();
				ps = con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
				rs = ps.executeQuery();
				List<T> lists=new ArrayList<T>();
				T t = null;
				while (rs.next()) {
					
					t = rowMapper(rs);
					lists.add(t);
				}
				return lists;
			} catch(Exception e) {
			
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return null;
		}
		  //事务
		public void batchupdate(String sql,String[] param)
		{
			Connection con=null;
			ResultSet rs=null;
			PreparedStatement ps=null;
			
			try {
				con=JDBCUtils.Getconnection();
				con.setAutoCommit(false);
				ps=con.prepareStatement(sql);
				
				for(int i=0;i<param.length;i++){
					ps.setString(1, param[i]);
					ps.addBatch();
				}
				ps.executeBatch();
				con.commit();
			} catch (SQLException e) {
				try {
					con.rollback();
					System.out.println("返回了");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		public List<T> selectByAll(String sql) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			
			try {
				con = JDBCUtils.Getconnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				List<T> lists=new ArrayList<T>();
				T t = null;
				while (rs.next()) {
					t = rowMapper(rs);
					lists.add(t);
				}
				return lists;
			} catch(Exception e) {
			
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return null;
		}
	   public int update(String sql, Object[] params) {
		
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			int j=0;
			try {
				con = JDBCUtils.Getconnection();
				
				ps = con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
				
				j= ps.executeUpdate();
			
			} catch(Exception e) {
			
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return j;
		}
	   public int update(String sql) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			int j=0;
			try {
				con = JDBCUtils.Getconnection();
				
				ps = con.prepareStatement(sql);
				
				j= ps.executeUpdate();
			
			} catch(Exception e) {
			
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return j;
		}
	   public int selectcount(String sql) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			int j=0;
			try {
				con = JDBCUtils.Getconnection();
				
				ps = con.prepareStatement(sql);
				
				j= ps.executeUpdate();
			
			} catch(Exception e) {
			
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return j;
		}
	   public int update1(String sql) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			int j=0;
			try {
				con = JDBCUtils.Getconnection();
				
				ps = con.prepareStatement(sql);
		
				j= ps.executeUpdate();
			
			} catch(Exception e) {
			
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return j;
		}
		public String oneString(String sql, Object[] params) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			
			try {
				con =JDBCUtils.Getconnection();
				ps = con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
				rs = ps.executeQuery();
				
				String t = null;
				while (rs.next()) {
					t=rs.getString(1);
				}
				return t;
			} catch(Exception e) {
			     
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return null;
		}
		public String Stringone(String sql) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			
			try {
				con =JDBCUtils.Getconnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				String t ="";
				while (rs.next()) {
					t =	rs.getString(1);
				}
				return t;
			} catch(Exception e) {
			     
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return null;
		}
		public List<String> onestringlist(String sql, Object[] params) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			
			try {
				con =JDBCUtils.Getconnection();
				ps = con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
				rs = ps.executeQuery();
				
				List<String> lists=new ArrayList<String>();
				String t = null;
				while (rs.next()) {
					t =rs.getString(1);
					lists.add(t);
				}
				return lists;
			} catch(Exception e) {
			
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return null;
		}

		public List<String> onestringlistt(String sql) {
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			
			try {
				con =JDBCUtils.Getconnection();
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				List<String> lists=new ArrayList<String>();
				String t = null;
				while (rs.next()) {
					t =rs.getString(1);
					lists.add(t);
				}
				return lists;
			} catch(Exception e) {
			
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return null;
		}
	public int oneInt(String sql, Object[] params) {
			
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs = null; 
			
			try {
				con =JDBCUtils.Getconnection();
				ps = con.prepareStatement(sql);
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
				rs = ps.executeQuery();
				int t =0;
				while (rs.next()) {
					t=rs.getInt(1);
				}
				return t;
			} catch(Exception e) {
			     
			} finally {
				JDBCUtils.free(con, ps, rs);
			}
			return 0;
		}


	public int intone(String sql) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 
		
		try {
			con =JDBCUtils.Getconnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			int t =0;
			while (rs.next()) {
				t =	rs.getInt(1);
			}
			return t;
		} catch(Exception e) {
		     
		} finally {
			JDBCUtils.free(con, ps, rs);
		}
		return 0;
	}

public List<Integer> intList(String sql,Object[] params) {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null; 
	
	try {
		con =JDBCUtils.Getconnection();
		ps = con.prepareStatement(sql);
		for (int i = 0; i < params.length; i++) {
			ps.setObject(i + 1, params[i]);
		}
		rs = ps.executeQuery();
		List<Integer> lists=new ArrayList<Integer>();
		int t = 0;
		while (rs.next()) {
			t =rs.getInt(1);
			lists.add(t);
		}
		return lists;
	} catch(Exception e) {
	
	} finally {
		JDBCUtils.free(con, ps, rs);
	}
	return null;
	}
		protected abstract T rowMapper(ResultSet rs);
	}


