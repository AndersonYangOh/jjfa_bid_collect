package com.longl.unicom.yjy.reptilebid.util;

import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
 


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
 
public class HTTPSUtil {
	
	private static void trustAllHttpsCertificates() throws Exception {
		TrustManager[] trustAllCerts = new TrustManager[1];
		TrustManager tm = new miTM();
		trustAllCerts[0] = tm;
		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, null);
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
	}
	
	
	static class miTM implements TrustManager,X509TrustManager {
		public X509Certificate[] getAcceptedIssuers() {
			return null;
		}
		public boolean isServerTrusted(X509Certificate[] certs) {
			return true;
		}
		public boolean isClientTrusted(X509Certificate[] certs) {
			return true;
		}
		public void checkServerTrusted(X509Certificate[] certs, String authType)
				throws CertificateException {
			return;
		}
		public void checkClientTrusted(X509Certificate[] certs, String authType)
				throws CertificateException {
			return;
		}
	}
	
	/**
	 * 忽略HTTPS请求的SSL证书
	* @throws Exception
	 */
	public static void ignoreSsl() throws Exception{
		HostnameVerifier hv = new HostnameVerifier() {
			public boolean verify(String urlHostName, SSLSession session) {
				System.out.println("Warning: URL Host: " + urlHostName + " vs. " + session.getPeerHost());
				return true;
			}
		};
		trustAllHttpsCertificates();
		HttpsURLConnection.setDefaultHostnameVerifier(hv);
	}
	
	public static void main(String[] args) throws Exception {
		//https://b2b.10086.cn/b2b/main/listVendorNotice.html?noticeType=2
		URL u = new URL("https://b2b.10086.cn/b2b/main/listVendorNoticeResult.html?noticeBean.noticeType=2");
		if("https".equalsIgnoreCase(u.getProtocol())){
			HTTPSUtil.ignoreSsl();
		}
		Document doc = Jsoup.connect(u.toString()).get();
		System.out.println(doc.html());
//		Parser parser;
//		parser = new Parser(u.toString());
//		parser.setEncoding("UTF-8");
//		TextExtractingVisitor tev=new TextExtractingVisitor();
//		parser.visitAllNodesWith(tev);
//		String body=tev.getExtractedText();
//		System.out.println(body);
	}
}

