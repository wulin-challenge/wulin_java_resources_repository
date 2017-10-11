package com.bjhy.titan.broker.jms.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 文件压缩工具
 * @author Administrator
 *
 */
public class ZipFileUtil {
	/**
	 * 解压文件
	 * @param zipFile
	 * 			解压文件对象
	 * @param descDir
	 * 			解压到的目录
	 * @throws Exception
	 */
	public static void unZipFile(File zipFile,String descDir)throws Exception{  
		int len = -1;
        File pathFile = new File(descDir);
        if(!pathFile.exists())pathFile.mkdirs();
        ZipFile zip = new ZipFile(zipFile, "UTF-8");
        for(Enumeration<ZipEntry> entries = zip.getEntries();entries.hasMoreElements();){
            ZipEntry entry = (ZipEntry)entries.nextElement();
            String zipEntryName = entry.getName();
            InputStream in = zip.getInputStream(entry);
            String outPath = (descDir +"/"+ zipEntryName).replaceAll("\\*", "/");
            //判断路径是否存在,不存在则创建文件路径
        	File file = new File(outPath.substring(0, outPath.lastIndexOf('/')));
            if(!file.exists())file.mkdirs();
            //判断文件全路径是否为文件夹,如果是上面已经创建,不需要解压
            if(new File(outPath).isDirectory())continue;
            OutputStream out = new FileOutputStream(outPath);
            byte[] buf = new byte[1024];
            while((len=in.read(buf))>0){
                out.write(buf, 0, len);
            }
            in.close();
            out.close();
        }
    }
	
	
    public static void writeZip(String[] strs,String zipPath,String zipName) throws IOException {
        String[] files = strs;
        OutputStream os = new BufferedOutputStream( 
        		new FileOutputStream( zipPath + zipName + ".zip" ) );
        ZipOutputStream zos = new ZipOutputStream( os );
        zos.setEncoding("UTF-8");
        byte[] buf = new byte[8192];
        int len;
        for (int i=0;i<files.length;i++) {  
            File file = new File( files[i] );
            if ( !file.isFile() ) continue;
            ZipEntry ze = new ZipEntry( file.getName() );
            zos.putNextEntry( ze );
            BufferedInputStream bis = new BufferedInputStream( new FileInputStream( file ) );
            while ( ( len = bis.read( buf ) ) > 0 ) {
                zos.write( buf, 0, len );
            }
            zos.closeEntry();
        }
        
//        zos.closeEntry();
        zos.close();
        
        for(int i=0;i<files.length;i++){
        	File file = new File(files[i] );
        	file.delete();
        }
    }
    
    /**
     * 功能:压缩多个文件成一个zip文件
     * <p>作者 许亚东
     * @param strs：源文件列表,绝对路径
     * @param zipPath：压缩后的路径
     * @param zipName：压缩后的名字
     */
    public static File zipFiles(String[] strs,String zipPath,String zipName){
        byte[] buf=new byte[1024];
        try {
            //ZipOutputStream类：完成文件或文件夹的压缩
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath + zipName + ".zip"));
            out.setEncoding("UTF-8");
            for(int i=0;i<strs.length;i++){
            	File file = new File( strs[i] );
                FileInputStream in = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while((len=in.read(buf))>0){
                    out.write(buf,0,len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
           return  new File(zipPath + zipName + ".zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    /**
     * 功能:压缩多个文件成一个zip文件
     * @param files
     * @param zipPath
     * @param zipName
     */
    public static File zipFiles(File[] files,String zipPath,String zipName){
        byte[] buf=new byte[1024];
        try {
            //ZipOutputStream类：完成文件或文件夹的压缩
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipPath + zipName + ".zip"));
            out.setEncoding("UTF-8");
            for(int i=0;i<files.length;i++){
            	File file = files[i];
                FileInputStream in = new FileInputStream(file);
                out.putNextEntry(new ZipEntry(file.getName()));
                int len;
                while((len=in.read(buf))>0){
                    out.write(buf,0,len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
            return  new File(zipPath + zipName + ".zip");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
	
	
	public static void main( String[] args ) {
        try {
         String[] strs = new String[5];
         strs[0]="D:/com/电风扇.xlsx";
         strs[1]="D:/com/3.txt";
         strs[2]="D:/com/1.txt";
         strs[3]="D:/com/2.txt";
         strs[4]="D:/com/2.zip";
         ZipFileUtil zipUtil = new ZipFileUtil();
         //文件的列表 和 将要打成的zip文件的名称
         zipUtil.zipFiles(strs,"D:/com/","许亚东1");
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
    
}
