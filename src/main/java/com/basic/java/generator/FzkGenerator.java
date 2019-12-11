package com.basic.java.generator;

import com.basic.java.util.DateUtils;
import com.basic.java.util.JDBCUtil;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.zip.ZipOutputStream;

/**
 * @author luotao
 * @Title: FzkGenerator
 * @ProjectName ms-external
 * @Description: TODO 代码生成器
 * @date 2019/7/22 16:51
 */
public class FzkGenerator {

    private final static String jdbcUrl = "jdbc:mysql://192.168.6.160:3306/db_third_service?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai";
    private final static String username = "root";
    private final static String password = "fastgo123";
    private final static String drive = "com.mysql.jdbc.Driver";
    private final static String TABLE_NAME = "tb_weizhang";
    private final static String TABLE_COMMENT = "违章记录";
    private final static String FILE_PATH = "E:\\generator";

    public static void main(String[] args){

        //查询出数据库字段
        //根据模板生成代码
        String filePath = FILE_PATH+"\\"+ TABLE_NAME+"_"+ DateUtils.format(new Date(),DateUtils.DATE_PATTERN)+".zip";
        File file = new File(filePath);
        FileOutputStream outputStream = null;
        try {
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }else{
                file.delete();
                file.createNewFile();
            }
            outputStream = new FileOutputStream(file);
            ZipOutputStream zip = new ZipOutputStream(outputStream);

            //查询表信息
            Map<String, String> table = new HashMap<>();
            table.put("tableName",TABLE_NAME);
            table.put("tableComment",TABLE_COMMENT);
            //查询列信息
            List<Map<String, String>> columns = queryColumns(TABLE_NAME);
            //生成代码
            GenUtils.generatorCode(table, columns, zip);
            zip.flush();
            IOUtils.closeQuietly(zip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static List<Map<String, String>> queryColumns(String tableName) {
        List<Map<String, String>> colums = new ArrayList<>();
        JDBCUtil jdbcUtil = new JDBCUtil(jdbcUrl,username,password,drive);
        try {
            String sql = "select column_name columnName, data_type dataType, column_comment columnComment, column_key columnKey, extra from information_schema.columns\n" +
                    " \t\t\twhere table_name = '"+tableName+"' and table_schema = (select database()) order by ordinal_position";
            Statement statement = jdbcUtil.getConn().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                Map<String, String> colum = new HashMap<>();
                colum.put("columnName",rs.getString("columnName"));
                colum.put("dataType",rs.getString("dataType"));
                colum.put("columnComment",rs.getString("columnComment"));
                colum.put("columnKey",rs.getString("columnKey"));
                colum.put("extra",rs.getString("extra"));
                colums.add(colum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colums;
    }
}
