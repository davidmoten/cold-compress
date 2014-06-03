package com.github.davidmoten.cc;

import java.util.Arrays;
import java.util.TreeSet;

public class ColdCompress {

	final TreeSet<Integer> sizes;

	/**
	 * <p>
	 * Format is
	 * </p>
	 * 
	 * <ul>
	 * <li>sizeBytes(2 bytes)</li>
	 * <li>numEntries (2 bytes)</li>
	 * <li>numKeys (2 bytes)</li>
	 * <li>bitsPerKey (1 byte)</li>
	 * <li>key offset (1 byte)</li>
	 * <li>numKeys * bitsPerKey bits</li>
	 * <li>bodyBits</li>
	 * <li>
	 * </li>
	 * </ul>
	 */
	public ColdCompress() {
		sizes = new TreeSet<Integer>(Arrays.asList(1, 2, 4, 16, 32, 128, 256));
	}

	public byte[] compress(byte[] bytes) {
		TreeSet<Byte> set = new TreeSet<Byte>();
		for (byte b : bytes)
			set.add(b);
		int n = set.size();
		short offset = set.first();
		TreeSet<Byte> set2 = new TreeSet<Byte>();
		for (byte b : bytes)
			set2.add((byte) (b - offset));
		System.out.println(n + " keys");
		System.out.println(set2.last() + " is highest value of keys");
		System.out.println("offset=" + offset);
		return null;
	}

	public byte[] decompress(byte[] bytes) {
		return null;
	}

}
