package com.hs;

import java.util.ArrayList;
import java.util.Iterator;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class Main {
	public static final int version = 1;
	public static final String packPath = "com.hs";
	public static void main(String[] args) {
		Schema schema = new Schema(version, packPath+".bean"); 
		schema.enableKeepSectionsByDefault();
		schema.setDefaultJavaPackageDao(packPath+"dao");
		addNote(schema);
		String path = "C:\\Users\\liuha\\Desktop\\greenDaoTest\\";
		try {
			new DaoGenerator().generateAll(schema, path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
	 private static void addNote(Schema schema) {
	        Entity note = schema.addEntity("Note");
	        //ϵͳ���Զ��Դ���Ĳ�����Ϊ������֣���Ҳ�����Զ��������
	        note.setTableName("NoteTable");
	        note.addIdProperty();
	        note.addStringProperty("text").notNull();
	        note.addStringProperty("comment");
	        note.addDateProperty("date");
	 }
}
