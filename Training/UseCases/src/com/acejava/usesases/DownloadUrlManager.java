package com.acejava.usesases;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadUrlManager {

	static URL url;
	//static HttpURLConnection urlCon;
	static int sizeForEachThread;
	static String urlString;

	public static void main(String[] args){
		DownloadUrlManager downloadManger = new DownloadUrlManager();
		urlString = "http://luugiathuy.com/2011/03/download-manager-java/";
		
		downloadManger.getSizeForThread(downloadManger.openConnection(urlString));

		Thread t1 = new Thread(downloadManger.new Worker(0,sizeForEachThread,1));
		Thread t2 = new Thread(downloadManger.new Worker(sizeForEachThread,sizeForEachThread+sizeForEachThread,2));
		
		t1.start();
		t2.start();
	}

	public HttpURLConnection openConnection(String urlString){
		HttpURLConnection urlCon = null;
		try {
			url = new URL(urlString);
			urlCon = (HttpURLConnection) url.openConnection();
			urlCon.connect();

			if (urlCon.getResponseCode() / 100 != 2) {
				throw new Error("Could able to connect to URL");
			}

			System.out.println(urlCon.getInputStream().available());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return urlCon;
	}

	public void getSizeForThread(HttpURLConnection urlCon){
		try {
			int size = urlCon.getInputStream().available();
			sizeForEachThread = size/5+1;
			System.out.println(size+" ----  "+sizeForEachThread+"----"+urlCon.getContentLengthLong());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			urlCon.disconnect();
		}
	}
	
	private class Worker implements Runnable{
		int mStartByte;
		int mEndByte;
		int chunkNo;

		public Worker(int mStartByte, int mEndByte, int chunkNo){
			this.mStartByte = mStartByte;
			this.mEndByte = mEndByte;
			this.chunkNo = chunkNo;
		}

		@Override
		public void run() {
			try {
				HttpURLConnection urlCon = openConnection(urlString);
				BufferedInputStream in = new BufferedInputStream(urlCon.getInputStream());
				RandomAccessFile raf = new RandomAccessFile(new File("D:\\java\\kholal\\output\\Download"+chunkNo+".txt"), "rw");
				byte[] data = new byte[4096];
			    int numRead;
				String byteRange = mStartByte + "-" + mEndByte;
				urlCon.setRequestProperty("Range", "bytes=" + byteRange);
				while(((numRead = in.read(data,0,4096)) != -1))
			    {
			      // write to buffer
			      raf.write(data,0,numRead);
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}						
		}
	}
}
