package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

		@Entity
		@Table(name= "ROLE")
		public class Role implements Serializable {
			private static final long serialVersionUID = 1L;
			@Id
			@GeneratedValue (strategy= GenerationType.IDENTITY)
			private long id_Role;
			
			private String role_name;
			private String role_desc;
			public long getId_Role() {
				return id_Role;
			}
			public void setId_Role(long id_Role) {
				this.id_Role = id_Role;
			}
			public String getRole_name() {
				return role_name;
			}
			public void setRole_name(String role_name) {
				this.role_name = role_name;
			}
			public String getRole_desc() {
				return role_desc;
			}
			public void setRole_desc(String role_desc) {
				this.role_desc = role_desc;
			}
			public static long getSerialversionuid() {
				return serialVersionUID;
			}
			@Override
			public String toString() {
				return "Role [id_Role=" + id_Role + ", role_name=" + role_name + ", role_desc=" + role_desc + "]";
			}
			public Role(long id_Role, String role_name, String role_desc) {
				super();
				this.id_Role = id_Role;
				this.role_name = role_name;
				this.role_desc = role_desc;
			}
			public Role() {
				super();
				// TODO Auto-generated constructor stub
			}
			public Role(Role r){
				this.role_name = r.role_name;
				this.role_desc = r.role_desc;
			}
		
	

}
