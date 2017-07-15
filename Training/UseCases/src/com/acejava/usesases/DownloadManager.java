package com.acejava.usesases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DownloadManager {
	  
	    public static void main(String[] args) {

	        URL file = null;
	        ReadableByteChannel rbc = null;
	        try {                       
	            String url = "http://dl1.video.varzesh3.com/video/clip93/12/video/havashi/top5_save_derby_dortmond.mp4";
	            file = new URL(url);
	            rbc = Channels.newChannel(file.openStream());
	            int size = file.openConnection().getContentLength(); 
	            System.out.println("size: "+size);
	            ExecutorService pool = Executors.newFixedThreadPool(4);
	            int partSize = size / 4;
	            System.out.println("partSize: "+partSize);
	            pool.submit(new Downloader(url, 1, 0, partSize, rbc));
	            pool.submit(new Downloader(url, 2, 0, partSize, rbc));
	            pool.submit(new Downloader(url, 3, 0, partSize, rbc));
	            
	            /*pool.submit(new Downloader(url, 2, partSize, 2*partSize, rbc));
	            pool.submit(new Downloader(url, 3, 2 * partSize, 3*partSize, rbc));
	            pool.submit(new Downloader(url, 4, 3 * partSize, size, rbc));   */         
	            pool.shutdown();
	            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
	        } catch (MalformedURLException | InterruptedException ex) {
	            Logger.getLogger(DownloadManager.class.getName()).log(Level.SEVERE, null, ex);
	        } catch (IOException ex) {
	            Logger.getLogger(DownloadManager.class.getName()).log(Level.SEVERE, null, ex);
	        }



	    }

	}

