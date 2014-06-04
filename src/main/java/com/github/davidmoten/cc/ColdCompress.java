package com.github.davidmoten.cc;

import java.nio.ByteBuffer;
import java.util.TreeSet;

public class ColdCompress {

	final static private int[] flagBits = new int[] { 1, 2, 4, 8, 16, 32, 64,
			128 };

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
	}

	public byte[] compress(byte[] bytes) {
		TreeSet<Byte> set = new TreeSet<Byte>();
		for (byte b : bytes)
			set.add(b);
		short numKeys = (short) set.size();
		short offset = set.first();
		TreeSet<Byte> set2 = new TreeSet<Byte>();
		for (byte b : bytes)
			set2.add((byte) (b - offset));
		System.out.println(numKeys + " keys");
		System.out.println(set2.last() + " is highest value of keys");
		System.out.println("offset=" + offset);

		int bitsPerKey = 0;
		for (int i = 0; i < flagBits.length; i++) {
			if ((flagBits[i] & numKeys) == flagBits[i]) {
				bitsPerKey = i;
			}
		}
		bitsPerKey += 1;
		System.out.println("bitsPerKey = " + bitsPerKey);

		short totalSize = 8192;

		ByteBuffer bb = ByteBuffer.allocate(bytes.length);
		bb.putShort(totalSize);
		bb.putShort((short) bytes.length);
		bb.putShort(numKeys);
		return null;
	}

	public byte[] decompress(byte[] bytes) {
		return null;
	}

}
