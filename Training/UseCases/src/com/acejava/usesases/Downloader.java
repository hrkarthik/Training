package com.acejava.usesases;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Downloader implements Runnable {

	private String url;
	private int num;
	private long start;
	private long end;
	ReadableByteChannel rbc;

	public Downloader(String url, int num, long start, long end,
			ReadableByteChannel rbc) {
		this.url = url;
		this.num = num;
		this.start = start;
		this.end = end;
		this.rbc = rbc;
	}

	@Override
	public void run() {
		download();
	}

	private void download() {
		try {
			System.out.println(num + " is executing");
			URL file = new URL(url);
			FileOutputStream stream = new FileOutputStream("D:\\java\\kholal\\output\\temp" + num);
			stream.getChannel().transferFrom(rbc, start, end);
		} catch (MalformedURLException ex) {
			Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (IOException ex) {
			Logger.getLogger(Downloader.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

}