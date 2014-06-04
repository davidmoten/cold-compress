package com.github.davidmoten.cc;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class ColdCompressTest {

	@Test
	public void test() throws IOException {
		InputStream is = ColdCompress.class.getResourceAsStream("/test.txt");
		byte[] bytes = new byte[8192];
		int count = is.read(bytes);
		System.out.println(count);
		System.out.println(new ColdCompress().compress(bytes));
		is.close();
	}

}
