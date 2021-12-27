package com.sequoia.shorturl;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:  mysql 表结构转excel表格 https://www.cnblogs.com/suiyueqiannian/p/7488713.html
 * @Author: jzq
 * @Create: 2021/12/24
 */
public class TableToExcelTest {

    private String tableName = "";//表名
    private String[] colNames; // 列名数组
    private String[] colComment; // 列名数组
    private String[] colTypes; //列名类型数组
    private int[] colSizes; //列名大小数组
    //数据库连接
    private static final String URL ="jdbc:mysql://127.0.0.1:3306/radar?useUnicode=true&characterEncoding=UTF-8";
    private static final String NAME = "root";
    private static final String PASS = "123456";
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";

    public void genEntitySomeTable(List<String> tableNames){
        for(int p=0;p<tableNames.size();p++){
            tableName=tableNames.get(p);
            //创建连接
            Connection con = null;
            //查要生成实体类的表
            String sql = "select * from " + tableName;
            String sql2 = "show full fields from " + tableName;
            PreparedStatement pStemt = null;
            PreparedStatement pStemt2 = null;
            try {
                try {
                    Class.forName(DRIVER);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
                con = DriverManager.getConnection(URL,NAME,PASS);
                pStemt = con.prepareStatement(sql);
                ResultSetMetaData rsmd = pStemt.getMetaData();
                pStemt2 = con.prepareStatement(sql2);
                ResultSet rsResultSet=pStemt2.executeQuery();
                int size = rsmd.getColumnCount();    //统计列
                colNames = new String[size];
                colTypes = new String[size];
                colSizes = new int[size];
                colComment = new String[size];
                int j=0;
                while (rsResultSet.next()) {
                    //System.out.println(rsResultSet.getObject(9));
                    colComment[j]=rsResultSet.getObject(9).toString();
                    j++;
                }
                for (int i = 0; i < size; i++) {
                    colNames[i] = rsmd.getColumnName(i + 1);
                    colTypes[i] = rsmd.getColumnTypeName(i + 1);
                    if (colTypes[i] .equals("INT")){
                        colTypes[i] = "INTEGER";
                    }
                    colSizes[i] = rsmd.getColumnDisplaySize(i + 1);
                }

                createExcel();

            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                try {
                    if (con != null){
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("生成完毕！");
    }


    public void createExcel() throws Exception{
        //获取Excel模版文件目录
        String path = "D:/template.xlsx";
        path = path.replaceAll("%20", " ");
        try(InputStream fileInputStream = new FileInputStream(path);
            //通过Excel模板目录获取Excel模版文件
            XSSFWorkbook workbook1 = new XSSFWorkbook(OPCPackage.open(fileInputStream));
            //利用POI3.8及其以上，每个Sheet可以存1,048,576行数据，每行可以有16,384列数据
            Workbook workbook = new SXSSFWorkbook(workbook1, 100)){
            //重命名sheet工作表名称：第几个工作表
            workbook.setSheetName(0, tableName);
            //创建sheet工作表
            SXSSFSheet sheet = (SXSSFSheet) workbook.getSheetAt(0);
            //从模板sheet工作表第几行开始插入（注意行、列、单元格都是从0开始数）
            int startRow = 1;
            for (int i = 0;i<colSizes.length;i++){
                Row row = sheet.createRow(startRow++);
                row.createCell(1).setCellValue(colNames[i]);
                row.createCell(2).setCellValue(colTypes[i] + "(" + colSizes[i] + ")");
                row.createCell(3).setCellValue(colComment[i]);
            }
            try(ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                workbook.write(outputStream);
                //输出目录
                String filePath = "D:/" + tableName + ".xlsx";
                File file = new File(filePath);
                try(FileOutputStream fileOutputStream = new FileOutputStream(file);
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(outputStream.toByteArray())) {
                    byte[] bytes = new byte[1024];
                    int len;
                    while ((len = byteArrayInputStream.read(bytes)) != -1){
                        fileOutputStream.write(bytes,0,len);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        TableToExcelTest tableToExcel = new TableToExcelTest();
        List<String> dataList = new ArrayList<>();
        // 添加表名
        dataList.add("engine_abstraction");
        tableToExcel.genEntitySomeTable(dataList);
    }

}