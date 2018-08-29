package model;

import java.sql.Date;

public class HospitalMemberDTO {
   private String mem_flag;
   private String mem_name;
   private String mem_gender;
   private String mem_age;
   private String mem_id;
   private String mem_pass;
   private String mem_dis;
    
   private String tel;
   private String mobile;
   private String zipcode;
   private String addr1;
   private String addr2;
   private String email;

   public HospitalMemberDTO() {}

   public HospitalMemberDTO(String mem_flag, String mem_name, String mem_gender, String mem_age, String mem_id,
		String mem_pass, String mem_dis, String tel, String mobile, String zipcode, String addr1, String addr2,
		String email) {
	
	this.mem_flag = mem_flag;
	this.mem_name = mem_name;
	this.mem_gender = mem_gender;
	this.mem_age = mem_age;
	this.mem_id = mem_id;
	this.mem_pass = mem_pass;
	this.mem_dis = mem_dis;
	this.tel = tel;
	this.mobile = mobile;
	this.zipcode = zipcode;
	this.addr1 = addr1;
	this.addr2 = addr2;
	this.email = email;
   }





public String getMem_flag() {
      return mem_flag;
   }

   public void setMem_flag(String mem_flag) {
      this.mem_flag = mem_flag;
   }

   public String getMem_name() {
      return mem_name;
   }

   public void setMem_name(String mem_name) {
      this.mem_name = mem_name;
   }

   public String getMem_gender() {
      return mem_gender;
   }

   public void setMem_gender(String mem_gender) {
      this.mem_gender = mem_gender;
   }

   public String getMem_age() {
      return mem_age;
   }

   public void setMem_age(String mem_age) {
      this.mem_age = mem_age;
   }

   public String getMem_id() {
      return mem_id;
   }

   public void setMem_id(String mem_id) {
      this.mem_id = mem_id;
   }

   public String getMem_pass() {
      return mem_pass;
   }

   public void setMem_pass(String mem_pass) {
      this.mem_pass = mem_pass;
   }

   public String getMem_dis() {
      return mem_dis;
   }

   public void setMem_dis(String mem_dis) {
      this.mem_dis = mem_dis;
   }

   public String getTel() {
      return tel;
   }

   public void setTel(String tel) {
      this.tel = tel;
   }

   public String getMobile() {
      return mobile;
   }

   public void setMobile(String mobile) {
      this.mobile = mobile;
   }

   public String getZipcode() {
      return zipcode;
   }

   public void setZipcode(String zipcode) {
      this.zipcode = zipcode;
   }

   public String getAddr1() {
      return addr1;
   }

   public void setAddr1(String addr1) {
      this.addr1 = addr1;
   }

   public String getAddr2() {
      return addr2;
   }

   public void setAddr2(String addr2) {
      this.addr2 = addr2;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

	  
 
}